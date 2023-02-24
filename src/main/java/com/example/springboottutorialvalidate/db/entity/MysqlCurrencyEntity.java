package com.example.springboottutorialvalidate.db.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TRANSLATE")
@Data
public class MysqlCurrencyEntity {

    @Id
    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "CURRENCYNT")
    private String currencyNT;

}
