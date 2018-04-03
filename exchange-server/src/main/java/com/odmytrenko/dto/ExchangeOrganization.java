package com.odmytrenko.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odmytrenko.model.finance.FinanceCurrencyRates;
import lombok.Data;

import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class ExchangeOrganization {

    @JsonProperty
    private String title;
    @JsonProperty
    private String phone;
    @JsonProperty
    private String address;
    @JsonProperty
    private String link;
    @JsonProperty
    private Map<String, FinanceCurrencyRates> currencies;
}
