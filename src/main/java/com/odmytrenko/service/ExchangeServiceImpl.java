package com.odmytrenko.service;

import com.odmytrenko.model.BankInfo;
import com.odmytrenko.model.CurrencyInfo;
import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    @Override
    public Set<BankInfo> getBankInfos() {
        Set<BankInfo> bankInfoSet = new HashSet<>();

        for (int i = 1; i < 400; i++) {
            StringBuilder url = new StringBuilder("https://kurs.com.ua/bank/");
            url.append(i);
            url.append("-a/");

            BankInfo bankInfo = new BankInfo();

            try {
                Document document = Jsoup.connect(url.toString()).ignoreHttpErrors(true).get();

                Elements bankName = document.getElementsByClass("ipsType_pageTitle");
                if (bankName.isEmpty()) {
                    continue;
                }

                bankInfo.setBankName(bankName.get(0).text().replace("Курс валют — ", ""));
                bankInfo.setLink(document.location());
                bankInfo.setHeadAddress(document.getElementsByAttributeValue("title", "Показать на карте").text());

                Elements currencyTables = document.getElementsByTag("tbody");
                Element currencyTable;
                if (currencyTables.isEmpty()) {
                    continue;
                } else {
                    currencyTable = currencyTables.get(0);
                }
                Set<CurrencyInfo> currencyInfoSet = new HashSet<>();
                currencyTable.getElementsByTag("tr").forEach((row) -> {
                    CurrencyInfo currencyInfo = new CurrencyInfo();

                    currencyInfo.setType(row.getElementsByClass("ipsKursTable_currency").get(0).getElementsByTag("a").get(0).text());

                    currencyInfo.setUpdated(LocalDateTime.parse(
                            row.getElementsByClass("ipsKursTable_updated").get(0).getElementsByTag(
                                    "time").get(0).attr("title"),
                            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm' '")));

                    currencyInfo.setBid(getRateValue(row, "bid"));
                    currencyInfo.setBidChange(getRateChangeValue(row, "bid"));

                    currencyInfo.setAsk(getRateValue(row, "ask"));
                    currencyInfo.setAskChange(getRateChangeValue(row, "ask"));

                    currencyInfoSet.add(currencyInfo);
                });
                bankInfo.setCurrencyInfos(currencyInfoSet);
                bankInfoSet.add(bankInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bankInfoSet;
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
