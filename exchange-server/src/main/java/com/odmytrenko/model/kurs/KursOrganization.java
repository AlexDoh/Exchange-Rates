package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeOrganization;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Entity
@Table(name = "ORGANIZATIONS_KURS")
@PrimaryKeyJoinColumn(name = "ORGANIZATION_ID",referencedColumnName = "ID")
public class KursOrganization extends ExchangeOrganization<KursCurrencyRates> {
}
