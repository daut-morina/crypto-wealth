package io.daut.crypto.wealth.outbound.exchange;

import io.daut.crypto.wealth.core.Currency;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CryptoCompareClient {
    private static final String BASE_URL = "https://min-api.cryptocompare.com/data/price";
    private static final Pattern RESPONSE_PATTERN = Pattern.compile("(\"[A-Z]{3}\"):(\\d+\\.?\\d*)");

    private final HttpClient client;

    public CryptoCompareClient(HttpClient httpClient) {
        this.client = httpClient;
    }

    public double getExchangeRate(String source, String target) throws IOException, InterruptedException {
        final HttpRequest request = createRequest(source, target);
        final HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        return parseResponse(response);
    }

    private HttpRequest createRequest(String source, String target) {
        final URI uri = URI.create(BASE_URL + "?fsym=" + source + "&tsyms=" + target);

        return HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
    }

    private static double parseResponse(HttpResponse<String> response) {
        final Matcher matcher = RESPONSE_PATTERN.matcher(response.body());

        if (matcher.find()) {
            return Double.parseDouble(matcher.group(2));
        } else {
            return 0.0;
        }
    }
}
