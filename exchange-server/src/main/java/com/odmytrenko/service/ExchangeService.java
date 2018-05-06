package com.odmytrenko.service;

import com.odmytrenko.model.ExchangeProvider;

import java.util.Optional;

public interface ExchangeService {

    ExchangeProvider getExchangeProviderInfo();

    ExchangeProvider save(ExchangeProvider provider);

    boolean existsById(String title);

    Optional<ExchangeProvider> findById(String title);
}
