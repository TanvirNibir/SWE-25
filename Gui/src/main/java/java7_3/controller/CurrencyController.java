package java7_3.controller;

import entity.Currency;
import entity.Transaction;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java7_3.dao.CurrencyJpaDao;
import java7_3.dao.TransactionJpaDao;
import java7_3.model.CurrencyModel;

public class CurrencyController {

    private final CurrencyModel model;
    private final CurrencyJpaDao dao;
    private final TransactionJpaDao transactionDao;

    public CurrencyController(CurrencyModel model, CurrencyJpaDao dao, TransactionJpaDao transactionDao) {
        this.model = model;
        this.dao = dao;
        this.transactionDao = transactionDao;
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
        double result = amountInUSD * toRate;

        try {
            Transaction tx = new Transaction(from, to, amount, result);
            transactionDao.persist(tx);
        } catch (Exception e) {
            throw new Exception("Failed to store transaction: " + e.getMessage());
        }

        return result;
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


