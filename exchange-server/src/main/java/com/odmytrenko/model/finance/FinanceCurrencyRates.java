package com.odmytrenko.model.finance;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeCurrencyRates;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Entity(name = "FINANCE_RATES")
@DiscriminatorValue("FINANCE")
public class FinanceCurrencyRates extends ExchangeCurrencyRates {
}
