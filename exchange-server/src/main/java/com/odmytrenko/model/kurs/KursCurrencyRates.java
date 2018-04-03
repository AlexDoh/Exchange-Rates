package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odmytrenko.model.ExchangeCurrencyRates;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode(callSuper = true)
@Data
public class KursCurrencyRates extends ExchangeCurrencyRates {

    @JsonProperty
    private String updated;
    @JsonProperty
    private String bidChange;
    @JsonProperty
    private String askChange;
}
