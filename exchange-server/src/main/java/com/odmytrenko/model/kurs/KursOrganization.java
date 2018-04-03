package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class KursOrganization {

    @JsonProperty
    private String title;
    @JsonProperty
    private String link;
    @JsonProperty
    private String address;
    @JsonProperty
    private String phone;
    @JsonProperty
    private Set<KursCurrencyInfo> currencyInfos;
}
