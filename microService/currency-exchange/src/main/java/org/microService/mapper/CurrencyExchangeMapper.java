package org.microService.mapper;

import org.mapstruct.Mapper;
import org.microService.dto.CurrencyExchangeDTO;
import org.microService.entity.CurrencyExchange;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyExchangeMapper {

    CurrencyExchangeDTO toDTO(CurrencyExchange currencyExchange);

    List<CurrencyExchangeDTO> toDTOList(List<CurrencyExchange> currencyExchanges);

    CurrencyExchange toEntity(CurrencyExchangeDTO currencyExchangeDTO);
}
