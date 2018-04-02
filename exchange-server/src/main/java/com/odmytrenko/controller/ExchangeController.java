package com.odmytrenko.controller;

import com.odmytrenko.model.kurs.BankInfo;
import com.odmytrenko.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @RequestMapping(path = "/rates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Set<BankInfo> getBankInfos(){
        return exchangeService.getBankInfos();
    }
}
