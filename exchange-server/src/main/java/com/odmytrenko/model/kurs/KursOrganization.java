package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odmytrenko.model.ExchangeOrganization;
import lombok.Data;

import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class KursOrganization<T> implements ExchangeOrganization {

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
