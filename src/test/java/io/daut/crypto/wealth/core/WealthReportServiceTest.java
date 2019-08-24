package io.daut.crypto.wealth.core;

import io.daut.crypto.wealth.outbound.exchange.MockExchangeService;
import io.daut.crypto.wealth.outbound.printer.MockPrintService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WealthReportServiceTest {
    @Test
    public void testWealthReportServiceWithValidInput() {
        final ExchangeService exchangeService = new MockExchangeService();
        final PrintService printService = new MockPrintService();
        final WealthReportService wealthReportService = new WealthReportService(exchangeService, printService);
        assertNotNull(wealthReportService);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWealthReportServiceWithNullExchangeServiceShouldThrow() {
        new WealthReportService(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWealthReportServiceWithNullPrintServiceShouldThrow() {
        final ExchangeService exchangeService = new MockExchangeService();
        new WealthReportService(exchangeService, null);
    }

    @Test
    public void testCalculateWealth() {
        final ExchangeService exchangeService = new MockExchangeService();
        final PrintService printService = new MockPrintService();
        final WealthReportService wealthReportService = new WealthReportService(exchangeService, printService);

        final List<Money> monies = List.of(new Money(Currency.BTC, 10), new Money(Currency.ETH, 5));
        final WealthReport wealthReport = wealthReportService.calculateWealth(monies);

        assertEquals(91645.0, wealthReport.getTotal(), 0.01);
    }
}
