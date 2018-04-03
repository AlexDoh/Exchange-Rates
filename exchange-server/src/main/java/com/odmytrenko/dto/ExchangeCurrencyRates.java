package com.odmytrenko.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class ExchangeCurrencyRates {

    @JsonProperty
    private String ask;
    @JsonProperty
    private String bid;
}
