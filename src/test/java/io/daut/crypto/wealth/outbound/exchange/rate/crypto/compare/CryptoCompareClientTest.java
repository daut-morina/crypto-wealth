package io.daut.crypto.wealth.outbound.exchange.rate.crypto.compare;

import org.junit.Test;

import java.math.BigDecimal;
import java.net.http.HttpClient;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CryptoCompareClientTest {
    @Test
    public void testGetExchangeRates() throws CryptoCompareException {
        final HttpClient httpClient = new MockHttpClient();
        final CryptoCompareClient cryptoCompareClient = CryptoCompareClient.create(httpClient);
        final BigDecimal exchangeRate = cryptoCompareClient.getExchangeRate("BTC", "EUR");

        assertThat(BigDecimal.valueOf(9157.7), is(exchangeRate));
    }
}
