module edu.jeramiah.utsa.currencyconvertergui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires tools.jackson.databind;


    opens edu.jeramiah.utsa.currencyconvertergui to javafx.fxml;
    exports edu.jeramiah.utsa.currencyconvertergui;
}