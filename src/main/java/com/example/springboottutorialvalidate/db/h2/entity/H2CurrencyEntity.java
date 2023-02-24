package com.example.springboottutorialvalidate.db.h2.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TRANSLATE")
@Data
public class H2CurrencyEntity {

    @Id
    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "CURRENCYNT")
    private String currencyNT;

}
