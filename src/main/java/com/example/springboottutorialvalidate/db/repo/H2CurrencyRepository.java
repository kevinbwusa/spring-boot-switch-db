package com.example.springboottutorialvalidate.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboottutorialvalidate.db.entity.H2CurrencyEntity;


@Repository
public interface H2CurrencyRepository extends JpaRepository<H2CurrencyEntity, String> {

}
