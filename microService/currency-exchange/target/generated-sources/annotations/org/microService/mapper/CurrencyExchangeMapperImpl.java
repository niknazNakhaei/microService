package org.microService.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.microService.dto.CurrencyExchangeDTO;
import org.microService.entity.CurrencyExchange;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-21T12:07:46+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CurrencyExchangeMapperImpl implements CurrencyExchangeMapper {

    @Override
    public CurrencyExchangeDTO toDTO(CurrencyExchange currencyExchange) {
        if ( currencyExchange == null ) {
            return null;
        }

        CurrencyExchangeDTO currencyExchangeDTO = new CurrencyExchangeDTO();

        currencyExchangeDTO.setId( currencyExchange.getId() );
        currencyExchangeDTO.setCurrencyFrom( currencyExchange.getCurrencyFrom() );
        currencyExchangeDTO.setCurrencyTo( currencyExchange.getCurrencyTo() );
        currencyExchangeDTO.setConversionMultiple( currencyExchange.getConversionMultiple() );

        return currencyExchangeDTO;
    }

    @Override
    public List<CurrencyExchangeDTO> toDTOList(List<CurrencyExchange> currencyExchanges) {
        if ( currencyExchanges == null ) {
            return null;
        }

        List<CurrencyExchangeDTO> list = new ArrayList<CurrencyExchangeDTO>( currencyExchanges.size() );
        for ( CurrencyExchange currencyExchange : currencyExchanges ) {
            list.add( toDTO( currencyExchange ) );
        }

        return list;
    }

    @Override
    public CurrencyExchange toEntity(CurrencyExchangeDTO currencyExchangeDTO) {
        if ( currencyExchangeDTO == null ) {
            return null;
        }

        CurrencyExchange currencyExchange = new CurrencyExchange();

        currencyExchange.setId( currencyExchangeDTO.getId() );
        currencyExchange.setCurrencyFrom( currencyExchangeDTO.getCurrencyFrom() );
        currencyExchange.setCurrencyTo( currencyExchangeDTO.getCurrencyTo() );
        currencyExchange.setConversionMultiple( currencyExchangeDTO.getConversionMultiple() );

        return currencyExchange;
    }
}
