package io.daut.crypto.wealth.core;

import java.util.List;

public class WealthReport {
    private final List<WealthReportItem> wealthReportItems;
    private double total;

    public WealthReport(List<WealthReportItem> wealthReportItems) {
        if (wealthReportItems == null) throw new IllegalArgumentException("'wealthReportItems' must not be null");
        this.wealthReportItems = List.copyOf(wealthReportItems);
        this.total = getTotal(wealthReportItems);
    }

    public List<WealthReportItem> getWealthReportItems() {
        return wealthReportItems;
    }

    public double getTotal() {
        return total;
    }

    private static double getTotal(List<WealthReportItem> wealthReportItems) {
        return wealthReportItems
                .stream()
                .map(WealthReportItem::getWorth)
                .reduce(Double::sum)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return "WealthReport{" +
                "wealthReportItems=" + wealthReportItems +
                ", total=" + total +
                '}';
    }
}
