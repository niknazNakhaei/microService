package org.microService.proxy;

import org.microService.dto.CurrencyConvertDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/api/get_by/from/{from}/to/{to}")
    CurrencyConvertDTO getByCurrencyFromAndCurrencyTo(@PathVariable(value = "from") String from, @PathVariable(value = "to") String to);
}
