package org.microService.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CurrencyConvertDTO {

    private Long id;

    private String currencyFrom;

    private String currencyTo;

    private BigDecimal conversionMultiple;

    private BigDecimal totalCalculateAmount;
}
