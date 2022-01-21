package org.microService.service;

import org.microService.entity.CurrencyExchange;

import java.util.List;

public interface CurrencyExchangeService {

    CurrencyExchange save(CurrencyExchange currencyExchange);

    List<CurrencyExchange> getAll();

    CurrencyExchange getByCurrencyFromAndCurrencyTo(String from, String to);
}
