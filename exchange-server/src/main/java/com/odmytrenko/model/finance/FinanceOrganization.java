package com.odmytrenko.model.finance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odmytrenko.model.ExchangeOrganization;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode(callSuper = true)
@Data
public class FinanceOrganization extends ExchangeOrganization<FinanceCurrencyRates> {

    @JsonProperty
    private String id;
    @JsonProperty
    private Integer oldId;
    @JsonProperty
    private Integer orgType;
    @JsonProperty
    private Boolean branch;
    @JsonProperty
    private String regionId;
    @JsonProperty
    private String cityId;
}
