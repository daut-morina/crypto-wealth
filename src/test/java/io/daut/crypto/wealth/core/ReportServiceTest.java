package io.daut.crypto.wealth.core;

import io.daut.crypto.wealth.outbound.print.console.MockPrintService;
import io.daut.crypto.wealth.outbound.exchange.rate.crypto.compare.MockExchangeRateService;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReportServiceTest {
    @Test
    public void testGenerateReport() {
        final ExchangeRateService exchangeRateService = new MockExchangeRateService();
        final PrintService printService = new MockPrintService();
        final ReportService reportService = new ReportService(exchangeRateService, printService);
        final List<Money> assets = List.of(
                new Money(Currency.BTC, BigDecimal.valueOf(10)),
                new Money(Currency.ETH, BigDecimal.valueOf(5)),
                new Money(Currency.XRP, BigDecimal.valueOf(2000)));
        final Portfolio portfolio = new Portfolio(assets);
        final Report report = reportService.generateReport(portfolio, Currency.EUR);

        assertThat(BigDecimal.valueOf(92904.85).setScale(2, RoundingMode.HALF_UP), is(report.getTotalValue().setScale(2, RoundingMode.HALF_UP)));
    }
}
