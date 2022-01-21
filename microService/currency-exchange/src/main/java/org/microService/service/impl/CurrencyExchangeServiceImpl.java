package org.microService.service.impl;

import lombok.AllArgsConstructor;
import org.microService.entity.CurrencyExchange;
import org.microService.repository.CurrencyExchangeRepository;
import org.microService.service.CurrencyExchangeService;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private CurrencyExchangeRepository currencyExchangeRepository;

    @Override
    public CurrencyExchange save(CurrencyExchange currencyExchange) {
        return currencyExchangeRepository.save(currencyExchange);
    }

    @Override
    public List<CurrencyExchange> getAll() {
        return currencyExchangeRepository.findAll();
    }

    @Override
    public CurrencyExchange getByCurrencyFromAndCurrencyTo(String from, String to) {
        return currencyExchangeRepository.findByCurrencyFromAndCurrencyTo(from,to);
    }
}
