package com.odmytrenko.model.finance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class FinanceOrganization {

    @JsonProperty
    private String id;
    @JsonProperty
    private Integer oldId;
    @JsonProperty
    private Integer orgType;
    @JsonProperty
    private Boolean branch;
    @JsonProperty
    private String title;
    @JsonProperty
    private String regionId;
    @JsonProperty
    private String cityId;
    @JsonProperty
    private String phone;
    @JsonProperty
    private String address;
    @JsonProperty
    private String link;
    @JsonProperty
    private Map<String, FinanceCurrencyRates> currencies;
}
