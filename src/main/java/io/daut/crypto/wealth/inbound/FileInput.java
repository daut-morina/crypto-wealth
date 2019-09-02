package io.daut.crypto.wealth.inbound;

import io.daut.crypto.wealth.core.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class FileInput {
    private final ReportService reportService;

    public static FileInput create(ReportService reportService) {
        return new FileInput(reportService);
    }

    private FileInput(ReportService reportService) {
        this.reportService = reportService;
    }

    public void printReport(Arguments arguments) throws FileNotFoundException {
        final Currency targetCurrency = Currency.from(arguments.getTargetCurrency());
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(arguments.getFilePath()));
        final FortuneFile fortuneFile = new FortuneFile(bufferedReader);
        final List<Money> fortune = fortuneFile.parseFortune();
        final Portfolio portfolio = new Portfolio(fortune);
        final Report report = reportService.generateReport(portfolio, targetCurrency);
    }
}
