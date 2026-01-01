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

    public void setAccNo(String accNo) {
        this.accountNumber = accNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccNo() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
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
        if(amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (canWithdraw(amount)) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public abstract String getType();

    public abstract boolean canWithdraw(double amount);
}
