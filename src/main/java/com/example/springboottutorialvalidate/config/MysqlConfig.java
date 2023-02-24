package com.example.springboottutorialvalidate.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Component
@Profile("!dev & !engineering & !testdev")
@EnableJpaRepositories(basePackages = {"com.example.springboottutorialvalidate.db.repo"},
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager")
@EntityScan(basePackages = "com.example.springboottutorialvalidate.db.entity")
public class MysqlConfig {

    @Bean("mysqlDataSource")
    @ConfigurationProperties("app.datasource.mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(
            @Qualifier("mysqlDataSource") DataSource h2DataSource,
            EntityManagerFactoryBuilder builder) {
        HashMap<String, String> propertiesMap = new HashMap<String, String>();
        propertiesMap.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return builder
                .dataSource(h2DataSource)
                .packages("com.example.springboottutorialvalidate.db.entity")
                .properties(propertiesMap)
                .persistenceUnit("mysql")
                .build();
    }

    @Bean("mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(
            @Qualifier("mysqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory
    ) {
        return new JpaTransactionManager(mysqlEntityManagerFactory.getObject());
    }
}
