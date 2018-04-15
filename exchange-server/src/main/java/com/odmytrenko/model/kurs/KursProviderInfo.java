package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeProvider;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Entity(name = "KURS_PROVIDER")
@DiscriminatorValue("KURS")
public class KursProviderInfo extends ExchangeProvider<KursOrganization> {
}
