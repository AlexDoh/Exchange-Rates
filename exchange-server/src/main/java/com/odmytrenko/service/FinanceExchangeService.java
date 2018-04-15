package com.odmytrenko.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.odmytrenko.model.ExchangeProvider;
import com.odmytrenko.model.finance.FinanceProviderInfo;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
@Qualifier("finance")
public class FinanceExchangeService implements ExchangeService {
    @Override
    public ExchangeProvider getExchangeProviderInfo() {
        try {
            String json = Jsoup.connect("http://resources.finance.ua/ru/public/currency-cash.json")
                .ignoreContentType(true).execute().body();
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
            mapper.configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, false);
//            FinanceProviderInfo financeProviderInfo = mapper.readValue(json, FinanceProviderInfo.class);
//            financeProviderInfo.getOrganizations().forEach(financeOrganization -> financeOrganization.setId(UUID.randomUUID()));
            return mapper.readValue(json, FinanceProviderInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error during parse json object: " + e.getMessage(), e.getCause());
        }
    }
}
