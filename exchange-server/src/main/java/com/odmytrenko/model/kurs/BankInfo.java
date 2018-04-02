package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;
import java.util.Set;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class BankInfo {

    @JsonProperty
    private String bankName;
    @JsonProperty
    private String link;
    @JsonProperty
    private String headAddress;
    @JsonProperty
    private Set<CurrencyInfo> currencyInfos;
}
