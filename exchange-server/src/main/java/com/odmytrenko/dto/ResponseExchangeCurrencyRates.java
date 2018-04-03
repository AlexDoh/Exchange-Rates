package com.odmytrenko.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeCurrencyRates;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ResponseExchangeCurrencyRates extends ExchangeCurrencyRates {
}
