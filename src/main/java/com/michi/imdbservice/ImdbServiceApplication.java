package com.michi.imdbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ImdbServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImdbServiceApplication.class, args);

    }

}
