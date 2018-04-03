package com.odmytrenko.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public abstract class ExchangeProvider<T> {

    @JsonProperty
    private Set<T> organizations;
    @JsonProperty
    private Map<Integer, String> orgTypes;
    @JsonProperty
    private Map<String, String> currencies;
    @JsonProperty
    private String date;
}
