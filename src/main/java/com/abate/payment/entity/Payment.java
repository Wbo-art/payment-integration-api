
package com.abate.payment.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    private String id;

    @Column(nullable = false)
    private String sourceAccount;

    @Column(nullable = false)
    private String destinationAccount;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false, length = 3)
    private String currency;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    @Column(nullable = false)
    private Instant createdAt;

    public Payment() {
    }

    public Payment(
            String id,
            String sourceAccount,
            String destinationAccount,
            BigDecimal amount,
            String currency,
            String description,
            PaymentStatus status,
            Instant createdAt) {

        this.id = id;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getId() { return id; }
    public String getSourceAccount() { return sourceAccount; }
    public String getDestinationAccount() { return destinationAccount; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getDescription() { return description; }
    public PaymentStatus getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
