package com.odmytrenko.controller;

import com.odmytrenko.dao.ExchangeProviderRepository;
import com.odmytrenko.model.ExchangeProvider;
import com.odmytrenko.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
    public ResponseEntity getKursExchangeInfo() {
        ExchangeProvider exchangeProvider = exchangeProviderRepository.findByTitle("Kurs.com.ua");
        return Optional.of(ResponseEntity.ok(exchangeProvider)).orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "/finance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ExchangeProvider> getFinanceExchangeInfo() {
        ExchangeProvider exchangeProvider = exchangeProviderRepository.findByTitle("Finance.ua");
        return Optional.of(ResponseEntity.ok(exchangeProvider)).orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "/kurs/save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExchangeProvider saveKursExchangeInfo() {
        return exchangeProviderRepository.save(kursExchangeService.getExchangeProviderInfo());
    }

    @RequestMapping(path = "/finance/save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExchangeProvider saveFinanceExchangeInfo() {
        return exchangeProviderRepository.save(financeExchangeService.getExchangeProviderInfo());
    }
}
