package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.odmytrenko.model.ExchangeOrganization;
import com.odmytrenko.model.ExchangeProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "provider")
@Entity
@Table(name = "ORGANIZATIONS_KURS")
@PrimaryKeyJoinColumn(name = "KURS_ORGANIZATION_ID", referencedColumnName = "ID")
public class KursOrganization extends ExchangeOrganization {

    @JsonManagedReference
    @MapKeyColumn(name = "TYPE")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORGANIZATION_ID")
    private Map<String, KursCurrencyRates> currencies;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID")
    private ExchangeProvider provider;
}
