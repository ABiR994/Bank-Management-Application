package ui;
import javax.swing.*;
import java.awt.*;
import utils.*;
import data.*;
import model.*;

public class Transaction extends MainFrame {

    public Transaction(Account accountData) {
        super("Transaction", "Transaction Menu", 500, 500, false, 0, 105, 500, 30);

        //! Welcome message and account balance
        JLabel info = Utils.createLabel("Welcome " + accountData.getName() + " | Balance: " + accountData.getBalance(), 50, 150, 400, 25, JLabel.CENTER, Utils.SUBHEADING_COLOR, new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(info);

        //! Buttons
        JButton btnDeposit = Utils.createButton("Deposit", 150, 200, 200, 45);
        panel.add(btnDeposit);

        JButton btnWithdraw = Utils.createButton("Withdraw", 150, 260, 200, 45);
        panel.add(btnWithdraw);

        JButton btnLogout = Utils.createButton("Logout", 150, 320, 200, 45);
        panel.add(btnLogout);

        btnLogout.addActionListener(e -> {
            this.dispose();
            new Menu();
        });

        btnDeposit.addActionListener(e -> {
            new Deposit(accountData);
            this.dispose();
        });

        btnWithdraw.addActionListener(e -> {
            new Withdraw(accountData);
            this.dispose();
        });

        this.setVisible(true);
    }
}
