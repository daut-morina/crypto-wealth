package io.daut.crypto.wealth.core;

public class Money {
    private final Currency currency;
    private final double value;

    public Money(Currency currency, double value) {
        if (currency == null) throw new IllegalArgumentException("'currency' must not be null");
        this.currency = currency;

        if (value < 0) throw new IllegalArgumentException("'value' must not be negative");
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Money{" +
                "currency=" + currency +
                ", value=" + value +
                '}';
    }
}
