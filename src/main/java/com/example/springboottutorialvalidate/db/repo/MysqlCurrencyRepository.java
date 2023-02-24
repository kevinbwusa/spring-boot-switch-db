package com.example.springboottutorialvalidate.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboottutorialvalidate.db.entity.MysqlCurrencyEntity;


@Repository
public interface MysqlCurrencyRepository extends JpaRepository<MysqlCurrencyEntity, String> {

}
