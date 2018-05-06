package com.odmytrenko.job;

import com.odmytrenko.service.ExchangeService;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class UpdateKursProviderJob extends QuartzJobBean {

    @Value("${providers.kurs.title}")
    private String TITLE_KURS_COM_UA;

    @Value("${providers.finance.title}")
    private String TITLE_FINANCE_UA;

    @Autowired
    @Qualifier("kurs")
    private ExchangeService kursExchangeService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        kursExchangeService.save(kursExchangeService.getExchangeProviderInfo());
    }

}
