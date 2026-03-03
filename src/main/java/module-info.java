module edu.jeramiah.utsa.currencyconvertergui {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.jeramiah.utsa.currencyconvertergui to javafx.fxml;
    exports edu.jeramiah.utsa.currencyconvertergui;
}