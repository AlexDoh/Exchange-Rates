package com.odmytrenko.dao;

import com.odmytrenko.model.ExchangeProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExchangeProviderRepository extends JpaRepository<ExchangeProvider, UUID> {

    ExchangeProvider findByTitle(String title);

    boolean existsExchangeProviderByTitle(String title);
}