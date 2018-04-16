package com.odmytrenko.model.finance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeOrganization;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "ORGANIZATIONS_FINANCE")
@PrimaryKeyJoinColumn(name = "ORGANIZATION_ID",referencedColumnName = "ID")
public class FinanceOrganization extends ExchangeOrganization<FinanceCurrencyRates> {

    @Column(name="OLD_ID")
    private Integer oldId;
    @Column(name="ORG_TYPE")
    private Integer orgType;
    @Column(name="BRANCH")
    private Boolean branch;
    @Column(name="REGION_ID")
    private String regionId;
    @Column(name="CITY_ID")
    private String cityId;
}
