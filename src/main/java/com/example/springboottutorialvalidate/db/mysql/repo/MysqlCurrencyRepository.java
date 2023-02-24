package com.example.springboottutorialvalidate.db.mysql.repo;

import com.example.springboottutorialvalidate.db.mysql.entity.MysqlCurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MysqlCurrencyRepository extends JpaRepository<MysqlCurrencyEntity, String> {

}
