package com.odmytrenko.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odmytrenko.dto.ExchangeInfo;
import com.odmytrenko.model.ExchangeProvider;
import com.odmytrenko.model.finance.FinanceProviderInfo;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Qualifier("finance")
public class FinanceExchangeService implements ExchangeService {
    @Override
    public ExchangeProvider getExchangeProviderInfo() {
        try {
            String json = Jsoup.connect("http://resources.finance.ua/ru/public/currency-cash.json").ignoreContentType(true).execute().body();
            ObjectMapper mapper = new ObjectMapper();
            FinanceProviderInfo response = mapper.readValue(json, FinanceProviderInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ExchangeInfo getExchangeInfo() {
        return null;
    }
}
