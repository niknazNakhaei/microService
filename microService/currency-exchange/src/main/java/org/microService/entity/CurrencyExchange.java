package org.microService.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter

@Entity
@Table(name = "tbl_currency_exchange")
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_currency_exchange")
    @SequenceGenerator(name = "seq_currency_exchange",sequenceName = "seq_currency_exchange",allocationSize = 1)
    private Long id;

    @Column(name = "currency_from")
    private String currencyFrom;

    @Column(name = "currency_to")
    private String currencyTo;

    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;
}
