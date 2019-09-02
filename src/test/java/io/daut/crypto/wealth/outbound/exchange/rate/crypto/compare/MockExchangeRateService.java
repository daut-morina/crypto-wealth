package io.daut.crypto.wealth.outbound.exchange.rate.crypto.compare;

import io.daut.crypto.wealth.core.*;

import java.math.BigDecimal;
import java.util.List;

public class MockExchangeRateService implements ExchangeRateService {
    @Override
    public ExchangeRateQuote getQuote(ExchangeRateRequest exchangeRateRequest) {
        final List<QuoteItem> quoteItems = List.of(
                new QuoteItem(Currency.BTC, BigDecimal.valueOf(9157.7)),
                new QuoteItem(Currency.ETH, BigDecimal.valueOf(168.85)),
                new QuoteItem(Currency.XRP, BigDecimal.valueOf(0.2418)));

        return new ExchangeRateQuote(exchangeRateRequest.getTarget(), quoteItems);
    }
}
