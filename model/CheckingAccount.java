package model;

public class CheckingAccount extends Account {

    private static final double OVERDRAFT_LIMIT = -1000;

    public CheckingAccount(String acc, String name, String pass, String email, String phoneNum,double balance) {
        super(acc, name, pass, email, phoneNum, balance);
    }

    @Override
    public String getType() {
        return "Checking";
    }

    @Override
    public boolean canWithdraw(double amount) {
        if(amount > 0 && (balance - amount) >= OVERDRAFT_LIMIT) {
            return true;
        } else {
            return false;
        }
    }
}
