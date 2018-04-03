package com.odmytrenko.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeOrganization;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ResponseExchangeOrganization extends ExchangeOrganization<ResponseExchangeCurrencyRates> {
}
