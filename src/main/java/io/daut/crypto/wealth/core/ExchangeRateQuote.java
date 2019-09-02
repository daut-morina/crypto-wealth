package io.daut.crypto.wealth.core;

import java.util.List;

public class ExchangeRateQuote {
    private final Currency targetCurrency;
    private final List<QuoteItem> quoteItems;

    public ExchangeRateQuote(Currency targetCurrency, List<QuoteItem> quoteItems) {
        this.targetCurrency = targetCurrency;
        this.quoteItems = quoteItems;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public List<QuoteItem> getQuoteItems() {
        return quoteItems;
    }
}
