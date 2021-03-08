package com.svetikov.ukrpostxmljava.component;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

@Component
@Slf4j
public class TaskCurrency {

    private final ServiceXMLCurrency serviceXMLCurrency;

    public TaskCurrency(ServiceXMLCurrency serviceXMLCurrency) {
        this.serviceXMLCurrency = serviceXMLCurrency;
    }

    @SneakyThrows
    @Scheduled(fixedRate = 3600000)//todo corn="0 8 * *" https://www.baeldung.com/cron-expressions
    public void getCurrency(){
        RestTemplate restTemplate = new RestTemplate();
        String exchange = restTemplate.getForObject(
                "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange",
                String.class);

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("src/main/resources/static/exchange.xml"), "utf-8"))) {

            writer.write(exchange);

            log.info("data from bank.gov.ua load and write to exchange.xml");
        }

        serviceXMLCurrency.xmlInit();

    }
}
