package com.odmytrenko.model.finance;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.odmytrenko.model.ExchangeOrganization;
import com.odmytrenko.model.ExchangeProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "ORGANIZATIONS_FINANCE")
@PrimaryKeyJoinColumn(name = "FINANCE_ORGANIZATION_ID", referencedColumnName = "ORGANIZATION_ID")
public class FinanceOrganization extends ExchangeOrganization {

    @Column(name = "OLD_ID")
    private Integer oldId;
    @Column(name = "ORG_TYPE")
    private Integer orgType;
    @Column(name = "BRANCH")
    private Boolean branch;
    @Column(name = "REGION_ID")
    private String regionId;
    @Column(name = "CITY_ID")
    private String cityId;
    @MapKeyColumn(name = "TYPE")
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "organization")
    private Map<String, FinanceCurrencyRates> currencies;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID")
    private ExchangeProvider provider;
}
