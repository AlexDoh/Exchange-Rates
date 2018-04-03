package com.odmytrenko.service;

import com.odmytrenko.dto.ExchangeInfo;
import com.odmytrenko.model.kurs.KursOrganization;
import com.odmytrenko.model.kurs.KursCurrencyInfo;
import com.odmytrenko.model.kurs.KursProviderInfo;
import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
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
                kursOrganization.setPhone(document.select("div.ipsGrid_span3:contains(Телефоны)").get(0).siblingElements().get(0).text());

                Elements currencyTables = document.getElementsByTag("tbody");
                Element currencyTable;
                if (currencyTables.isEmpty()) {
                    continue;
                } else {
                    currencyTable = currencyTables.get(0);
                }
                Set<KursCurrencyInfo> kursCurrencyInfoSet = new HashSet<>();
                currencyTable.getElementsByTag("tr").forEach((row) -> {
                    KursCurrencyInfo kursCurrencyInfo = new KursCurrencyInfo();

                    kursCurrencyInfo.setType(row.getElementsByClass("ipsKursTable_currency")
                    .get(0).getElementsByTag("a").get(0).text());

                    kursCurrencyInfo.setUpdated(row.getElementsByClass("ipsKursTable_updated")
                    .get(0).getElementsByTag("time").get(0).attr("datetime"));

                    kursCurrencyInfo.setBid(getRateValue(row, "bid"));
                    kursCurrencyInfo.setBidChange(getRateChangeValue(row, "bid"));

                    kursCurrencyInfo.setAsk(getRateValue(row, "ask"));
                    kursCurrencyInfo.setAskChange(getRateChangeValue(row, "ask"));

                    kursCurrencyInfoSet.add(kursCurrencyInfo);
                });
                kursOrganization.setCurrencyInfos(kursCurrencyInfoSet);
                kursOrganizationSet.add(kursOrganization);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return kursProviderInfo;
    }

    @Override
    public ExchangeInfo getExchangeInfo() {
        ExchangeInfo exchangeInfo = new ExchangeInfo();
        KursProviderInfo exchangeProvider = this.getExchangeProviderInfo();
        return exchangeInfo;
    }

    private BigDecimal getRateValue(Element currencyRow, String rateType) {
        StringBuilder rateSelector = new StringBuilder(".ipsKursTable_rate[data-rate-type=");
        rateSelector.append(rateType);
        rateSelector.append(']');
        String rate = currencyRow.select(rateSelector.toString()).get(0)
        .getElementsByClass("ipsKurs_rate").text().replace(',', '.');
        if (rate.isEmpty()) {
            return NumberUtils.createBigDecimal("0");
        } else {
            return NumberUtils.createBigDecimal(rate);
        }
    }

    private BigDecimal getRateChangeValue(Element currencyRow, String rateType) {
        StringBuilder rateSelector = new StringBuilder(".ipsKursTable_rateChange[data-rate-type=");
        rateSelector.append(rateType);
        rateSelector.append("_change]");
        String rate = currencyRow.select(rateSelector.toString()).get(0)
        .getElementsByClass("ipsKurs_rateChange").text().replace(',', '.');
        if (rate.isEmpty()) {
            return NumberUtils.createBigDecimal("0");
        } else {
            return NumberUtils.createBigDecimal(rate);
        }
    }
}
