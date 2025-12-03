package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "source_currency", nullable = false)
    private Currency sourceCurrency;

    @ManyToOne(optional = false)
    @JoinColumn(name = "target_currency", nullable = false)
    private Currency targetCurrency;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "result_amount", nullable = false)
    private double resultAmount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Transaction() {
        // required by JPA
    }

    public Transaction(Currency sourceCurrency,
                       Currency targetCurrency,
                       double amount,
                       double resultAmount) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.resultAmount = resultAmount;
        this.createdAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public double getResultAmount() {
        return resultAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}


