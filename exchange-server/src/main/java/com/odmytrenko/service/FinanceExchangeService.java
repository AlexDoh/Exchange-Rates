package com.odmytrenko.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odmytrenko.configuration.ProvidersProperties;
import com.odmytrenko.model.finance.FinanceProviderInfo;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Qualifier("finance")
public class FinanceExchangeService implements ExchangeService {

    @Autowired
    ProvidersProperties providersProperties;

    @Override
    public FinanceProviderInfo getExchangeProviderInfo() {
        try {
            String json = Jsoup.connect("http://resources.finance.ua/ru/public/currency-cash.json")
                .ignoreContentType(true).execute().body();
            ObjectMapper mapper = new ObjectMapper();
            FinanceProviderInfo financeProviderInfo = mapper.readValue(json, FinanceProviderInfo.class);
            financeProviderInfo.setTitle(providersProperties.getFinance().get("name"));
            financeProviderInfo.setLink(providersProperties.getFinance().get("link"));
            return financeProviderInfo;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error during parse json object: " + e.getMessage(), e.getCause());
        }
    }
}
