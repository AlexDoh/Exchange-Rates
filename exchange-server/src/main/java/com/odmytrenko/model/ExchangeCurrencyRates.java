package com.odmytrenko.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public abstract class ExchangeCurrencyRates {

    @JsonProperty
    private String bid;
    @JsonProperty
    private String ask;
}
