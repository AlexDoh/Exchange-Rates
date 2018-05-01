package com.odmytrenko.controller;

import com.odmytrenko.dao.FinanceProviderRepository;
import com.odmytrenko.dao.KursProviderRepository;
import com.odmytrenko.model.finance.FinanceProviderInfo;
import com.odmytrenko.model.kurs.KursProviderInfo;
import com.odmytrenko.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rates")
public class ExchangeController {

    @Autowired
    @Qualifier("kurs")
    private ExchangeService kursExchangeService;

    @Autowired
    @Qualifier("finance")
    private ExchangeService financeExchangeService;

    @Autowired
    private FinanceProviderRepository financeProviderRepository;

    @Autowired
    private KursProviderRepository kursProviderRepository;

    @RequestMapping(path = "/kurs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public KursProviderInfo getKursExchangeInfo() {
        kursProviderRepository.save(kursExchangeService.getKursProviderInfo());
        return kursProviderRepository.findAll().get(0);
    }

    @RequestMapping(path = "/finance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FinanceProviderInfo getFinanceExchangeInfo() {
        financeProviderRepository.save(financeExchangeService.getFinanceProviderInfo());
        return financeProviderRepository.findAll().get(0);
    }
}
