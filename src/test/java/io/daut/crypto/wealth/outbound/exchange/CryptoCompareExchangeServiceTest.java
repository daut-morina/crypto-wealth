package io.daut.crypto.wealth.outbound.exchange;

import io.daut.crypto.wealth.core.Currency;
import io.daut.crypto.wealth.core.Money;
import io.daut.crypto.wealth.core.WealthReport;
import org.junit.Test;

import java.net.http.HttpClient;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CryptoCompareExchangeServiceTest {
    @Test
    public void testCalculateWealthReport() {
        final HttpClient httpClient = new MockHttpClient();
        final CryptoCompareClient cryptoCompareClient = new CryptoCompareClient(httpClient);
        final CryptoCompareExchangeService cryptoCompareExchangeService = new CryptoCompareExchangeService(cryptoCompareClient);
        final List<Money> monies = List.of(new Money(Currency.BTC, 10.0));
//        final WealthReport wealthReport = cryptoCompareExchangeService.calculateWealthReport(portfolio);
//
//        assertEquals(1, wealthReport.getPortfolio().size());
//        assertEquals(90482.1, wealthReport.getPortfolio().get(Currency.BTC).getValue(), 0.01);
//        assertEquals(90482.1, wealthReport.getTotal(), 0.01);
    }
}
