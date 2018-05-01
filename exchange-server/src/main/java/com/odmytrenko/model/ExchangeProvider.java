package com.odmytrenko.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.UUID;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@Entity
@Table(name = "PROVIDERS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ExchangeProvider {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="PROVIDER_ID")
    private UUID id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "LINK")
    private String link;
}
