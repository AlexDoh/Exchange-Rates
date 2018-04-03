package com.odmytrenko.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class ResponseExchangeInfo {

    @JsonProperty
    private Set<ResponseExchangeOrganization> organizations;
    @JsonProperty
    private Map<Integer, String> orgTypes;
    @JsonProperty
    private Map<String, String> currencies;
}
