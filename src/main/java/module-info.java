module io.github.JeramiahS.currencyconvertergui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires tools.jackson.databind;


    opens io.github.JeramiahS.currencyconvertergui to javafx.fxml;
    exports io.github.JeramiahS.currencyconvertergui;
}