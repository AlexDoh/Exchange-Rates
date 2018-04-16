package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeProvider;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Entity
@Table(name = "PROVIDERS_KURS")
@PrimaryKeyJoinColumn(name = "PROVIDER_ID",referencedColumnName = "ID")
public class KursProviderInfo extends ExchangeProvider<KursOrganization> {
}
