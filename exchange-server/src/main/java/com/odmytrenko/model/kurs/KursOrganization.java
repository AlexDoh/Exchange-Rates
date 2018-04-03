package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeOrganization;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class KursOrganization extends ExchangeOrganization<KursCurrencyRates> {
}
