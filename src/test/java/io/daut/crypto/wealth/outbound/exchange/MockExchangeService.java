package io.daut.crypto.wealth.outbound.exchange;

import io.daut.crypto.wealth.core.Currency;
import io.daut.crypto.wealth.core.ExchangeRate;
import io.daut.crypto.wealth.core.ExchangeRateRequest;
import io.daut.crypto.wealth.core.ExchangeService;

import java.util.List;

public class MockExchangeService implements ExchangeService {
    @Override
    public List<ExchangeRate> getExchangeRates(List<ExchangeRateRequest> exchangeRateRequests) {
        return List.of(
                new ExchangeRate(Currency.BTC, Currency.EUR, 9100.00),
                new ExchangeRate(Currency.ETH, Currency.EUR, 129));
    }
}
