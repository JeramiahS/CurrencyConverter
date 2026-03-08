package edu.jeramiah.utsa.currencyconvertergui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

/**
 * HTTPHandler contains the methods to send HTTP Requests to the currency converter server
 *
 * @author Jeramiah Sanchez
 */
public class HTTPHandler {

    /**
     * Sends a GET request containing the parameters to convert the given amount of currency and returns the
     * response input stream
     *
     * @param AMOUNT                The amount of money to convert
     * @param FROM_CODE             The currency code to convert from
     * @param TO_CODE               The currency code to convert to
     * @throws IOException          Thrown when an IO exception occurs
     * @throws InterruptedException Thrown when the connection to the server gets interrupted
     */
    public static InputStream sendConversionRequest(final String AMOUNT, final String FROM_CODE, final String TO_CODE) throws IOException, InterruptedException {
        try (final HttpClient HTTP_CLIENT = HttpClient.newHttpClient()) {
            final String CURRENCY_CONVERTER_URL = String.format(
                    "https://api.fxratesapi.com/convert?from=%s&to=%s&amount=%s",
                    FROM_CODE,
                    TO_CODE,
                    AMOUNT
            );
            final HttpRequest REQUEST = HttpRequest.newBuilder().uri(URI.create(CURRENCY_CONVERTER_URL)).GET().build();
            return HTTP_CLIENT.send(REQUEST, HttpResponse.BodyHandlers.ofInputStream()).body();
        }
    }

    /**
     * Sends a GET request to receive a JSON file containing all FXRates supported currencies
     *
     * @throws IOException          Thrown when an IO exception occurs
     * @throws InterruptedException Thrown when the connection to the server gets interrupted
     */
    public static void sendGetAllCurrenciesRequest() throws IOException, InterruptedException {
        try (final HttpClient HTTP_CLIENT = HttpClient.newHttpClient()) {
            final String GET_CURRENCIES_URL = "https://api.fxratesapi.com/currencies";
            final HttpRequest REQUEST = HttpRequest.newBuilder().uri(URI.create(GET_CURRENCIES_URL)).GET().build();
            HTTP_CLIENT.send(REQUEST, HttpResponse.BodyHandlers.ofFile(Path.of("src/main/resources/edu/jeramiah/utsa/currencyconvertergui/files/currencies.json")));
        }
    }

}