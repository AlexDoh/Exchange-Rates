package com.odmytrenko.model.finance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odmytrenko.model.ExchangeProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode(callSuper = true)
@Data
public class FinanceProviderInfo extends ExchangeProvider<FinanceOrganization> {

    @JsonProperty
    private String sourceId;
    @JsonProperty
    private String date;
    @JsonProperty
    private Map<Integer, String> orgTypes;
    @JsonProperty
    private Map<String, String> currencies;
    @JsonProperty
    private Map<String, String> regions;
    @JsonProperty
    private Map<String, String> cities;
}
