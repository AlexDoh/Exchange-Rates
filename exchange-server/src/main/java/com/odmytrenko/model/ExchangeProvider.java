package com.odmytrenko.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@ToString
@Entity
@Table(name = "PROVIDERS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ExchangeProvider {

    @Id
    @Column(name = "ID")
    private String title;
    private String link;
}
