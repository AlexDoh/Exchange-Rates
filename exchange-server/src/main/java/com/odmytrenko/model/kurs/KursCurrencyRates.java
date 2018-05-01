package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeCurrencyRates;
import com.odmytrenko.model.ExchangeOrganization;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CURRENCY_RATES_KURS")
@PrimaryKeyJoinColumn(name = "KURS_CURRENCY_RATES_ID", referencedColumnName = "ID")
public class KursCurrencyRates extends ExchangeCurrencyRates {

    private String updated;
    private String bidChange;
    private String askChange;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID")
    private ExchangeOrganization organization;
}
