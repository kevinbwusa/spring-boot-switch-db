package com.example.springboottutorialvalidate.db.h2.repo;

import com.example.springboottutorialvalidate.db.h2.entity.H2CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface H2CurrencyRepository extends JpaRepository<H2CurrencyEntity, String> {

}
