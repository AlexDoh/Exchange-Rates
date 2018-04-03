package com.odmytrenko.model.finance;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeCurrencyRates;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class FinanceCurrencyRates extends ExchangeCurrencyRates {
}
