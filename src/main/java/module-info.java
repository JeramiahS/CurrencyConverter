module sanchez.jeramiah.currencyconvertergui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires tools.jackson.databind;


    opens sanchez.jeramiah.currencyconvertergui to javafx.fxml;
    exports sanchez.jeramiah.currencyconvertergui;
}