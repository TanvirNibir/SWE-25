package dao;

import datasource.MariaDbConnection;
import entity.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {

    public double getRate(String abbreviation) throws SQLException {
        String sql = "SELECT rate_to_usd FROM CURRENCY WHERE abbreviation = ?";
        Connection conn = MariaDbConnection.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, abbreviation);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(1);
                }
            }
        }
        throw new SQLException("Currency not found: " + abbreviation);
    }

    public List<Currency> getAllCurrencies() throws SQLException {
        String sql = "SELECT abbreviation, name, rate_to_usd FROM CURRENCY ORDER BY abbreviation";
        Connection conn = MariaDbConnection.getConnection();
        List<Currency> currencies = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String abbreviation = rs.getString(1);
                String name = rs.getString(2);
                double rate = rs.getDouble(3);
                currencies.add(new Currency(abbreviation, name, rate));
            }
        }
        return currencies;
    }
}


