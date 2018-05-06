package com.odmytrenko.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@ToString
@Entity
@Table(name = "ORGANIZATIONS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ExchangeOrganization {

    @Id
    private String id;
    private String title;
    private String link;
    private String address;
    private String phone;
}
