package com.odmytrenko.service;

import com.odmytrenko.dto.ResponseExchangeInfo;
import com.odmytrenko.model.ExchangeProvider;

public interface ExchangeService {

    ExchangeProvider getExchangeProviderInfo();

    ResponseExchangeInfo getExchangeInfo();
}
