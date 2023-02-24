package com.example.springboottutorialvalidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"com.campsite.users.server", "com.campsite.users.controller","com.campsite.users.manager", "com.campsite.users.model"})
//@EnableJpaRepositories("com.example.springboottutorialvalidate.db.repo")
//@EntityScan(basePackageClasses = CurrencyEntity.class)
public class SpringBootTutorialValidateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialValidateApplication.class, args);
	}

}
