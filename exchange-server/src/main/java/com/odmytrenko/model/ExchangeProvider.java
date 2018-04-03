package com.odmytrenko.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public abstract class ExchangeProvider<T> {

    @JsonProperty
    private Set<T> organizations;
}
