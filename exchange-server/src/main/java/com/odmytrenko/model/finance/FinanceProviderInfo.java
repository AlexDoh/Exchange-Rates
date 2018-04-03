package com.odmytrenko.model.finance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odmytrenko.model.ExchangeProvider;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class FinanceProviderInfo<T> implements ExchangeProvider {

    @JsonProperty
    private String sourceId;
    @JsonProperty
    private String date;
    @JsonProperty
    private Set<T> organizations;
    @JsonProperty
    private Map<Integer, String> orgTypes;
    @JsonProperty
    private Map<String, String> currencies;
    @JsonProperty
    private Map<String, String> regions;
    @JsonProperty
    private Map<String, String> cities;
}
