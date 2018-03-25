package com.odmytrenko.model;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BankInfo bankInfo = (BankInfo) o;
        return Objects.equals(getBankName(), bankInfo.getBankName()) &&
                Objects.equals(getLink(), bankInfo.getLink()) &&
                Objects.equals(getHeadAddress(), bankInfo.getHeadAddress()) &&
                Objects.equals(getCurrencyInfos(), bankInfo.getCurrencyInfos());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getBankName(), getLink(), getHeadAddress(), getCurrencyInfos());
    }
}
