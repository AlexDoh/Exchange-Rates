package com.odmytrenko.service;

import com.odmytrenko.dto.ExchangeInfo;
import com.odmytrenko.model.ExchangeProvider;

public interface ExchangeService {

    ExchangeProvider getExchangeProviderInfo();

    ExchangeInfo getExchangeInfo();
}
