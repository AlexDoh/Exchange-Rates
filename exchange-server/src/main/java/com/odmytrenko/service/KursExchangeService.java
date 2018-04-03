package com.odmytrenko.service;

import com.odmytrenko.dto.ResponseExchangeInfo;
import com.odmytrenko.dto.ResponseExchangeOrganization;
import com.odmytrenko.model.ExchangeOrganization;
import com.odmytrenko.model.kurs.KursOrganization;
import com.odmytrenko.model.kurs.KursCurrencyRates;
import com.odmytrenko.model.kurs.KursProviderInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
@Qualifier("kurs")
public class KursExchangeService implements ExchangeService {

    @Override
    public KursProviderInfo getExchangeProviderInfo() {
        KursProviderInfo kursProviderInfo = new KursProviderInfo();
        Set<KursOrganization> kursOrganizationSet = new HashSet<>();
        kursProviderInfo.setOrganizations(kursOrganizationSet);

        for (int i = 1; i < 400; i++) {
            StringBuilder url = new StringBuilder("https://kurs.com.ua/bank/");
            url.append(i);
            url.append("-a/");

            KursOrganization kursOrganization = new KursOrganization();

            try {
                Document document = Jsoup.connect(url.toString()).ignoreHttpErrors(true).get();

                Elements bankName = document.getElementsByClass("ipsType_pageTitle");
                if (bankName.isEmpty()) {
                    continue;
                }

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
    public ResponseExchangeInfo getExchangeInfo() {
        ResponseExchangeInfo responseExchangeInfo = new ResponseExchangeInfo();
        KursProviderInfo exchangeProvider = this.getExchangeProviderInfo();
        Set<KursOrganization> kursOrganizations = exchangeProvider.getOrganizations();
        Set<ResponseExchangeOrganization> exchangeOrganizations = new HashSet<>();
        kursOrganizations.forEach((ExchangeOrganization organization) -> {
            ResponseExchangeOrganization responseExchangeOrganization = new ResponseExchangeOrganization();
            responseExchangeOrganization.setAddress(organization.getAddress());
            responseExchangeOrganization.setLink(organization.getLink());
            responseExchangeOrganization.setPhone(organization.getPhone());
            responseExchangeOrganization.setTitle(organization.getTitle());
            responseExchangeOrganization.setCurrencies(organization.getCurrencies());

            exchangeOrganizations.add(responseExchangeOrganization);
        });
        responseExchangeInfo.setOrganizations(exchangeOrganizations);
        return responseExchangeInfo;
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
