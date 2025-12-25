package model;

public class CheckingAccount extends Account {
    public CheckingAccount(String acc, String name, String pass, String email, String phoneNum,double balance) {
        super(acc, name, pass, email, phoneNum, balance);
    }

    @Override
    public String getType() {
        return "Checking";
    }
}
