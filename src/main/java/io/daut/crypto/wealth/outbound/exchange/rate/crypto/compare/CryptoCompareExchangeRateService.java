package io.daut.crypto.wealth.outbound.exchange.rate.crypto.compare;

import io.daut.crypto.wealth.core.*;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CryptoCompareExchangeRateService implements ExchangeRateService {

    private final CryptoCompareClient cryptoCompareClient;

    public static CryptoCompareExchangeRateService create(CryptoCompareClient cryptoCompareClient) {
        return new CryptoCompareExchangeRateService(cryptoCompareClient);
    }

    private CryptoCompareExchangeRateService(CryptoCompareClient cryptoCompareClient) {
        this.cryptoCompareClient = cryptoCompareClient;
    }

    @Override
    public ExchangeRateQuote getQuote(ExchangeRateRequest exchangeRateRequest) {
        final Currency target = exchangeRateRequest.getTarget();

        return exchangeRateRequest.getSources().stream()
                .map(getExchangeRateFunction(this.cryptoCompareClient, target))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        quoteItems -> new ExchangeRateQuote(target, quoteItems)));
    }

    private static Function<Currency, QuoteItem> getExchangeRateFunction(CryptoCompareClient cryptoCompareClient, Currency targetCurrency) {
        return (Currency sourceCurrency) -> {
            try {
                final BigDecimal exchangeRate = cryptoCompareClient.getExchangeRate(sourceCurrency.getCode(), targetCurrency.getCode());
                return new QuoteItem(sourceCurrency, exchangeRate);
            } catch (CryptoCompareException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
