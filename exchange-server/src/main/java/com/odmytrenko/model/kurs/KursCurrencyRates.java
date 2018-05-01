package com.odmytrenko.model.kurs;

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
@Table(name = "CURRENCY_RATES_KURS")
@Data
public class KursCurrencyRates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "BID")
    private String bid;
    @Column(name = "ASK")
    private String ask;
    @Column(name = "UPDATED")
    private String updated;
    @Column(name = "BID_CHANGE")
    private String bidChange;
    @Column(name = "ASK_CHANGE")
    private String askChange;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID")
    private KursOrganization organization;
}
