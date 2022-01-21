package org.microService.repository;

import org.microService.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {
    CurrencyExchange findByCurrencyFromAndCurrencyTo(String from, String to);
}
