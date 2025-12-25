package account;

public class SavingsAccount extends Account {
    public SavingsAccount(String acc, String name, String pass, String email, String phoneNum,double balance) {
        super(acc, name, pass, email, phoneNum, balance);
    }

    @Override
    public String getType() {
        return "Savings";
    }
}
