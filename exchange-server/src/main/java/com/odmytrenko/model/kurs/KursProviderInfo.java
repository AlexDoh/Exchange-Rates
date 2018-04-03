package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeProvider;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class KursProviderInfo extends ExchangeProvider<KursOrganization> {
}
