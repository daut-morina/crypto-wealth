package io.daut.crypto.wealth.core;

public class WealthReportItem {
    private final Currency source;
    private final Currency target;
    private final double worth;

    public WealthReportItem(Currency source, Currency target, double worth) {
        if (source == null) throw new IllegalArgumentException("'source' must not be null");
        this.source = source;

        if (target == null) throw new IllegalArgumentException("'target' must not be null");
        this.target = target;

        if (worth < 0) throw new IllegalArgumentException("'worth' must not be negative");
        this.worth = worth;
    }

    public Currency getSource() {
        return source;
    }

    public Currency getTarget() {
        return target;
    }

    public double getWorth() {
        return worth;
    }

    @Override
    public String toString() {
        return "WealthReportItem{" +
                "source=" + source +
                ", target=" + target +
                ", worth=" + worth +
                '}';
    }
}