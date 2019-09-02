package io.daut.crypto.wealth.core;

import java.math.BigDecimal;

public class Money {
    private final Currency currency;
    private final BigDecimal value;

    public Money(Currency currency, BigDecimal value) {
        assert currency != null;
        this.currency = currency;

        assert value != null;
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }
}
