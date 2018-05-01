package com.odmytrenko.model.finance;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Entity
@Table(name = "CURRENCY_RATES_FINANCE")
@Data
public class FinanceCurrencyRates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "BID")
    private String bid;
    @Column(name = "ASK")
    private String ask;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID")
    private FinanceOrganization organization;
}
