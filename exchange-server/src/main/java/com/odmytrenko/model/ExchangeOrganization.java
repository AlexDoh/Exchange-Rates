package com.odmytrenko.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@Entity
@Table(name = "ORGANIZATIONS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ExchangeOrganization {

    @Id
    @Column(name = "ORGANIZATION_ID")
    private String id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "LINK")
    private String link;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
}
