package com.odmytrenko.model.finance;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class FinanceCurrencyRates {

    @JsonProperty
    private BigDecimal bid;
    @JsonProperty
    private BigDecimal bidChange;
    @JsonProperty
    private BigDecimal ask;
    @JsonProperty
    private BigDecimal askChange;

}
