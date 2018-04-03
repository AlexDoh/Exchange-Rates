package com.odmytrenko.controller;

import com.odmytrenko.dto.ExchangeInfo;
import com.odmytrenko.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

    @Autowired
    @Qualifier("kurs")
    private ExchangeService exchangeService;

    @RequestMapping(path = "/rates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExchangeInfo getBankInfos(){
        return exchangeService.getExchangeInfo();
    }
}
