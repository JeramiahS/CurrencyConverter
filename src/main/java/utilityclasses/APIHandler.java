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
        return getResultFromServerResponse(getConverterServerResponse(value, code1, code2));
    }

    private static String getResultFromServerResponse(String serverResponse) {
        final String[] RESULTS = serverResponse.split("\t");
        return RESULTS[RESULTS.length-1].trim();
    }

    private static String getConverterServerResponse(double value, String currencyCode1, String currencyCode2)
            throws IOException, InterruptedException {
        return getServerResponseAsString(buildHttpGETRequest(ConverterURLBuilder.getBuiltURL(currencyCode1, currencyCode2, value)));
    }

    private static String getServerResponseAsString(HttpRequest httpRequest) throws IOException, InterruptedException {
        return CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body();
    }

    private static HttpRequest buildHttpGETRequest(String URL) {
        return HttpRequest.newBuilder(URI.create(URL)).GET().build();
    }

}