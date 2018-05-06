package com.odmytrenko.dao;

import com.odmytrenko.model.ExchangeProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeProviderRepository extends JpaRepository<ExchangeProvider, String> {
}