package io.daut.crypto.wealth.core;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Report {
    private final List<ReportItem> assets;
    private final BigDecimal totalValue;

    public Report(Portfolio portfolio, ExchangeRateQuote quote) {
        this.assets = portfolio.getAssets().stream()
                .map(money -> new ReportItem(money, new Money(quote.getTargetCurrency(), getRate(quote.getQuoteItems(), money.getCurrency()).multiply(money.getValue()))))
                .collect(Collectors.toList());

        this.totalValue = calculateTotalValue(this.assets);
    }

    public List<ReportItem> getAssets() {
        return assets;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    private static BigDecimal getRate(List<QuoteItem> quoteItems, Currency targetCurrency) {
        return quoteItems.stream()
                .filter(quoteItem -> quoteItem.getSource().equals(targetCurrency))
                .findAny()
                .map(QuoteItem::getRate)
                .orElseThrow(() -> new RuntimeException("Could not find currency '" + targetCurrency + "'"));
    }

    private static BigDecimal calculateTotalValue(List<ReportItem> assets) {
        return assets.stream()
                .map(ReportItem::getValue)
                .map(Money::getValue)
                .reduce(BigDecimal::add)
                .orElseThrow(() -> new RuntimeException("Total value of assets could not be calculated"));
    }

    public static class ReportItem {
        private final Money asset;
        private final Money value;

        public ReportItem(Money asset, Money value) {
            assert asset != null;
            this.asset = asset;

            assert value != null;
            this.value = value;
        }

        public Money getAsset() {
            return asset;
        }

        public Money getValue() {
            return value;
        }
    }
}
