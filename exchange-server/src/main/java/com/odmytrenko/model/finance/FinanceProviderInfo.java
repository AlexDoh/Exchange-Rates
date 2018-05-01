package com.odmytrenko.model.finance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@Entity
@Table(name = "PROVIDERS_FINANCE")
public class FinanceProviderInfo extends ExchangeProvider {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "PROVIDER_ID")
    private UUID id;
    @Column(name = "DATE")
    private String date;
    @Column(name = "SOURCE_ID")
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROVIDER_ID")
    private List<FinanceOrganization> organizations;
}
