package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CurrencyModel {
    public static class Currency {
        private final String abbreviation;
        private final String name;
        private final double rateToUSD;

        public Currency(String abbreviation, String name, double rateToUSD) {
            this.abbreviation = abbreviation;
            this.name = name;
            this.rateToUSD = rateToUSD;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public String getName() {
            return name;
        }

        public double getRateToUSD() {
            return rateToUSD;
        }

        @Override
        public String toString() {
            return abbreviation + " - " + name;
        }
    }

    private final ObservableList<Currency> currencies;

    public CurrencyModel() {
        currencies = FXCollections.observableArrayList(
                new Currency("USD", "US Dollar", 1.0),
                new Currency("EUR", "Euro", 0.92),
                new Currency("GBP", "British Pound", 0.79),
                new Currency("JPY", "Japanese Yen", 148.0),
                new Currency("INR", "Indian Rupee", 83.0)
        );
    }

    public ObservableList<Currency> getCurrencies() {
        return currencies;
    }

    public double convert(double amount, Currency from, Currency to) {
        double amountInUSD = amount / from.getRateToUSD();
        return amountInUSD * to.getRateToUSD();
    }
}
