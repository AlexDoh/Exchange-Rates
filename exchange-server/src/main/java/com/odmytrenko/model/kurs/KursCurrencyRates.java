package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeCurrencyRates;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class KursCurrencyRates extends ExchangeCurrencyRates {
}
