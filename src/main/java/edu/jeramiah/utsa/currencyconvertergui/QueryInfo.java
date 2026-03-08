package edu.jeramiah.utsa.currencyconvertergui;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryInfo {
    @JsonProperty
    public String from;
    @JsonProperty
    public String to;
    @JsonProperty
    public double amount;

    public QueryInfo() {}
}