package org.microService.rest;

import lombok.AllArgsConstructor;
import org.microService.dto.CurrencyConvertDTO;
import org.microService.service.CurrencyConvertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@AllArgsConstructor

@RestController
@RequestMapping("/api")
public class CurrencyConvertController {

    private CurrencyConvertService currencyConvertService;

    @GetMapping("/get_convert/from/{from}/to/{to}/{quality}")
    public ResponseEntity<CurrencyConvertDTO> get(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("quality")BigDecimal quality){
        return ResponseEntity.ok(currencyConvertService.getConversion(from,to, quality));
    }



}
