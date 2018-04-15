package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeOrganization;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Entity(name = "KURS_ORGANIZATION")
@DiscriminatorValue("KURS")
public class KursOrganization extends ExchangeOrganization<KursCurrencyRates> {
}
