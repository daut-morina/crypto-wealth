package io.daut.crypto.wealth.core;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class ReportTest {
    @Test
    public void testReport() {
        final BigDecimal expected = new BigDecimal(92904.85).setScale(2, RoundingMode.HALF_UP);

        final Portfolio portfolio = new Portfolio(
                List.of(
                        new Money(Currency.BTC, BigDecimal.valueOf(10)),
                        new Money(Currency.ETH, BigDecimal.valueOf(5)),
                        new Money(Currency.XRP, BigDecimal.valueOf(2000))));

        final ExchangeRateQuote exchangeRateQuote = new ExchangeRateQuote(Currency.EUR, List.of(
                new QuoteItem(Currency.BTC, BigDecimal.valueOf(9157.7)),
                new QuoteItem(Currency.ETH, BigDecimal.valueOf(168.85)),
                new QuoteItem(Currency.XRP, BigDecimal.valueOf(0.2418))));

        final Report report = new Report(portfolio, exchangeRateQuote);
        final BigDecimal totalValue = report.getTotalValue();

        assertThat(expected, is(totalValue.setScale(2, RoundingMode.HALF_UP))); // 92904.85 = 10 * 9157.7 + 5 * 168.85 + 2000 * 0.2418
    }
}