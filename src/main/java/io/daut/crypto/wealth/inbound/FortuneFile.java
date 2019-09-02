package io.daut.crypto.wealth.inbound;

import io.daut.crypto.wealth.core.Currency;
import io.daut.crypto.wealth.core.Money;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class FortuneFile {
    private final BufferedReader reader;

    public FortuneFile(BufferedReader reader) {
        this.reader = reader;
    }

    public List<Money> parseFortune() {
        return this.reader.lines()
                .map(line -> line.split("="))
                .map(FortuneFile::toMoney)
                .collect(Collectors.toList());
    }

    private static Money toMoney(String[] line) {
        final Currency currency = Currency.from(line[0]);
        final double value = Double.parseDouble(line[1]);
        return new Money(currency, BigDecimal.valueOf(value));
    }
}
