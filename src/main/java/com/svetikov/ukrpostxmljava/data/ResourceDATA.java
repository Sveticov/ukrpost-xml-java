package com.svetikov.ukrpostxmljava.data;
import com.svetikov.ukrpostxmljava.model.Currency;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResourceDATA implements DataResource
{
    private final List<Currency> currencyList;

    public ResourceDATA() {
        this.currencyList = new ArrayList<>();
    }

    @Override
    public void save(Currency currency) {
        this.currencyList.add(currency);
    }

    @Override
    public Currency getCurrency(int id) {
        return this.currencyList.get(id);
    }

    @Override
    public List<Currency> allCurrency() {
        return this.currencyList;
    }

    @Override
    public Currency findByCountry(String country) {
        return currencyList.stream()
                .filter(it->it.getTxt().equals(country))
                .findFirst()
                .orElseGet(null);
    }

    @Override
    public Currency findByCountryCode(String countryCode) {
        return currencyList.stream()
                .filter(it->it.getCc().equals(countryCode.toUpperCase()))
                .findFirst()
                .orElseGet(null);
    }

    @Override
    public void clearAll() {
        currencyList.clear();
    }
}
