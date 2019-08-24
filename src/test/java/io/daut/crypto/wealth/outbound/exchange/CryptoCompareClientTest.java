package io.daut.crypto.wealth.outbound.exchange;

import io.daut.crypto.wealth.core.Currency;
import org.junit.Test;

import java.io.IOException;
import java.net.http.HttpClient;

import static org.junit.Assert.assertEquals;

public class CryptoCompareClientTest {
    @Test
    public void testGetExchangeRate() throws IOException, InterruptedException {
        final HttpClient httpClient = new MockHttpClient();
        final CryptoCompareClient cryptoCompareClient = new CryptoCompareClient(httpClient);
        final double exchangeRate = cryptoCompareClient.getExchangeRate("btc", "eur");

        assertEquals(9048.21, exchangeRate, 0.01);
    }
}
