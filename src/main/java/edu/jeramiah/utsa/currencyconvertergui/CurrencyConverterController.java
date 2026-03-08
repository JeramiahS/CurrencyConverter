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
    private ChoiceBox<Currency> convertFromChoiceBox;

    @FXML
    private Label convertFromLabel;

    @FXML
    private Label convertToLabel;

    @FXML
    private ChoiceBox<Currency> convertToChoiceBox;

    @FXML
    private Pane mainPane;

    @FXML
    private Label titleLabel;

    @FXML
    private Label conversionResultTextLabel;

    /**
     * The initialize method will set the text values of the choice boxes
     */
    @FXML
    public void initialize() {
        convertFromChoiceBox.getItems().addAll(JSONHandler.getCurrencies());
        convertToChoiceBox.getItems().addAll(JSONHandler.getCurrencies());
    }

    /**
     * Sends a conversion request if it passes input checks and displays the result in the GUI
     *
     * @param event                 When the node is left-clicked with a mouse
     * @throws IOException          When an IO error occurs
     * @throws InterruptedException When the connection to the server is interrupted in any way
     */
    @FXML
    void onConvertButtonClick(MouseEvent event) throws IOException, InterruptedException {
        if (amountTextField.getText().isEmpty() || convertFromChoiceBox.getValue() == null || convertToChoiceBox.getValue() == null) {
            conversionResultTextLabel.setText("ERROR: One or more values are empty");
        } else if (amountTextField.getText().equals("0") || !Character.isDigit(amountTextField.getText().charAt(0))) {
            conversionResultTextLabel.setText("ERROR: Amount must be a non-zero number");
        } else {
            final String AMOUNT = amountTextField.getText();
            final String FROM_CODE = extractCurrencyCode(convertFromChoiceBox.getValue().toString());
            final String TO_CODE = extractCurrencyCode(convertToChoiceBox.getValue().toString());
            final ConverterServerResponse SERVER_RESPONSE = JSONHandler.parseServerResponse(AMOUNT, FROM_CODE, TO_CODE);
            final String RESULT_TEXT = String.format("%s %s is %f %s", AMOUNT, FROM_CODE, SERVER_RESPONSE.result, TO_CODE);
            conversionResultTextLabel.setText(RESULT_TEXT);
        }
        conversionResultTextLabel.setVisible(true);
    }

    /**
     * Extracts the currency code from the String provided by the choiceBox object's selected value
     *
     * @param choiceBoxValue    The selected value of the choiceBox object
     * @return                  A three character currency code
     */
    private String extractCurrencyCode(String choiceBoxValue) {
        final String[] CURRENCY_ATTRIBUTES = choiceBoxValue.split("-");
        return CURRENCY_ATTRIBUTES[0].trim();
    }

}