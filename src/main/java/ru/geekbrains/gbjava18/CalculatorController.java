package ru.geekbrains.gbjava18;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;

public class CalculatorController {
    @FXML
    private TextField resultTextField;

    private StringBuilder numberInput = new StringBuilder();
    private long firstNumber = 0;
    private String operator = "";

    @FXML
    private void handleDigitButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        numberInput.append(button.getText());
        resultTextField.setText(numberInput.toString());
    }

    @FXML
    private void handleClearButton(ActionEvent event) {
        numberInput.setLength(0);
        resultTextField.clear();
    }

    @FXML
    private void handleOperatorButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        operator = button.getText();
        firstNumber = Long.parseLong(numberInput.toString());
        numberInput.setLength(0);
    }

    @FXML
    private void handleEqualsButton() {

        if (numberInput.length() == 0) {
            return;
        }

        long secondNumber = Long.parseLong(numberInput.toString());
        long result = 0;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    resultTextField.setText("Error: Division by zero");
                    return;
                }
                break;
        }

        numberInput.setLength(0);
        numberInput.append(String.valueOf(result));

        resultTextField.setText(String.valueOf(result));
    }

    @FXML
    private void handleExitMenuItem(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void handleAboutMenuItem(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Calculator");
        alert.setContentText("This is a calculator application built with JavaFX by Alexander Listopadov");
        alert.showAndWait();
    }

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private MenuItem aboutMenuItem;
}