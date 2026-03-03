package edu.jeramiah.utsa.currencyconvertergui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class CurrencyConverterController {

    @FXML
    private Label amountLabel;

    @FXML
    private TextField amountTextField;

    @FXML
    private Button convertButton;

    @FXML
    private ChoiceBox<?> convertFromChoiceBox;

    @FXML
    private Label convertFromLabel;

    @FXML
    private Label convertToLabel;

    @FXML
    private ChoiceBox<?> convertToMenu;

    @FXML
    private Pane mainPane;

    @FXML
    private Label titleLabel;

    @FXML
    void getConversionResult(MouseEvent event) {

    }

    @FXML
    void getCurrencies(MouseEvent event) {

    }

}
