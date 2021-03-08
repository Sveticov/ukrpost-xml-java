package com.svetikov.ukrpostxmljava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@EnableScheduling
public class UkrpostXmlJavaApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(UkrpostXmlJavaApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {

// TODO: 01.03.2021

//        RestTemplate restTemplate = new RestTemplate();
//        String exchange = restTemplate.getForObject(
//                "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange",
//                String.class);
//
//        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
//                new FileOutputStream("src/main/resources/static/exchange.xml"), "utf-8"))) {
//            writer.write(exchange);
//        }


    }
}
