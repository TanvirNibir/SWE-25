package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.CurrencyModel;
import model.CurrencyModel.Currency;

public class CurrencyController {
    private final CurrencyModel model;

    public CurrencyController(CurrencyModel model) {
        this.model = model;
    }

    public double handleConversion(String amountText, Currency from, Currency to) throws Exception {
        try {
            double amount = Double.parseDouble(amountText);
            return model.convert(amount, from, to);
        } catch (NumberFormatException ex) {
            throw new Exception("Invalid amount! Please enter a number.");
        }
    }

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }
}
