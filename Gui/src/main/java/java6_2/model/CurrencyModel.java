package java6_2.model;

import dao.CurrencyDao;
import entity.Currency;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CurrencyModel {

    private final ObservableList<Currency> currencies;

    public CurrencyModel(CurrencyDao dao) throws SQLException {
        this.currencies = FXCollections.observableArrayList();
        this.currencies.addAll(dao.getAllCurrencies());
    }

    /**
     * Fallback constructor that allows using a predefined set of currencies
     * without requiring a live database connection.
     */
    public CurrencyModel(Iterable<Currency> initialCurrencies) {
        this.currencies = FXCollections.observableArrayList();
        for (Currency currency : initialCurrencies) {
            this.currencies.add(currency);
        }
    }

    public ObservableList<Currency> getCurrencies() {
        return currencies;
    }
}

