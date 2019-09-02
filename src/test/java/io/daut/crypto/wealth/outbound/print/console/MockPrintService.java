package io.daut.crypto.wealth.outbound.print.console;

import io.daut.crypto.wealth.core.PrintService;
import io.daut.crypto.wealth.core.Report;

public class MockPrintService implements PrintService {
    @Override
    public void print(Report report) {
        System.out.println(report);
    }
}
