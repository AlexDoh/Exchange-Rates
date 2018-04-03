package com.odmytrenko.controller;

import com.odmytrenko.dto.ResponseExchangeInfo;
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

    @RequestMapping(path = "/kurs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseExchangeInfo getKursExchangeInfo(){
        return kursExchangeService.getExchangeInfo();
    }

    @RequestMapping(path = "/finance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseExchangeInfo getFinanceExchangeInfo(){
        return financeExchangeService.getExchangeInfo();
    }
}
