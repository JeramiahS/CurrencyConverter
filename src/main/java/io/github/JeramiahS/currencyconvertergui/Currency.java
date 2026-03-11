package io.github.JeramiahS.currencyconvertergui;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains the code and name fields found in the currencies JSON given by the currency converter server
 *
 * @author Jeramiah Sanchez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {

    @JsonProperty
    public String symbol_native;

    @JsonProperty
    public String code;

    @JsonProperty
    public String name;

    public Currency() {}

    @Override
    public String toString() {
        return code + " - " +  name;
    }

}