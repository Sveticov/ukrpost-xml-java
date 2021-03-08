package com.svetikov.ukrpostxmljava.data;

import com.svetikov.ukrpostxmljava.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("currency")
public interface CurrentRepository extends JpaRepository<Currency,String> {
}
