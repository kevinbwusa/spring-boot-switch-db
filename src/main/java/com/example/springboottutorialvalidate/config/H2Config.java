package com.example.springboottutorialvalidate.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import java.util.HashMap;

@Configuration
@Profile("dev | engineering")
@EnableJpaRepositories(basePackages = {"com.example.springboottutorialvalidate.db.repo"},
        entityManagerFactoryRef = "h2EntityManagerFactory",
        transactionManagerRef = "h2TransactionManager")
@EntityScan(basePackages = "com.example.springboottutorialvalidate.db.entity")
public class H2Config {

    @Bean("h2DataSource")
    @ConfigurationProperties("app.datasource.h2")
    @Primary
    public DataSource h2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("h2EntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(
            @Qualifier("h2DataSource") DataSource h2DataSource,
            EntityManagerFactoryBuilder builder) {
        HashMap<String, String> propertiesMap = new HashMap<String, String>();
        propertiesMap.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        return builder
                .dataSource(h2DataSource)
                .packages("com.example.springboottutorialvalidate.db.entity")
                .properties(propertiesMap)
                .persistenceUnit("hDs")
                .build();
    }

    @Bean("h2TransactionManager")
    @Primary
    public PlatformTransactionManager h2TransactionManager(
            @Qualifier("h2EntityManagerFactory") LocalContainerEntityManagerFactoryBean h2EntityManagerFactory
    ) {
        return new JpaTransactionManager(h2EntityManagerFactory.getObject());
    }
}
