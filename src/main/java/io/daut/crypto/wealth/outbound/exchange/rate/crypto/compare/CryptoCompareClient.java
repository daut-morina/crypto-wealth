package io.daut.crypto.wealth.outbound.exchange.rate.crypto.compare;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CryptoCompareClient {
    private static final String BASE_URL = "https://min-api.cryptocompare.com/data/price";
    private static final Pattern RESPONSE_PATTERN = Pattern.compile("(\"[A-Z]{3}\"):(\\d+\\.?\\d*)");

    private final HttpClient httpClient;

    public static CryptoCompareClient create(HttpClient httpClient) {
        return new CryptoCompareClient(httpClient);
    }

    private CryptoCompareClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public BigDecimal getExchangeRate(String source, String target) throws CryptoCompareException {
        final HttpRequest httpRequest = createRequest(source, target);
        try {
            final HttpResponse<String> response = this.httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return parseResponse(response);
        } catch (InterruptedException | IOException | CryptoCompareException e) {
            throw new CryptoCompareException(e.getMessage());
        }
    }

    private static HttpRequest createRequest(String source, String target) {
        final URI uri = URI.create(BASE_URL + "?fsym=" + source + "&tsyms=" + target);

        return HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
    }

    private static BigDecimal parseResponse(HttpResponse<String> response) throws CryptoCompareException {
        final Matcher matcher = RESPONSE_PATTERN.matcher(response.body());

        if (matcher.find()) {
            return BigDecimal.valueOf(Double.parseDouble(matcher.group(2)));
        } else {
            throw new CryptoCompareException("Could not parse response");
        }
    }
}
