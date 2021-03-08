package com.svetikov.ukrpostxmljava.controller;

import com.svetikov.ukrpostxmljava.component.ServiceXMLCurrency;
import com.svetikov.ukrpostxmljava.model.Currency;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    private final ServiceXMLCurrency xmlCurrency;

    public CurrencyController(ServiceXMLCurrency xmlCurrency) {
        this.xmlCurrency = xmlCurrency;
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerNotNull(NullPointerException ex, WebRequest request){
        return new ResponseEntity<String>("Not found current country", HttpStatus.NOT_FOUND);
    }

    @SneakyThrows
    @GetMapping("/all")
    public List<Currency> findAll() {


        return xmlCurrency.findAllCurrency();
    }

    @GetMapping("/code/{cc}")
    public ResponseEntity<Currency> findCountryCode(@PathVariable String cc){
        return ResponseEntity.ok(xmlCurrency.findByCountryCode(cc));
    }

    @GetMapping("/convertUAH/{money}/{cc}")
    public ResponseEntity<String> convertCCtoUAH(@PathVariable float money,@PathVariable String cc){
        return ResponseEntity.ok(xmlCurrency.convertToUAH(money,cc));
    }

    @GetMapping("/convertCC/{money}/{cc}")
    public ResponseEntity<String> convertToCC(@PathVariable float money,@PathVariable String cc){
        return ResponseEntity.ok(xmlCurrency.convertToCC(money,cc));
    }

}
