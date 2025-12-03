package java7_3.controller;

import entity.Currency;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java7_3.dao.CurrencyJpaDao;
import java7_3.model.CurrencyModel;

public class CurrencyController {

    private final CurrencyModel model;
    private final CurrencyJpaDao dao;

    public CurrencyController(CurrencyModel model, CurrencyJpaDao dao) {
        this.model = model;
        this.dao = dao;
    }

    public CurrencyModel getModel() {
        return model;
    }

    public double handleConversion(String amountText, Currency from, Currency to) throws Exception {
        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException ex) {
            throw new Exception("Invalid amount! Please enter a number.");
        }

        if (from == null || to == null) {
            throw new Exception("Please select both source and target currencies.");
        }

        double fromRate = from.getRateToUSD();
        double toRate = to.getRateToUSD();
        double amountInUSD = amount / fromRate;
        return amountInUSD * toRate;
    }

    public void addCurrency(String abbreviation, String name, String rateText) throws Exception {
        if (abbreviation == null || abbreviation.isBlank()
                || name == null || name.isBlank()
                || rateText == null || rateText.isBlank()) {
            throw new Exception("All fields are required.");
        }

        double rate;
        try {
            rate = Double.parseDouble(rateText);
        } catch (NumberFormatException e) {
            throw new Exception("Rate must be a number.");
        }

        try {
            dao.persist(new Currency(abbreviation.toUpperCase(), name, rate));
            model.reload();
        } catch (Exception e) {
            throw new Exception("Failed to insert currency: " + e.getMessage());
        }
    }

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }
}


