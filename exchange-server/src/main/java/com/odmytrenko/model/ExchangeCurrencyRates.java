package com.odmytrenko.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.UUID;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@ToString
@Entity
@Table(name = "CURRENCY_RATES")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ExchangeCurrencyRates {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String bid;
    private String ask;
}
