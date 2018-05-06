package com.odmytrenko.model.finance;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeCurrencyRates;
import com.odmytrenko.model.ExchangeOrganization;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "organization")
@Entity
@Table(name = "CURRENCY_RATES_FINANCE")
@PrimaryKeyJoinColumn(name = "FINANCE_CURRENCY_RATES_ID", referencedColumnName = "ID")
public class FinanceCurrencyRates extends ExchangeCurrencyRates {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID")
    private ExchangeOrganization organization;
}
