package io.daut.crypto.wealth.inbound;

import io.daut.crypto.wealth.core.Currency;
import io.daut.crypto.wealth.core.Money;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FortuneFileTest {
    @Test
    public void testFortuneFileWithValidInput() {
        final String fortune = "BTC=10\nETH=5\nXRP=2000";
        final BufferedReader bufferedReader = new BufferedReader(new StringReader(fortune));
        final FortuneFile fortuneFile = new FortuneFile(bufferedReader);
        final List<Money> monies = fortuneFile.parseFortune();

        assertEquals(3, monies.size());
        assertEquals(Currency.BTC, monies.get(0).getCurrency());
        assertEquals(10.0, monies.get(0).getValue(), 0.1);
    }
}
