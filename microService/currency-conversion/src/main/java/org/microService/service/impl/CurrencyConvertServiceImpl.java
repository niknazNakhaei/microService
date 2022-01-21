package org.microService.service.impl;

import lombok.AllArgsConstructor;
import org.microService.dto.CurrencyConvertDTO;
import org.microService.proxy.CurrencyExchangeProxy;
import org.microService.service.CurrencyConvertService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor

@Service
public class CurrencyConvertServiceImpl implements CurrencyConvertService {
    private CurrencyExchangeProxy currencyExchangeProxy;

    @Override
    public CurrencyConvertDTO getConversion(String from, String to, BigDecimal quantity) {
        CurrencyConvertDTO currencyConvertDTO = currencyExchangeProxy.getByCurrencyFromAndCurrencyTo(from, to);

        currencyConvertDTO.setTotalCalculateAmount(currencyConvertDTO.getConversionMultiple().multiply(quantity));
        return currencyConvertDTO;
    }
}
