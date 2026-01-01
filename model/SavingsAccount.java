package model;

public class SavingsAccount extends Account {

    private static final double MIN_BALANCE = 500;

    public SavingsAccount(String acc, String name, String pass, String email, String phoneNum,double balance) {
        super(acc, name, pass, email, phoneNum, balance);
    }

    @Override
    public String getType() {
        return "Savings";
    }

    @Override
    public boolean canWithdraw(double amount) {
        if(amount > 0 && (balance - amount) >= MIN_BALANCE) {
            return true;
        } else {
            return false;
        }
    }
}
