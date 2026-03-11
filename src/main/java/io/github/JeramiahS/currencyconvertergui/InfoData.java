package io.github.JeramiahS.currencyconvertergui;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains the exchange rate found in the response JSON provided by the currency converter server
 *
 * @author Jeramiah Sanchez
 */
public class InfoData {
    @JsonProperty
    public double rate;

    public InfoData() {}
}