package io.daut.crypto.wealth.core;

import java.util.List;
import java.util.stream.Collectors;

public class WealthReportService {

    private final ExchangeService exchangeService;
    private final PrintService printService;

    public WealthReportService(ExchangeService exchangeService, PrintService printService) {
        if (exchangeService == null) throw new IllegalArgumentException("'exchangeService' must not be null");
        this.exchangeService = exchangeService;

        if (printService == null) throw new IllegalArgumentException("'printService' must not be null");
        this.printService = printService;
    }

    public WealthReport calculateWealth(List<Money> monies) {
        final List<ExchangeRateRequest> exchangeRateRequests = createExchangeRateRequests(monies);
        final List<ExchangeRate> exchangeRates = exchangeService.getExchangeRates(exchangeRateRequests);
        final WealthReport wealthReport = createWealthReport(monies, exchangeRates);

        printService.print(wealthReport);

        return wealthReport;
    }

    private List<ExchangeRateRequest> createExchangeRateRequests(List<Money> monies) {
        return monies.stream()
                .map(money -> new ExchangeRateRequest(money.getCurrency(), Currency.EUR))
                .collect(Collectors.toList());
    }

    private WealthReport createWealthReport(List<Money> monies, List<ExchangeRate> exchangeRates) {
        return exchangeRates.stream()
                .map(exchangeRate -> monies.stream()
                        .filter(m -> exchangeRate.getSource().equals(m.getCurrency()))
                        .findAny()
                        .map(m -> new WealthReportItem(exchangeRate.getSource(),
                                exchangeRate.getTarget(),
                                m.getValue() * exchangeRate.getRate()))
                        .orElse(new WealthReportItem(exchangeRate.getSource(), exchangeRate.getTarget(), 0)))
                .collect(Collectors.collectingAndThen(Collectors.toList(), WealthReport::new));
    }
}
