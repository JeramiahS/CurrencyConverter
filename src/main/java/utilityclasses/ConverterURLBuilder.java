package utilityclasses;

public final class ConverterURLBuilder {
    private static final String BASE_URL = "https://api.fxratesapi.com/convert";

    /**
     * The getBuiltURL concatenates and returns a URL as a String
     *
     * @param fromCurrencyCode  The currency code of the country to convert from
     * @param toCurrencyCode    The currency code of the country to convert to
     * @param amount            The monetary value to convert from
     * @return                  A URL as a String
     */
    public static String getBuiltURL(String fromCurrencyCode, String toCurrencyCode, double amount) {
        return BASE_URL + "?from=" + fromCurrencyCode + "&to=" + toCurrencyCode + "&amount=" + amount + "&format=tsv";
    }

}