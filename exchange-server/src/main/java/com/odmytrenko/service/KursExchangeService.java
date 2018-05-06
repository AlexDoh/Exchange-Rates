package com.odmytrenko.service;

import com.odmytrenko.dao.ExchangeProviderRepository;
import com.odmytrenko.model.ExchangeProvider;
import com.odmytrenko.model.finance.FinanceProviderInfo;
import com.odmytrenko.model.kurs.KursCurrencyRates;
import com.odmytrenko.model.kurs.KursOrganization;
import com.odmytrenko.model.kurs.KursProviderInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Qualifier("kurs")
public class KursExchangeService implements ExchangeService {

    @Autowired
    ExchangeProviderRepository exchangeProviderRepository;

    @Value("${providers.kurs.url}")
    private String URL;

    @Value("${providers.kurs.title}")
    private String TITLE_KURS_UA;

    @Value("${providers.kurs.link}")
    private String LINK_KURS_COM_UA;

    @Override
    public KursProviderInfo getExchangeProviderInfo() {
        KursProviderInfo kursProviderInfo = new KursProviderInfo();
        kursProviderInfo.setTitle(TITLE_KURS_UA);
        kursProviderInfo.setLink(LINK_KURS_COM_UA);

        FinanceProviderInfo financeProviderInfo = (FinanceProviderInfo) exchangeProviderRepository.findAll().stream().filter(provider -> provider.getTitle().equals("Finance.ua")).findFirst().get();
        kursProviderInfo.setOrgTypes(financeProviderInfo.getOrgTypes());
        kursProviderInfo.setCurrencies(financeProviderInfo.getCurrencies());

        List<KursOrganization> kursOrganizationSet = new ArrayList<>();
        kursProviderInfo.setOrganizations(kursOrganizationSet);

        for (int i = 1; i < 400; i++) {
            StringBuilder url = new StringBuilder(LINK_KURS_COM_UA);
            url.append(i);
            url.append("-a/");

            KursOrganization kursOrganization = new KursOrganization();

            try {
                Document document = Jsoup.connect(url.toString()).ignoreHttpErrors(true).get();

                Elements bankName = document.getElementsByClass("ipsType_pageTitle");
                if (bankName.isEmpty()) {
                    continue;
                }
                kursOrganization.setId(UUID.randomUUID().toString());
                kursOrganization.setTitle(bankName.get(0).text().replace("Курс валют — ", ""));
                kursOrganization.setLink(document.location());
                kursOrganization.setAddress(document.getElementsByAttributeValue("title", "Показать на карте").text());
                Elements phone = document.select("div.ipsGrid_span3:contains(Телефоны)");
                if (!phone.isEmpty()) {
                    kursOrganization.setPhone(phone.get(0).siblingElements().get(0).text());
                }

                Elements currencyTables = document.getElementsByTag("tbody");
                Element currencyTable;
                if (currencyTables.isEmpty()) {
                    continue;
                } else {
                    currencyTable = currencyTables.get(0);
                }
                Map<String, KursCurrencyRates> kursCurrencyRatesMap = new HashMap<>();
                currencyTable.getElementsByTag("tr").forEach((row) -> {
                    String currencyType = row.getElementsByClass("ipsKursTable_currency")
                        .get(0).getElementsByTag("a").get(0).text();

                    KursCurrencyRates kursCurrencyRates = new KursCurrencyRates();

                    kursCurrencyRates.setUpdated(row.getElementsByClass("ipsKursTable_updated")
                        .get(0).getElementsByTag("time").get(0).attr("datetime"));

                    kursCurrencyRates.setBid(getRateValue(row, "bid"));
                    kursCurrencyRates.setBidChange(getRateChangeValue(row, "bid"));

                    kursCurrencyRates.setAsk(getRateValue(row, "ask"));
                    kursCurrencyRates.setAskChange(getRateChangeValue(row, "ask"));

                    kursCurrencyRatesMap.put(currencyType, kursCurrencyRates);
                });
                kursOrganization.setCurrencies(kursCurrencyRatesMap);
                kursOrganizationSet.add(kursOrganization);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return kursProviderInfo;
    }

    @Override
    public ExchangeProvider save(ExchangeProvider provider) {
        return exchangeProviderRepository.save(provider);
    }

    @Override
    public boolean existsByTitle(String title) {
        return exchangeProviderRepository.existsByTitle(title);
    }

    @Override
    public ExchangeProvider findByTitle(String title) {
        return exchangeProviderRepository.findByTitle(title);
    }

    private String getRateValue(Element currencyRow, String rateType) {
        StringBuilder rateSelector = new StringBuilder(".ipsKursTable_rate[data-rate-type=");
        rateSelector.append(rateType);
        rateSelector.append(']');
        String rate = currencyRow.select(rateSelector.toString()).get(0)
            .getElementsByClass("ipsKurs_rate").text().replace(',', '.');
        if (rate.isEmpty()) {
            return "0";
        } else {
            return rate;
        }
    }

    private String getRateChangeValue(Element currencyRow, String rateType) {
        StringBuilder rateSelector = new StringBuilder(".ipsKursTable_rateChange[data-rate-type=");
        rateSelector.append(rateType);
        rateSelector.append("_change]");
        String rate = currencyRow.select(rateSelector.toString()).get(0)
            .getElementsByClass("ipsKurs_rateChange").text().replace(',', '.');
        if (rate.isEmpty()) {
            return "0";
        } else {
            return rate;
        }
    }
}
