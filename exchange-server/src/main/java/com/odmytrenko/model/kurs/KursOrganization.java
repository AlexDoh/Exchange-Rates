package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.odmytrenko.model.ExchangeOrganization;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "ORGANIZATIONS_KURS")
public class KursOrganization extends ExchangeOrganization {

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
    @MapKeyColumn(name = "TYPE")
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORGANIZATION_ID")
    private Map<String, KursCurrencyRates> currencies;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID")
    private KursProviderInfo provider;
}
