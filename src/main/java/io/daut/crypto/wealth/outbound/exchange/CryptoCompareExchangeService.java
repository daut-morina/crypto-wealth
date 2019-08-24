package io.daut.crypto.wealth.outbound.exchange;

import io.daut.crypto.wealth.core.ExchangeRate;
import io.daut.crypto.wealth.core.ExchangeRateRequest;
import io.daut.crypto.wealth.core.ExchangeService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CryptoCompareExchangeService implements ExchangeService {

    private final CryptoCompareClient cryptoCompareClient;

    public CryptoCompareExchangeService(CryptoCompareClient cryptoCompareClient) {
        this.cryptoCompareClient = cryptoCompareClient;
    }

    @Override
    public List<ExchangeRate> getExchangeRates(List<ExchangeRateRequest> exchangeRateRequests) {
        return exchangeRateRequests.stream()
                .map(exchangeRateRequest -> {
                    try {
                        final double exchangeRate = this.cryptoCompareClient.getExchangeRate(exchangeRateRequest.getSource().getValue(), exchangeRateRequest.getTarget().getValue());
                        return new ExchangeRate(exchangeRateRequest.getSource(), exchangeRateRequest.getTarget(), exchangeRate);
                    } catch (IOException | InterruptedException e) {
                        return new ExchangeRate(exchangeRateRequest.getSource(), exchangeRateRequest.getTarget(), 0);
                    }
                })
                .collect(Collectors.toList());
    }
}
