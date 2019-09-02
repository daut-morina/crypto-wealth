package io.daut.crypto.wealth.outbound.exchange.rate.crypto.compare;

public class CryptoCompareException extends Exception {
    private final String message;

    public CryptoCompareException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
