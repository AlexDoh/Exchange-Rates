package com.odmytrenko.service;

import com.odmytrenko.model.finance.FinanceProviderInfo;
import com.odmytrenko.model.kurs.KursProviderInfo;

public interface ExchangeService {

    FinanceProviderInfo getFinanceProviderInfo();
    KursProviderInfo getKursProviderInfo();

//    default ExchangeProvider getExchangeInfo() {
//        ExchangeProvider exchangeProvider = this.getFinanceProviderInfo();
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
