package edu.jeramiah.utsa.currencyconvertergui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CurrencyConverterApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CurrencyConverterGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

}
