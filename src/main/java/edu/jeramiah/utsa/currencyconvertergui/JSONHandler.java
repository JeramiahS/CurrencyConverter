package edu.jeramiah.utsa.currencyconvertergui;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * JSONHandler contains the methods necessary for interaction with JSON files
 *
 * @author Jeramiah Sanchez
 */
public class JSONHandler {
    private static final ArrayList<Currency> CURRENCIES = getCurrenciesListFromJSON();

    public static ArrayList<Currency> getCurrencies() {
        return CURRENCIES;
    }

    private static ArrayList<Currency> getCurrenciesListFromJSON() {
        final File CURRENCIES_JSON = new File ("src/main/resources/edu/jeramiah/utsa/currencyconvertergui/files/currencies.json");
        final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        final Map<String, Currency> CURRENCY_MAP = OBJECT_MAPPER.readValue(CURRENCIES_JSON, new TypeReference<>() {});
        return new ArrayList<>(CURRENCY_MAP.values());
    }

    public static ConverterServerResponse parseServerResponse(final String AMOUNT, final String FROM_CODE, final String TO_CODE) throws RuntimeException {
        try(final InputStream INPUT_STREAM = HTTPHandler.sendConversionRequest(AMOUNT, FROM_CODE, TO_CODE)) {
            final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
            return OBJECT_MAPPER.readValue(INPUT_STREAM, ConverterServerResponse.class);
        } catch (IOException | InterruptedException e) {
            System.err.println("Error parsing server response: " + e.getMessage());
        }
        throw new RuntimeException("Error parsing server response");
    }

}