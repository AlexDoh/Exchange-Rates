package com.odmytrenko.model.finance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@Entity
@Table(name = "PROVIDERS_FINANCE")
@PrimaryKeyJoinColumn(name = "FINANCE_PROVIDER_ID", referencedColumnName = "PROVIDER_ID")
public class FinanceProviderInfo extends ExchangeProvider {

    @Column(name = "DATE")
    private String date;
    @Column(name = "SOURCE_ID")
    private String sourceId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROVIDER_ID")
    private List<FinanceOrganization> organizations;
}
