package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeCurrencyRates;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Entity
@Table(name = "CURRENCY_RATES_KURS")
@PrimaryKeyJoinColumn(name = "CURRENCY_RATES_ID",referencedColumnName = "ID")
public class KursCurrencyRates extends ExchangeCurrencyRates {
}
