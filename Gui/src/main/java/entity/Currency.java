package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CURRENCY")
public class Currency {

    @Id
    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "name")
    private String name;

    @Column(name = "rate_to_usd")
    private double rateToUSD;

    public Currency() {
        // required by JPA
    }

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

