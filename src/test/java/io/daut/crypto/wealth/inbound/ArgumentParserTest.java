package io.daut.crypto.wealth.inbound;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArgumentParserTest {
    @Test
    public void testParseArgumentWithFilePathAndCurrency() {
        final ArgumentParser argumentParser = ArgumentParser.create();
        final String[] args = {"~/millions.txt", "chf"};
        final Arguments arguments = argumentParser.parseArguments(args);

        assertThat(arguments.getFilePath(), is("~/millions.txt"));
        assertThat(arguments.getTargetCurrency(), is("chf"));
    }

    @Test
    public void testParseArgumentsWithFilePath() {
        final ArgumentParser argumentParser = ArgumentParser.create();
        final String[] args = {"~/millions.txt"};
        final Arguments arguments = argumentParser.parseArguments(args);

        assertThat(arguments.getFilePath(), is("~/millions.txt"));
        assertThat(arguments.getTargetCurrency(), is("eur"));
    }

    @Test
    public void testParseArgumentsWithNoArguments() {
        final ArgumentParser argumentParser = ArgumentParser.create();
        final String[] args = {};
        final Arguments arguments = argumentParser.parseArguments(args);

        assertThat(arguments.getFilePath(), is(Arguments.DEFAULT_FILE_PATH));
        assertThat(arguments.getTargetCurrency(), is(Arguments.DEFAULT_CURRENCY));
    }
}
