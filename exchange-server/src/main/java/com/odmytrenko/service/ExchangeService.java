package com.odmytrenko.service;

import com.odmytrenko.dto.ResponseExchangeInfo;
import com.odmytrenko.model.BankConstants;
import com.odmytrenko.model.ExchangeProvider;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

public interface ExchangeService {

    ExchangeProvider getExchangeProviderInfo();

    default ResponseExchangeInfo getExchangeInfo() {
        ResponseExchangeInfo responseExchangeInfo = new ResponseExchangeInfo();
        ExchangeProvider exchangeProvider = this.getExchangeProviderInfo();

        BeanUtils.copyProperties(this.getExchangeProviderInfo(), responseExchangeInfo);
        responseExchangeInfo.setOrgTypes(
            Optional.ofNullable(exchangeProvider.getOrgTypes()).orElseGet(() -> BankConstants.ORG_TYPES)
        );
        responseExchangeInfo.setCurrencies(
            Optional.ofNullable(exchangeProvider.getCurrencies()).orElseGet(() -> BankConstants.CURRENCIES)
        );

        return responseExchangeInfo;
    }
}
