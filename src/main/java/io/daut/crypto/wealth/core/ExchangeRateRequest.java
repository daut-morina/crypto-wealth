package io.daut.crypto.wealth.core;

import java.util.List;

public class ExchangeRateRequest {
    private final List<Currency> sources;
    private final Currency target;

    public ExchangeRateRequest(List<Currency> sources, Currency target) {
        assert sources != null;
        this.sources = sources;

        assert  target != null;
        this.target = target;
    }

    public List<Currency> getSources() {
        return sources;
    }

    public Currency getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "ExchangeRateRequest{" +
                "sources=" + sources +
                ", target=" + target +
                '}';
    }
}
