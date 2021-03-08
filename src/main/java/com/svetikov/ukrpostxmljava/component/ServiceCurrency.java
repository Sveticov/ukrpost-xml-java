package com.svetikov.ukrpostxmljava.component;

import com.svetikov.ukrpostxmljava.data.CurrentRepository;
import com.svetikov.ukrpostxmljava.data.ResourceDATA;

import com.svetikov.ukrpostxmljava.model.Currency;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;


import javax.xml.parsers.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class ServiceCurrency implements ServiceXMLCurrency {

    private final ResourceDATA dataResource;
    private final CurrentRepository repository;

    public ServiceCurrency(ResourceDATA dataResource,@Qualifier("currency") CurrentRepository repository) {
        this.dataResource = dataResource;
        this.repository = repository;
    }

    @SneakyThrows
    public void xmlInit()  {
        //dataResource.clearAll();
        repository.deleteAll();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/main/resources/static/exchange.xml"));


        NodeList exchangeElement = document.getElementsByTagName("currency");

        for (int i = 0; i < exchangeElement.getLength(); i++) {
            NodeList nodeList = exchangeElement.item(i).getChildNodes();

//            dataResource.save(new Currency(
//                    Integer.parseInt(nodeList.item(1).getTextContent()),
//                    nodeList.item(3).getTextContent(),
//                    Float.parseFloat(nodeList.item(5).getTextContent()),
//                    nodeList.item(7).getTextContent()
//            ));
            repository.save(
                    new Currency(
                            Integer.parseInt(nodeList.item(1).getTextContent()),
                            nodeList.item(3).getTextContent(),
                            Float.parseFloat(nodeList.item(5).getTextContent()),
                            nodeList.item(7).getTextContent()
                    ));


        }

        log.info("file exchange.xml update");


    }


    @Override
    public List<Currency> findAllCurrency() {

        return repository.findAll();// dataResource.allCurrency();
    }

    @Override
    public Currency findByCountryCode(String cc) {
        Currency currency=repository.findById(cc.toUpperCase()).orElseGet(null);
        log.info(currency.toString());
        return currency;//dataResource.findByCountryCode(cc);
    }

    @Override
    public String convertToUAH(float money, String cc) {
        float result = findByCountryCode(cc).getRate()*money;
        return " "+money+" "+cc.toUpperCase()+" : "+result+" UAH";
    }

    @Override
    public String convertToCC(float money, String cc) {
        float result = money/findByCountryCode(cc).getRate();
        return " "+money+" UAH  : "+result+" "+cc.toUpperCase();
    }
}
