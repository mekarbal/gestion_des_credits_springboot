package com.spring_credit.start.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="histories")
public class History {

    @Id
    private Long id;
    private Long clientId;
    private Long creditId;
    private double amount;

    public History(Long id, Long clientId, Long creditId, double amount) {
        this.id = id;
        this.clientId = clientId;
        this.creditId = creditId;
        this.amount = amount;
    }
    public History(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCreditId() {
        return creditId;
    }

    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", creditId=" + creditId +
                ", amount=" + amount +
                '}';
    }
}
