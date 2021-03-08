package com.svetikov.ukrpostxmljava.component;

import com.svetikov.ukrpostxmljava.model.Currency;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface ServiceXMLCurrency {
    void xmlInit() throws ParserConfigurationException, IOException, SAXException;
    List<Currency> findAllCurrency() throws IOException, SAXException, ParserConfigurationException;

    Currency findByCountryCode(String cc);

    String convertToUAH(float money, String cc);

    String convertToCC(float money, String cc);
}
