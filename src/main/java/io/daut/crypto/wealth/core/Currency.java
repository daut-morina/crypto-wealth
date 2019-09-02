package io.daut.crypto.wealth.core;

import java.util.Arrays;

public enum Currency {
    BTC("BTC"),
    CHF("CHF"),
    ETH("ETH"),
    EUR("EUR"),
    XRP("XRP");

    private final String code;

    Currency(String code) {
        this.code = code;
    }

    public static Currency from(String currency) {
        return Arrays.stream(Currency.values())
                .filter(c -> c.getCode().equalsIgnoreCase(currency))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Could not find Currency '" + currency + "'"));
    }

    public String getCode() {
        return code;
    }
}
