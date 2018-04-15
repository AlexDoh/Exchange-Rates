package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeCurrencyRates;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Entity(name = "KURS_RATES")
@DiscriminatorValue("KURS")
public class KursCurrencyRates extends ExchangeCurrencyRates {
}
