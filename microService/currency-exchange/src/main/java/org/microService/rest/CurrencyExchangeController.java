package org.microService.rest;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.microService.dto.CurrencyExchangeDTO;
import org.microService.entity.CurrencyExchange;
import org.microService.mapper.CurrencyExchangeMapper;
import org.microService.service.CurrencyExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/api")
public class CurrencyExchangeController {

    private CurrencyExchangeService currencyExchangeService;
    private CurrencyExchangeMapper currencyExchangeMapper;

    @GetMapping("/get_all")
    public ResponseEntity<List<CurrencyExchangeDTO>> getAll(){
        List<CurrencyExchange> all = currencyExchangeService.getAll();
        List<CurrencyExchangeDTO> currencyExchangeDTOS = currencyExchangeMapper.toDTOList(all);

        return ResponseEntity.ok(currencyExchangeDTOS);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> save(@RequestBody CurrencyExchangeDTO currencyExchangeDTO){
        CurrencyExchange currencyExchange = currencyExchangeMapper.toEntity(currencyExchangeDTO);

        currencyExchangeService.save(currencyExchange);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/get_by/from/{from}/to/{to}")
    @Retry(name="get-exchange",fallbackMethod = "defaultFallBack")
    public ResponseEntity<CurrencyExchangeDTO> getByCurrencyFromAndCurrencyTo(@PathVariable(value = "from") String from,@PathVariable(value = "to") String to) {
        CurrencyExchange currencyExchange = currencyExchangeService.getByCurrencyFromAndCurrencyTo(from, to);
        CurrencyExchangeDTO currencyExchangeDTO = currencyExchangeMapper.toDTO(currencyExchange);
        return ResponseEntity.ok(currencyExchangeDTO);
    }

    public ResponseEntity<CurrencyExchangeDTO> defaultFallBack(String from, String to, Exception ex){
        CurrencyExchangeDTO currencyExchangeDTO=new CurrencyExchangeDTO();
        currencyExchangeDTO.setCurrencyTo(to);
        currencyExchangeDTO.setCurrencyFrom(from);
        currencyExchangeDTO.setConversionMultiple(BigDecimal.valueOf(30000));
        return ResponseEntity.ok(currencyExchangeDTO);
    }


}
