package io.daut.crypto.wealth.outbound.printer;

import io.daut.crypto.wealth.core.PrintService;
import io.daut.crypto.wealth.core.WealthReport;

public class ConsolePrintService implements PrintService {
    @Override
    public void print(WealthReport wealthReport) {
        System.out.println("------------------------");
        System.out.println("Bob's Burgeoning Fortune");
        System.out.println("------------------------");
        System.out.println("Currency\tValue in EUR");
        System.out.println("------------------------");
        wealthReport.getWealthReportItems()
                .forEach(wealthReportItem ->
                        System.out.printf("%s \t\t%8.2f\n",
                                wealthReportItem.getSource().getValue(),
                                wealthReportItem.getWorth()));
        System.out.println("------------------------");
        System.out.printf("Total\t\t%8.2f\n",wealthReport.getTotal());
        System.out.println("------------------------");
    }
}
