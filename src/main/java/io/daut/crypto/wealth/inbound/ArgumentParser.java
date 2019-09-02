package io.daut.crypto.wealth.inbound;

public class ArgumentParser {
    public static ArgumentParser create() {
        return new ArgumentParser();
    }

    public Arguments parseArguments(String[] args) {
        if (args.length == 0) {
            return Arguments.create();
        }

        if (args.length == 1) {
            return Arguments.create(args[0]);
        }

        return Arguments.create(args[0], args[1]);
    }
}
