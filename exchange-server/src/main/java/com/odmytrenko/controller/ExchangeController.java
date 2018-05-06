package com.odmytrenko.controller;

import com.odmytrenko.dao.ExchangeProviderRepository;
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

    @Value("${providers.kurs.name}")
    private String TITLE_KURS_COM_UA;

    @Value("${providers.finance.name}")
    private String TITLE_FINANCE_UA;

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
        ExchangeProvider exchangeProvider = exchangeProviderRepository.findByTitle(TITLE_KURS_COM_UA);
        return Optional.of(ResponseEntity.ok(exchangeProvider)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "/kurs/save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity saveKursExchangeInfo() {
        if (exchangeProviderRepository.existsExchangeProviderByTitle(TITLE_KURS_COM_UA)) {
            return ResponseEntity.ok(exchangeProviderRepository.findByTitle(TITLE_KURS_COM_UA));
        } else {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
            return ResponseEntity.created(location).body(exchangeProviderRepository.save(kursExchangeService.getExchangeProviderInfo()));
        }
    }

    @RequestMapping(path = "/kurs/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExchangeProvider updateKursExchangeInfo() {
        ExchangeProvider exchangeProvider = exchangeProviderRepository.findByTitle(TITLE_KURS_COM_UA);
        if (exchangeProviderRepository.existsById(exchangeProvider.getId())) {

        }
        return exchangeProviderRepository.save(kursExchangeService.getExchangeProviderInfo());
    }

    @RequestMapping(path = "/finance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ExchangeProvider> getFinanceExchangeInfo() {
        ExchangeProvider exchangeProvider = exchangeProviderRepository.findByTitle(TITLE_FINANCE_UA);
        return Optional.of(ResponseEntity.ok(exchangeProvider)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "/finance/save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity saveFinanceExchangeInfo() {
        if (exchangeProviderRepository.existsExchangeProviderByTitle(TITLE_FINANCE_UA)) {
            return ResponseEntity.ok(exchangeProviderRepository.findByTitle(TITLE_FINANCE_UA));
        } else {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
            return ResponseEntity.created(location).body(exchangeProviderRepository.save(financeExchangeService.getExchangeProviderInfo()));
        }
    }

    @RequestMapping(path = "/finance/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExchangeProvider updateFinanceExchangeInfo() {
        return exchangeProviderRepository.save(financeExchangeService.getExchangeProviderInfo());
    }

}
