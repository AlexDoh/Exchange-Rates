package com.odmytrenko.controller;

import com.odmytrenko.model.ExchangeProvider;
import com.odmytrenko.model.finance.FinanceProviderInfo;
import com.odmytrenko.model.kurs.KursProviderInfo;
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
    public ResponseEntity<KursProviderInfo> getKursExchangeInfo() {
        Optional<ExchangeProvider> exchangeProvider = kursExchangeService.findById(TITLE_KURS_COM_UA);
        return exchangeProvider.map(provider -> (KursProviderInfo) provider).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "/finance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<FinanceProviderInfo> getFinanceExchangeInfo() {
        Optional<ExchangeProvider> exchangeProvider = financeExchangeService.findById(TITLE_FINANCE_UA);
        return exchangeProvider.map(provider -> (FinanceProviderInfo) provider).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
