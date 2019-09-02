package io.daut.crypto.wealth.outbound.exchange.rate.crypto.compare;

import io.daut.crypto.wealth.core.Currency;
import io.daut.crypto.wealth.core.ExchangeRateQuote;
import io.daut.crypto.wealth.core.ExchangeRateRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.net.http.HttpClient;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CryptoCompareExchangeRateServiceTest {
    @Test
    public void testGetExchangeRates() {
        // given
        final HttpClient httpClient = new MockHttpClient();
        final CryptoCompareClient client = CryptoCompareClient.create(httpClient);
        final CryptoCompareExchangeRateService service = CryptoCompareExchangeRateService.create(client);
        final ExchangeRateRequest request = new ExchangeRateRequest(List.of(Currency.BTC), Currency.EUR);

        // when
        final ExchangeRateQuote quote = service.getQuote(request);

        // then
        assertThat(BigDecimal.valueOf(9157.7), is(quote.getQuoteItems().get(0).getRate()));
    }
}
