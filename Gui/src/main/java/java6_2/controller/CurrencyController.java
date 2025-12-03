package java6_2.controller;

import dao.CurrencyDao;
import entity.Currency;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java6_2.model.CurrencyModel;

public class CurrencyController {

    private final CurrencyModel model;
    private final CurrencyDao currencyDao;

    public CurrencyController(CurrencyModel model, CurrencyDao currencyDao) {
        this.model = model;
        this.currencyDao = currencyDao;
    }

    public double handleConversion(String amountText, Currency from, Currency to) throws Exception {
        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException ex) {
            throw new Exception("Invalid amount! Please enter a number.");
        }

        // Use the rate embedded in the Currency objects so conversion works
        // even when the database is not available (fallback/demo mode).
        double fromRate = from.getRateToUSD();
        double toRate = to.getRateToUSD();

        if (fromRate <= 0 || toRate <= 0) {
            throw new Exception("Invalid currency rates configured.");
        }

        double amountInUSD = amount / fromRate;
        return amountInUSD * toRate;
    }

    public CurrencyModel getModel() {
        return model;
    }

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }
}

