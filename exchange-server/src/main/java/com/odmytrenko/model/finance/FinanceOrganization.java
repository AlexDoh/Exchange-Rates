package com.odmytrenko.model.finance;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.odmytrenko.model.ExchangeOrganization;
import com.odmytrenko.model.ExchangeProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
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
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ORGANIZATIONS_FINANCE")
@PrimaryKeyJoinColumn(name = "FINANCE_ORGANIZATION_ID", referencedColumnName = "ID")
public class FinanceOrganization extends ExchangeOrganization {

    private Integer oldId;
    private Integer orgType;
    private Boolean branch;
    private String regionId;
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
