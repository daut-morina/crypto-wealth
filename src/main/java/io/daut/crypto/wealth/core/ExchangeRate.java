package io.daut.crypto.wealth.core;

public class ExchangeRate {
    private final Currency source;
    private final Currency target;
    private final double rate;

    public ExchangeRate(Currency source, Currency target, double rate) {
        if (source == null) throw new IllegalArgumentException("'source' must not be null");
        this.source = source;

        if (target == null) throw new IllegalArgumentException("'target' must not be null");
        this.target = target;

        if (rate <= 0) throw new IllegalArgumentException("'rate' cannot be 0 or less");
        this.rate = rate;
    }

    public Currency getSource() {
        return source;
    }

    public Currency getTarget() {
        return target;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "source=" + source +
                ", target=" + target +
                ", rate=" + rate +
                '}';
    }
}
