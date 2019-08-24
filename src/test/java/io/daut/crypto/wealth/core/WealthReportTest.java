package io.daut.crypto.wealth.core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WealthReportTest {
    @Test
    public void testWealthReportWithValidInput() {
        final List<WealthReportItem> wealthReportItems = List.of(
                new WealthReportItem(Currency.BTC, Currency.EUR, 9408.20),
                new WealthReportItem(Currency.ETH, Currency.EUR, 394));
        final WealthReport wealthReport = new WealthReport(wealthReportItems);

        assertEquals(9802.20, wealthReport.getTotal(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWealthReportWithNullWealthReportItemsShouldThrow() {
        new WealthReport(null);
    }

    @Test
    public void testWealthReportShouldCopyList() {
        final List<WealthReportItem> wealthReportItems = new ArrayList<>();
        wealthReportItems.add(new WealthReportItem(Currency.ETH, Currency.EUR, 5));

        final WealthReport wealthReport = new WealthReport(wealthReportItems);
        wealthReportItems.add(new WealthReportItem(Currency.XRP, Currency.EUR, 2000));

        assertEquals(2, wealthReportItems.size());
        assertEquals(1, wealthReport.getWealthReportItems().size());
    }
}
