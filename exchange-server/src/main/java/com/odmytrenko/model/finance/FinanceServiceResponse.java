package com.odmytrenko.model.finance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class FinanceServiceResponse {

    @JsonProperty
    private String sourceId;
    @JsonProperty
    private String date;
    @JsonProperty
    private Set<FinanceOrganization> organizations;
    @JsonProperty
    private Map<Integer, String> orgTypes;
    @JsonProperty
    private Map<String, String> currencies;
    @JsonProperty
    private Map<String, String> regions;
    @JsonProperty
    private Map<String, String> cities;
}
