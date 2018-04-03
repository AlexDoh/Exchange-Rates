package com.odmytrenko.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odmytrenko.model.ExchangeProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseExchangeInfo extends ExchangeProvider<ResponseExchangeOrganization> {

    @JsonProperty
    private Map<Integer, String> orgTypes;
    @JsonProperty
    private Map<String, String> currencies;
}
