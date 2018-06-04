package com.odmytrenko.job;

import com.odmytrenko.service.ExchangeService;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class UpdateFinanceProviderJob extends QuartzJobBean {

    @Autowired
    @Qualifier("finance")
    private ExchangeService financeExchangeService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        financeExchangeService.save(financeExchangeService.getExchangeProviderInfo());
    }

}
