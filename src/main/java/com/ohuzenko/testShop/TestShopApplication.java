package com.ohuzenko.testShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com.ohuzenko"},
		exclude = {JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//exclude = {JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class}
public class TestShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestShopApplication.class, args);
	}
}
