package org.microService.service;

import org.microService.dto.CurrencyConvertDTO;

import java.math.BigDecimal;

public interface CurrencyConvertService {

    CurrencyConvertDTO getConversion(String from, String to, BigDecimal quantity);
}
