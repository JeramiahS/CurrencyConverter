package edu.jeramiah.utsa.currencyconvertergui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

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
    private ChoiceBox<?> convertToChoiceBox;

    @FXML
    private Pane mainPane;

    @FXML
    private Label titleLabel;

    @FXML
    private Label conversionResultTextLabel;

    @FXML
    void onConvertButtonClick(MouseEvent event) throws IOException, InterruptedException {
        //TODO: Grab amount from amountTextField
        //TODO: Grab selection from convertFromChoiceBox
        //TODO: Grab selection from convertToChoiceBox
        //TODO: Send GET request to converter server
        //TODO: Parse response JSON
        //TODO: Display parsed result in GUI
        //HTTPHandler.sendConversionRequest(amountTextField.getText(), convertFromChoiceBox.getAccessibleText(), convertToMenu.getAccessibleText());
        conversionResultTextLabel.setText("Conversion Result Placeholder");
        conversionResultTextLabel.setVisible(true);
    }
}
