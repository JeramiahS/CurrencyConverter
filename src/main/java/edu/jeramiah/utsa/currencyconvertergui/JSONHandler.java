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

    /**
     * Reads the currencies.json file and writes all currencies to a text file as a list of {codes, names}
     */
    public static void readCurrenciesToFile () {
        final File CURRENCIES_JSON = new File ("src/main/resources/edu/jeramiah/utsa/currencyconvertergui/files/currencies.json");
        final File CURRENCIES_LIST_TXT = new File ("src/main/resources/edu/jeramiah/utsa/currencyconvertergui/files/currency-list.txt");
        final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        final Map<String, Currency> CURRENCY_MAP = OBJECT_MAPPER.readValue(CURRENCIES_JSON, new TypeReference<>() {});
        final ArrayList<Currency> CURRENCIES_ARRAY_LIST = new ArrayList<>(CURRENCY_MAP.values());

        try (final BufferedWriter BUFFERED_WRITER = new BufferedWriter(new FileWriter(CURRENCIES_LIST_TXT))) {
            for (int i = 0; i < CURRENCIES_ARRAY_LIST.size(); i++) {
                if (i != CURRENCIES_ARRAY_LIST.size() - 1) {
                    BUFFERED_WRITER.write(CURRENCIES_ARRAY_LIST.get(i).toString() + "\n");
                } else {
                    BUFFERED_WRITER.write(CURRENCIES_ARRAY_LIST.get(i).toString());
                }
            }
        } catch (IOException _) {
            System.err.println("Error reading:" + CURRENCIES_LIST_TXT.getAbsolutePath());
        }

    }

}