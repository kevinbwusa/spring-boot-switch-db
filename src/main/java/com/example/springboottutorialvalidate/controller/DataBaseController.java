package com.example.springboottutorialvalidate.controller;

import com.example.springboottutorialvalidate.db.h2.entity.H2CurrencyEntity;
import com.example.springboottutorialvalidate.db.h2.repo.H2CurrencyRepository;
import com.example.springboottutorialvalidate.db.mysql.entity.MysqlCurrencyEntity;
import com.example.springboottutorialvalidate.db.mysql.repo.MysqlCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
