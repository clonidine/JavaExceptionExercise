package model.entities;

import model.exceptions.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withDraw(double amount) throws DomainException {

        if (withDrawLimit < amount) {
            throw new DomainException("The amount exceeds withdraw limit");
        }

        if (balance < amount) {
            throw new DomainException("Not enough balance");
        }

        balance -= amount;
    }
}
