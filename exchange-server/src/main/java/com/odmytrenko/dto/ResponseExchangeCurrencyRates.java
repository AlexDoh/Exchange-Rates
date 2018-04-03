package com.odmytrenko.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odmytrenko.model.ExchangeCurrencyRates;
import lombok.Data;

import java.math.BigDecimal;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class ResponseExchangeCurrencyRates implements ExchangeCurrencyRates {

    @JsonProperty
    private BigDecimal bid;
    @JsonProperty
    private BigDecimal bidChange;
    @JsonProperty
    private BigDecimal ask;
    @JsonProperty
    private BigDecimal askChange;
    @JsonProperty
    private String updated;
}
