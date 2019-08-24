package io.daut.crypto.wealth.core;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ExchangeRateTest {
    @Test
    public void testExchangeRateWithValidInput() {
        final double rate = 9189.34;
        final ExchangeRate exchangeRate = new ExchangeRate(Currency.BTC, Currency.EUR, rate);
        assertNotNull(exchangeRate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExchangeRateWithNullSourceShouldThrow() {
        new ExchangeRate(null, Currency.EUR, 1.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExchangeRateWithNullTargetShouldThrow() {
        new ExchangeRate(Currency.BTC, null, 2.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExchangeRateWithZeroRateShouldThrow() {
        new ExchangeRate(Currency.BTC, Currency.EUR, 0);
    }
}
