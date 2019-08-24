package io.daut.crypto.wealth.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyTest {
    @Test
    public void testMoneyWithValidInput() {
        final Currency currency = Currency.BTC;
        final double value = 15.0;
        final Money money = new Money(currency, value);

        assertEquals(currency, money.getCurrency());
        assertEquals(value, money.getValue(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoneyWithNullSymbolShouldThrow() {
        new Money(null, 15.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoneyWithNegativeValueShouldThrow() {
        new Money(Currency.BTC, -15.0);
    }
}
