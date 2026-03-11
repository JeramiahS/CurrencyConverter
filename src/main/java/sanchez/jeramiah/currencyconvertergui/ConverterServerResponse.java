package sanchez.jeramiah.currencyconvertergui;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains all the tags found in the JSON sent by the currency converter server
 *
 * @author Jeramiah Sanchez
 */
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

