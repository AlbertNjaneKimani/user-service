package com.albert.com.userservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
@Table("user_transaction")
public class UserTransaction {
    @Id
    private Integer id;
    private Integer userId;
    private Integer amount;
    @Column("transaction_date")
    private LocalDateTime transactionDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "UserTransaction{" +
                "id=" + id +
                ", userId=" + userId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
