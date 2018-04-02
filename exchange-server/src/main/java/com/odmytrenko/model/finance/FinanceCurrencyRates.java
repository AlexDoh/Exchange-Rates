package com.odmytrenko.model.finance;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class FinanceCurrencyRates {

    @JsonProperty
    private String ask;
    @JsonProperty
    private String bid;
}
