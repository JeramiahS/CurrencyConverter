package io.github.JeramiahS.currencyconvertergui;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains the information provided in the GET request to the currency converter server
 *
 * @author Jeramiah Sanchez
 */
public class QueryInfo {
    @JsonProperty
    public String from;
    @JsonProperty
    public String to;
    @JsonProperty
    public double amount;

    public QueryInfo() {}
}