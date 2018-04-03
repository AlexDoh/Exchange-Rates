package com.odmytrenko.model.finance;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odmytrenko.model.ExchangeCurrencyRates;
import lombok.Data;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class FinanceCurrencyRates implements ExchangeCurrencyRates {

    @JsonProperty
    private String ask;
    @JsonProperty
    private String bid;

}
