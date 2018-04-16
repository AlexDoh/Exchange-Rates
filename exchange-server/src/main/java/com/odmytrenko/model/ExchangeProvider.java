package com.odmytrenko.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@Entity
@Table(name = "PROVIDERS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ExchangeProvider<T> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "provider")
    private List<T> organizations;
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "ORG_TYPES")
    @MapKeyClass(Integer.class)
    @MapKeyColumn(name="TYPE")
    @Column(name="ORGANIZATION")
    private Map<Integer, String> orgTypes;
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "CURRENCIES")
    @MapKeyClass(String.class)
    @MapKeyColumn(name="CURRENCY")
    @Column(name="DESCRIPTION")
    private Map<String, String> currencies;
    @Column(name="DATE")
    private String date;
}
