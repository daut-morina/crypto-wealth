package io.daut.crypto.wealth.core;

import java.util.List;

public interface ExchangeService {
    List<ExchangeRate> getExchangeRates(List<ExchangeRateRequest> exchangeRateRequests);
}
