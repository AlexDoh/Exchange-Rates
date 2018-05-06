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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Qualifier("kurs")
public class KursExchangeService implements ExchangeService {

    private static final Logger LOG = LoggerFactory.getLogger(FinanceExchangeService.class);

    @Autowired
    ExchangeProviderRepository exchangeProviderRepository;

    @Value("${providers.kurs.url}")
    private String URL;

    @Value("${providers.kurs.title}")
    private String TITLE_KURS_UA;

    @Value("${providers.kurs.link}")
    private String LINK_KURS_COM_UA;

    @Value("${providers.finance.title}")
    private String TITLE_FINANCE_UA;

    @Override
    public KursProviderInfo getExchangeProviderInfo() {
        LOG.info("Requesting kurs provider info from {}", URL);
        KursProviderInfo kursProviderInfo = new KursProviderInfo();
        kursProviderInfo.setTitle(TITLE_KURS_UA);
        kursProviderInfo.setLink(LINK_KURS_COM_UA);

        List<KursOrganization> kursOrganizationSet = new ArrayList<>();
        kursProviderInfo.setOrganizations(kursOrganizationSet);

        for (int i = 1; i < 400; i++) {
            StringBuilder url = new StringBuilder(URL);
            url.append(i);
            url.append("-a/");

            KursOrganization kursOrganization = new KursOrganization();

            try {
                LOG.info("Requesting kurs provider info from page {}", url);
                Document document = Jsoup.connect(url.toString()).ignoreHttpErrors(true).get();

                kursOrganization.setId(UUID.randomUUID().toString());
                Elements bankName = document.getElementsByClass("ipsType_pageTitle");

                if (bankName.isEmpty()) {
                    LOG.debug("This kurs provider bank page {} doesn't exist", url);
                    continue;
                }

                String bankNameString = bankName.get(0).text().replace("Курс валют — ", "");
                LOG.debug("Kurs provider bankName from page {} - {}", url, bankNameString);
                kursOrganization.setTitle(bankNameString);
                kursOrganization.setLink(document.location());
                kursOrganization.setAddress(document.getElementsByAttributeValue("title", "Показать на карте").text());
                Elements phone = document.select("div.ipsGrid_span3:contains(Телефоны)");

                if (!phone.isEmpty()) {
                    String phoneString = phone.get(0).siblingElements().get(0).text();
                    LOG.debug("Kurs provider phone from page {} - {}", url, phoneString);
                    kursOrganization.setPhone(phoneString);
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
                    LOG.debug("Kurs provider currencyType from page {} - {}", url, currencyType);

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
                throw new RuntimeException("Error getting kurs provider info: " + e.getMessage(), e.getCause());
            }
        }
        return kursProviderInfo;
    }

    @Override
    public ExchangeProvider save(ExchangeProvider provider) {
        return exchangeProviderRepository.save(provider);
    }

    @Override
    public boolean existsById(String title) {
        return exchangeProviderRepository.existsById(title);
    }

    @Override
    public Optional<ExchangeProvider> findById(String title) {
        Optional<ExchangeProvider> kursProviderOptional = exchangeProviderRepository.findById(title);
        Optional<ExchangeProvider> financeProviderOptional = exchangeProviderRepository.findById(TITLE_FINANCE_UA);
        if (financeProviderOptional.isPresent()) {
            FinanceProviderInfo financeProvider = (FinanceProviderInfo) financeProviderOptional.get();
            return kursProviderOptional.map(provider -> {
                KursProviderInfo kursProvider = (KursProviderInfo) provider;
                kursProvider.setOrgTypes(financeProvider.getOrgTypes());
                kursProvider.setCurrencies(financeProvider.getCurrencies());
                return kursProvider;
            });
        }
        return kursProviderOptional;
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
