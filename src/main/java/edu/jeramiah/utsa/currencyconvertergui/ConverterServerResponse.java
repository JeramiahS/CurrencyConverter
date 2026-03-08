package edu.jeramiah.utsa.currencyconvertergui;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConverterServerResponse {
    @JsonProperty
    public String success;
    @JsonProperty
    public QueryInfo query;
    @JsonProperty
    public InfoData info;
    @JsonProperty
    public String historical;
    @JsonProperty
    public String date;
    @JsonProperty
    public long timestamp;
    @JsonProperty
    public double result;

    public ConverterServerResponse() {}

}

