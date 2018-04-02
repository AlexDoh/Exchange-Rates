package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class CurrencyInfo {

    private String type;
    private String updated;
    private BigDecimal bid;
    private BigDecimal bidChange;
    private BigDecimal ask;
    private BigDecimal askChange;
}
