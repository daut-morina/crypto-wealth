package io.daut.crypto.wealth.core;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CurrencyTest {
    @Test
    public void testFromWithValidInput() {
        final Currency eur = Currency.from("eur");
        assertNotNull(eur);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromWithInvalidInputShouldThrow() {
        final Currency jpy = Currency.from("jpy");
    }
}
