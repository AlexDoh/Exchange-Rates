package com.odmytrenko.job;

import com.odmytrenko.service.ExchangeService;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class UpdateKursProviderJob extends QuartzJobBean {

    @Autowired
    @Qualifier("kurs")
    private ExchangeService kursExchangeService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        kursExchangeService.save(kursExchangeService.getExchangeProviderInfo());
    }

}
