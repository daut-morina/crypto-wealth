package io.daut.crypto.wealth.inbound;

public class Arguments {
    public static final String DEFAULT_FILE_PATH = "./src/main/resources/bobs_crypto.txt";
    public static final String DEFAULT_CURRENCY = "eur";

    private final String file;
    private final String targetCurrency;

    public static Arguments create() {
        return create(DEFAULT_FILE_PATH, DEFAULT_CURRENCY);
    }

    public static Arguments create(String file) {
        return create(file, DEFAULT_CURRENCY);
    }

    public static Arguments create(String file, String targetCurrency) {
        return new Arguments(file, targetCurrency);
    }

    private Arguments(String file, String targetCurrency) {
        this.file = file;
        this.targetCurrency = targetCurrency;
    }

    public String getFilePath() {
        return file;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    @Override
    public String toString() {
        return "Arguments{" +
                "file='" + file + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                '}';
    }
}
