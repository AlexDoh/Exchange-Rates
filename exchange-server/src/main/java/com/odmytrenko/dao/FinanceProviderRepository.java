package com.odmytrenko.dao;

import com.odmytrenko.model.finance.FinanceProviderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FinanceProviderRepository extends JpaRepository<FinanceProviderInfo, UUID> {
}