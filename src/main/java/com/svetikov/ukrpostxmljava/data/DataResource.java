package com.svetikov.ukrpostxmljava.data;

import com.svetikov.ukrpostxmljava.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.util.List;


public interface DataResource  {
    void save(Currency currency);

    Currency getCurrency(int id);

    List<Currency> allCurrency();

    Currency findByCountry(String country);

    Currency findByCountryCode(String countryCode);

    void clearAll();
}
