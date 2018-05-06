package com.odmytrenko.controller;

import com.odmytrenko.model.ExchangeProvider;
import com.odmytrenko.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path = "/rates")
public class ExchangeController {

    @Value("${providers.kurs.title}")
    private String TITLE_KURS_COM_UA;

    @Value("${providers.finance.title}")
    private String TITLE_FINANCE_UA;

    @Autowired
    @Qualifier("kurs")
    private ExchangeService kursExchangeService;

    @Autowired
    @Qualifier("finance")
    private ExchangeService financeExchangeService;


    @RequestMapping(path = "/kurs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getKursExchangeInfo() {
        ExchangeProvider exchangeProvider = kursExchangeService.findByTitle(TITLE_KURS_COM_UA);
        return Optional.of(ResponseEntity.ok(exchangeProvider)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "/kurs/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity updateKursExchangeInfo() {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).body(kursExchangeService.save(kursExchangeService.getExchangeProviderInfo()));
    }

    @RequestMapping(path = "/finance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ExchangeProvider> getFinanceExchangeInfo() {
        ExchangeProvider exchangeProvider = financeExchangeService.findByTitle(TITLE_FINANCE_UA);
        return Optional.of(ResponseEntity.ok(exchangeProvider)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "/finance/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity updateFinanceExchangeInfo() {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).body(financeExchangeService.save(financeExchangeService.getExchangeProviderInfo()));
    }

}
