package com.odmytrenko.model.finance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.odmytrenko.model.ExchangeProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "PROVIDERS_FINANCE")
@PrimaryKeyJoinColumn(name = "FINANCE_PROVIDER_ID", referencedColumnName = "ID")
public class FinanceProviderInfo extends ExchangeProvider {

    private String date;
    private String sourceId;
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "REGIONS", joinColumns = @JoinColumn(name = "PROVIDER_ID"))
    @MapKeyClass(String.class)
    @MapKeyColumn(name = "REGION_CODE")
    @Column(name = "DESCRIPTION")
    private Map<String, String> regions;
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "CITIES", joinColumns = @JoinColumn(name = "PROVIDER_ID"))
    @MapKeyClass(String.class)
    @MapKeyColumn(name = "CITY_CODE")
    @Column(name = "DESCRIPTION")
    private Map<String, String> cities;
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "ORG_TYPES", joinColumns = @JoinColumn(name = "PROVIDER_ID"))
    @MapKeyClass(String.class)
    @MapKeyColumn(name = "TYPE")
    @Column(name = "DESCRIPTION")
    private Map<String, String> orgTypes;
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "CURRENCIES", joinColumns = @JoinColumn(name = "PROVIDER_ID"))
    @MapKeyClass(String.class)
    @MapKeyColumn(name = "CURRENCY")
    @Column(name = "DESCRIPTION")
    private Map<String, String> currencies;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "PROVIDER_ID")
    private List<FinanceOrganization> organizations;
}
