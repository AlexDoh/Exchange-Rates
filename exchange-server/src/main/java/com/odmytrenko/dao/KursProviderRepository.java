package com.odmytrenko.dao;

import com.odmytrenko.model.kurs.KursProviderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KursProviderRepository extends JpaRepository<KursProviderInfo, UUID> {
}