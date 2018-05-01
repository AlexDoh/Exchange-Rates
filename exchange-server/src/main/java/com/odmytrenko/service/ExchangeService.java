package com.odmytrenko.service;

import com.odmytrenko.model.ExchangeProvider;

public interface ExchangeService {

    ExchangeProvider getExchangeProviderInfo();

//    default ExchangeProvider getExchangeInfo() {
//        ExchangeProvider exchangeProvider = this.getExchangeProviderInfo();
//
//        exchangeProvider.setOrgTypes(
//            Optional.ofNullable(exchangeProvider.getOrgTypes()).orElseGet(() -> BankConstants.ORG_TYPES)
//        );
//        exchangeProvider.setCurrencies(
//            Optional.ofNullable(exchangeProvider.getCurrencies()).orElseGet(() -> BankConstants.CURRENCIES)
//        );
//
//        return exchangeProvider;
//    }
}
