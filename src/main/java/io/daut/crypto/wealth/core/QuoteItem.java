package io.daut.crypto.wealth.core;

import java.math.BigDecimal;

public class QuoteItem {
    private final Currency source;
    private final BigDecimal rate;

    public QuoteItem(Currency source, BigDecimal rate) {
        this.source = source;
        this.rate = rate;
    }

    public Currency getSource() {
        return source;
    }

    public BigDecimal getRate() {
        return rate;
    }
}