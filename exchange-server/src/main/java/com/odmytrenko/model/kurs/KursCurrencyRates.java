package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeCurrencyRates;
import lombok.Data;

import java.math.BigDecimal;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class KursCurrencyRates implements ExchangeCurrencyRates {

    private String updated;
    private BigDecimal bid;
    private BigDecimal bidChange;
    private BigDecimal ask;
    private BigDecimal askChange;
}
