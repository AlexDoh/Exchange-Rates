package com.odmytrenko.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class CurrencyInfo {

    private String type;
    private String updated;
    private BigDecimal bid;
    private BigDecimal bidChange;
    private BigDecimal ask;
    private BigDecimal askChange;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CurrencyInfo that = (CurrencyInfo) o;
        return Objects.equals(getType(), that.getType()) &&
                Objects.equals(getUpdated(), that.getUpdated()) &&
                Objects.equals(getBid(), that.getBid()) &&
                Objects.equals(getBidChange(), that.getBidChange()) &&
                Objects.equals(getAsk(), that.getAsk()) &&
                Objects.equals(getAskChange(), that.getAskChange());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getType(), getUpdated(), getBid(), getBidChange(), getAsk(), getAskChange());
    }
}
