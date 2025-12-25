package model;

public abstract class Account {
    protected String accountNumber;
    protected String name;
    protected String password;
    protected String email;
    protected String phoneNum;
    protected double balance;

    public Account(String accountNumber, String name, String password, String email, String phoneNum, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public abstract String getType();
}
