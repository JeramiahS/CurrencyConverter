package io.github.JeramiahS.currencyconvertergui;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains all the tags found in the JSON sent by the currency converter server
 *
 * @author Jeramiah Sanchez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConverterServerResponse {
    @JsonProperty
    public boolean success;
    @JsonProperty
    public String error;
    @JsonProperty
    public String description;
    @JsonProperty
    public String result;

    public ConverterServerResponse() {}

}

