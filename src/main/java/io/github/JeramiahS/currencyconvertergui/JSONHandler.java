package io.github.JeramiahS.currencyconvertergui;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * JSONHandler contains the methods necessary for interaction with JSON files
 *
 * @author Jeramiah Sanchez
 */
public class JSONHandler {
    private static final Map<String, Currency> CURRENCIES_MAP = getCurrenciesFromServerResponse();

    public static Map<String, Currency> getCurrenciesMap() {
        return CURRENCIES_MAP;
    }

    /**
     * Creates an ArrayList from a Map of <code>Currency</code> objects
     * @return An ArrayList of <code>Currency</code> objects
     */
    private static Map<String, Currency> getCurrenciesFromServerResponse() {
        try(final InputStream INPUT_STREAM = HTTPHandler.sendGetAllCurrenciesRequest()) {
            final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
            return OBJECT_MAPPER.readValue(INPUT_STREAM, new TypeReference<>() {});
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Receives the server response and parses a <code>ConverterServerResponse</code> object from the input stream
     *
     * @param AMOUNT            The amount of money to convert
     * @param FROM_CODE         The currency code to convert from
     * @param TO_CODE           The currency code to convert to
     * @return                  A <code>ConverterServerResponse</code> object
     * @throws RuntimeException When a runtime exception occurs
     */
    public static ConverterServerResponse parseServerResponse(final String AMOUNT, final String FROM_CODE, final String TO_CODE) throws RuntimeException {
        try(final InputStream INPUT_STREAM = HTTPHandler.sendConversionRequest(AMOUNT, FROM_CODE, TO_CODE)) {
            final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
            return OBJECT_MAPPER.readValue(INPUT_STREAM, new TypeReference<>() {});
        } catch (IOException | InterruptedException e) {
            System.err.println("Error parsing server response: " + e.getMessage());
        }
        throw new RuntimeException("Error parsing server response");
    }

}