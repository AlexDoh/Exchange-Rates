package com.odmytrenko.service;

import com.odmytrenko.model.kurs.BankInfo;

import java.util.Set;

public interface ExchangeService {

    Set<BankInfo> getBankInfos();
}
