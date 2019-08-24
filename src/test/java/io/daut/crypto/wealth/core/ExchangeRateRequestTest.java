package io.daut.crypto.wealth.core;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ExchangeRateRequestTest {
    @Test
    public void testExchangeRateRequestWithValidInput() {
        final ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest(Currency.BTC, Currency.EUR);
        assertNotNull(exchangeRateRequest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExchangeRateRequestWithNullSourceShouldThrow() {
        new ExchangeRateRequest(null, Currency.EUR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExchangeRateRequestWithNullTargetShouldThrow() {
        new ExchangeRateRequest(Currency.BTC, null);
    }
}
