package com.michi.imdbservice;

import com.michi.imdbservice.model.ImdbModelManager;
import com.michi.imdbservice.model.ModelManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ImdbServiceApplication {



    public static void main(String[] args) {
        SpringApplication.run(ImdbServiceApplication.class, args);
        ModelManager model = new ImdbModelManager();

    }

}
