package com.odmytrenko.model.finance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "PROVIDERS_FINANCE")
@PrimaryKeyJoinColumn(name = "PROVIDER_ID",referencedColumnName = "ID")
public class FinanceProviderInfo extends ExchangeProvider<FinanceOrganization> {

    @Column(name="SOURCE_ID")
    private String sourceId;
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "REGIONS")
    @MapKeyClass(String.class)
    @MapKeyColumn(name="REGION")
    @Column(name="DESCRIPTION")
    private Map<String, String> regions;
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "CITIES")
    @MapKeyClass(String.class)
    @MapKeyColumn(name="CITY")
    @Column(name="DESCRIPTION")
    private Map<String, String> cities;
}
