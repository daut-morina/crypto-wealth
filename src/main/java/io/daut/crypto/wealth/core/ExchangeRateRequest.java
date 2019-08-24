package io.daut.crypto.wealth.core;

public class ExchangeRateRequest {
    private final Currency source;
    private final Currency target;

    public ExchangeRateRequest(Currency source, Currency target) {
        if (source == null) throw new IllegalArgumentException("'source' must not be null");
        this.source = source;

        if (target == null) throw new IllegalArgumentException("'target' must not be null");
        this.target = target;
    }

    public Currency getSource() {
        return source;
    }

    public Currency getTarget() {
        return target;
    }
}
