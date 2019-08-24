package io.daut.crypto.wealth.core;

import java.util.Arrays;

public enum Currency {
    BTC("BTC"),
    CHF("CHF"),
    ETH("ETH"),
    EUR("EUR"),
    XRP("XRP");

    private final String value;

    Currency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Currency from(String currency) {
        return Arrays.stream(Currency.values())
                .filter(c -> currency.equalsIgnoreCase(c.getValue()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Currency '" + currency + "' not found"));
    }

    @Override
    public String toString() {
        return "Currency{" +
                "value='" + value + '\'' +
                '}';
    }
}
