package java7_3.model;

import entity.Currency;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java7_3.dao.CurrencyJpaDao;

import java.util.List;

public class CurrencyModel {

    private final CurrencyJpaDao dao;
    private final ObservableList<Currency> currencies;

    public CurrencyModel(CurrencyJpaDao dao) {
        this.dao = dao;
        this.currencies = FXCollections.observableArrayList();
        reload();
    }

    public ObservableList<Currency> getCurrencies() {
        return currencies;
    }

    public void reload() {
        currencies.clear();
        List<Currency> all = dao.findAll();
        currencies.addAll(all);
    }
}


