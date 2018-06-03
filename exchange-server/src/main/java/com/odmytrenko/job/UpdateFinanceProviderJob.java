package com.odmytrenko.job;

import com.odmytrenko.model.ExchangeProvider;
import com.odmytrenko.model.finance.FinanceProviderInfo;
import com.odmytrenko.service.ExchangeService;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Optional;

public class UpdateFinanceProviderJob extends QuartzJobBean {

    @Autowired
    @Qualifier("finance")
    private ExchangeService financeExchangeService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        FinanceProviderInfo newFinanceProviderInfo = (FinanceProviderInfo) financeExchangeService.getExchangeProviderInfo();
        Optional<ExchangeProvider> exchangeProvider = financeExchangeService.findById(newFinanceProviderInfo.getTitle());
        if (exchangeProvider.isPresent()) {
            FinanceProviderInfo financeProviderInfo = (FinanceProviderInfo) exchangeProvider.get();
            financeProviderInfo.setOrganizations(newFinanceProviderInfo.getOrganizations());
        } else {
            financeExchangeService.save(newFinanceProviderInfo);
        }
    }

}
