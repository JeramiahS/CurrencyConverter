package utilityclasses;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class APIHandler {

    private static final HttpClient CLIENT = HttpClient.newBuilder().build();

    /**
     * getConversionResult returns the desired result from the response given by the currency converter server via a GET
     * request sent through Java's HttpClient API
     *
     * @param value                     A monetary value
     * @param code1                     The currency code of the country to convert from
     * @param code2                     The currency code of the country to convert to
     * @return                          The monetary value after conversion
     * @throws IOException              If the connection to the server fails in any way
     * @throws InterruptedException     If the HttpClient.send() thread gets interrupted in any way
     */
    public static String getConversionResult(double value, String code1, String code2)
            throws IOException, InterruptedException {
        //Build the GET request to be sent to the currency converter server
        final HttpRequest GET_REQUEST = HttpRequest.newBuilder()
                .uri(URI.create(ConverterURLBuilder.getBuiltURL(code1, code2, value)))
                .GET()
                .build();
        //Send the GET request and store the tab-separated server response as a String array
        final String[] RESPONSE_CATEGORIES = CLIENT.send(GET_REQUEST, HttpResponse.BodyHandlers.ofString()).body().split("\t");
        //return the result from the server response
        return RESPONSE_CATEGORIES[RESPONSE_CATEGORIES.length-1].trim();
    }

}