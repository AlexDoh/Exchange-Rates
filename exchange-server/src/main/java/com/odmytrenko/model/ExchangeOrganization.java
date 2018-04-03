package com.odmytrenko.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public abstract class ExchangeOrganization<T> {

    @JsonProperty
    private String title;
    @JsonProperty
    private String link;
    @JsonProperty
    private String address;
    @JsonProperty
    private String phone;
    @JsonProperty
    private Map<String, T> currencies;
}
