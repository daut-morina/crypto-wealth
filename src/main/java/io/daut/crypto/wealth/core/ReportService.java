package io.daut.crypto.wealth.core;

import java.util.List;
import java.util.stream.Collectors;

public class ReportService {
    private final ExchangeRateService exchangeRateService;
    private final PrintService printService;

    public ReportService(ExchangeRateService exchangeRateService, PrintService printService) {
        assert exchangeRateService != null;
        this.exchangeRateService = exchangeRateService;

        assert printService != null;
        this.printService = printService;
    }

    public Report generateReport(Portfolio portfolio, Currency targetCurrency) {
        final List<Currency> sourceCurrencies = portfolio.getAssets().stream()
                .map(Money::getCurrency)
                .collect(Collectors.toList());
        final ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest(sourceCurrencies, targetCurrency);
        final ExchangeRateQuote exchangeRateQuote = exchangeRateService.getQuote(exchangeRateRequest);
        final Report report = new Report(portfolio, exchangeRateQuote);

        printService.print(report);

        return report;
    }
}
