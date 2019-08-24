package io.daut.crypto.wealth.core;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class WealthReportItemTest {
    @Test
    public void testWealthReportItemWithValidInput() {
        final WealthReportItem wealthReportItem = new WealthReportItem(Currency.BTC, Currency.EUR, 9400.02);
        assertNotNull(wealthReportItem);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWealthReportWithNullSourceShouldThrow() {
        new WealthReportItem(null, null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWealthReportWithNullTargetShouldThrow() {
        new WealthReportItem(Currency.BTC, null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWealthReportWithNegativeValueShouldThrow() {
        new WealthReportItem(Currency.BTC, Currency.EUR, -150);
    }
}
