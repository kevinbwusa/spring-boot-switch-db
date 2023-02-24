package com.example.springboottutorialvalidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottutorialvalidate.db.entity.H2CurrencyEntity;
import com.example.springboottutorialvalidate.db.entity.MysqlCurrencyEntity;
import com.example.springboottutorialvalidate.db.repo.H2CurrencyRepository;
import com.example.springboottutorialvalidate.db.repo.MysqlCurrencyRepository;

@RestController
@RequestMapping("/dataBase")
public class DataBaseController {

    @Autowired
    private H2CurrencyRepository h2CurrencyRepository;

    @Autowired
    private MysqlCurrencyRepository mysqlCurrencyRepository;

    @RequestMapping(value = "/h2", method = RequestMethod.POST)
    public String h2DoQuery() {
        H2CurrencyEntity entity = h2CurrencyRepository.findById("USD").get();
        return entity.getCurrencyNT();
    }

    @RequestMapping(value = "/mysql", method = RequestMethod.POST)
    public String mysqlDoQuery() {
        MysqlCurrencyEntity entity = new MysqlCurrencyEntity();
        entity.setCurrency("USD");
        entity.setCurrencyNT("美金");
        mysqlCurrencyRepository.save(entity);
        return mysqlCurrencyRepository.findById("USD").get().getCurrencyNT();
    }
}
