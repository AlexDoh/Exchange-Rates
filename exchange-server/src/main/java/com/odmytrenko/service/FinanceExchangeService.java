package com.odmytrenko.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odmytrenko.dao.ExchangeProviderRepository;
import com.odmytrenko.model.ExchangeProvider;
import com.odmytrenko.model.finance.FinanceProviderInfo;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@Qualifier("finance")
public class FinanceExchangeService implements ExchangeService {

    private static final Logger LOG = LoggerFactory.getLogger(FinanceExchangeService.class);

    @Autowired
    ExchangeProviderRepository exchangeProviderRepository;

    @Value("${providers.finance.url}")
    private String URL;

    @Value("${providers.finance.title}")
    private String TITLE_FINANCE_UA;

    @Value("${providers.finance.link}")
    private String LINK_FINANCE_COM_UA;

    @Override
    public FinanceProviderInfo getExchangeProviderInfo() {
        LOG.info("Requesting provider info from {}", URL);
        try {
            String json = Jsoup.connect(URL)
                .ignoreContentType(true).execute().body();
            ObjectMapper mapper = new ObjectMapper();
            FinanceProviderInfo financeProviderInfo = mapper.readValue(json, FinanceProviderInfo.class);
            financeProviderInfo.setTitle(TITLE_FINANCE_UA);
            financeProviderInfo.setLink(LINK_FINANCE_COM_UA);
            return financeProviderInfo;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error during parse json object: " + e.getMessage(), e.getCause());
        }
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
        return exchangeProviderRepository.findById(title);
    }
}
