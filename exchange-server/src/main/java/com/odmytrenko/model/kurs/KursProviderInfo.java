package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odmytrenko.model.ExchangeProvider;
import lombok.Data;

import java.util.Set;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class KursProviderInfo implements ExchangeProvider {

    @JsonProperty
    private Set<KursOrganization> organizations;
}
