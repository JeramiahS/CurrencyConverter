package edu.jeramiah.utsa.currencyconvertergui;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {

    @JsonProperty
    public String code;

    @JsonProperty
    public String name;

    public Currency() {}

    @Override
    public String toString() {
        return code + ", " +  name;
    }

}