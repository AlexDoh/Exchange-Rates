package com.odmytrenko.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public abstract class ExchangeProvider {

}
