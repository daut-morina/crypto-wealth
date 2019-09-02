package io.daut.crypto.wealth.outbound.print.console.console;

import io.daut.crypto.wealth.core.PrintService;
import io.daut.crypto.wealth.core.Report;

public class ConsolePrintService implements PrintService {
    @Override
    public void print(Report report) {
        System.out.println("------------------------");
        System.out.println("Bob's Burgeoning Fortune");
        System.out.println("------------------------");
        System.out.println("Currency\tValue in EUR");
        System.out.println("------------------------");
        report.getAssets()
                .forEach(reportItem ->
                        System.out.printf("%s\t\t\t%8.2f\n",
                                reportItem.getAsset().getValue(),
                                reportItem.getValue().getValue()));
        System.out.println("------------------------");
        System.out.printf("Total\t\t%8.2f\n",report.getTotalValue());
        System.out.println("------------------------");

    }
}
