package com.odmytrenko.service;

import com.odmytrenko.model.BankInfo;

import java.util.Set;

public interface ExchangeService {

    Set<BankInfo> getBankInfos();
}
