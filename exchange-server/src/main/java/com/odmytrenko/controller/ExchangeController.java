package com.odmytrenko.controller;

import com.odmytrenko.dao.ExchangeProviderRepository;
import com.odmytrenko.model.ExchangeProvider;
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
    private ExchangeProviderRepository exchangeProviderRepository;

    @RequestMapping(path = "/kurs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExchangeProvider getKursExchangeInfo() {
        exchangeProviderRepository.save(kursExchangeService.getExchangeProviderInfo());
        return exchangeProviderRepository.findAll().get(1);
    }

    @RequestMapping(path = "/finance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExchangeProvider getFinanceExchangeInfo() {
        exchangeProviderRepository.save(financeExchangeService.getExchangeProviderInfo());
        return exchangeProviderRepository.findAll().get(0);
    }
}
