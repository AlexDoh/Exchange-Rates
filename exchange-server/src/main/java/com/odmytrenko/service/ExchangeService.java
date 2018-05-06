package com.odmytrenko.service;

import com.odmytrenko.model.ExchangeProvider;

public interface ExchangeService {

    ExchangeProvider getExchangeProviderInfo();

    ExchangeProvider save(ExchangeProvider provider);

    boolean existsByTitle(String title);

    ExchangeProvider findByTitle(String title);
}
