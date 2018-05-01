package com.odmytrenko.model.kurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.odmytrenko.model.ExchangeProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Entity
@Table(name = "PROVIDERS_KURS")
@Data
public class KursProviderInfo extends ExchangeProvider {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "PROVIDER_ID")
    private UUID id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROVIDER_ID")
    private List<KursOrganization> organizations;
}
