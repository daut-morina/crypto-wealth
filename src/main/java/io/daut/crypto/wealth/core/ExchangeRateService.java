package io.daut.crypto.wealth.core;

public interface ExchangeRateService {
    ExchangeRateQuote getQuote(ExchangeRateRequest exchangeRateRequest);
}
