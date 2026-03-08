package edu.jeramiah.utsa.currencyconvertergui;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoData {
    @JsonProperty
    public double rate;

    public InfoData() {}
}