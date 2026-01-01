package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.*;
import data.*;
import model.*;


public class Deposit extends MainFrame {
    public Deposit(Account account) {
        super("Deposit", "Enter Amount to Deposit", 550, 400, false, 0, 110, 550, 30);

        //! Label and TextField
        JLabel depositLabel = Utils.createLabel("Deposit Amount :", 90, 180, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(depositLabel);

        JTextField depositField = Utils.createTextField(240, 180, 200, 28);
        panel.add(depositField);

        //! Button
        JButton btnDeposit = Utils.createButton("Deposit", 150, 250, 100, 40);
        panel.add(btnDeposit);

        JButton btnBack = Utils.createButton("Back", 270, 250, 100, 40);
        panel.add(btnBack);

        btnBack.addActionListener(e -> {
            this.dispose();
            new Transaction(account);
        });

        btnDeposit.addActionListener(e -> {
            if(depositField.getText().isEmpty()) {
                Utils.showMessage(this, "Please enter a deposit amount!", "Error", 350);
                return;
            }

            try {
                double amount = Double.parseDouble(depositField.getText());
                if(amount > 0) {
                    account.deposit(amount);
                    AccountFileHandler.updateAccount(account);
                    Utils.updatedBalanceMessage(this, "Deposit Successful!", "Updated Balance: " + account.getBalance(), "Success");
                    this.dispose();
                    new Transaction(account);
                } else {
                    Utils.showMessage(this, "Invalid amount!", "Error", 350);
                }
            } catch(NumberFormatException ex) {
                Utils.showMessage(this, "Enter a valid number!", "Error", 350);
            }
        });

        this.setVisible(true);
    }
}
