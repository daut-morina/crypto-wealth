package io.daut.crypto.wealth.core;

import java.util.List;

public class Portfolio {
    private final List<Money> assets;

    public Portfolio(List<Money> assets) {
        assert assets != null;
        this.assets = assets;
    }

    public List<Money> getAssets() {
        return assets;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "assets=" + assets +
                '}';
    }
}
