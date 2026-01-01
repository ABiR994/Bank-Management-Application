package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.*;
import data.*;
import model.*;

public class Withdraw extends MainFrame {
    public Withdraw(Account account) {
        super("Withdraw", "Enter Amount to Withdraw", 550, 400, false, 0, 110, 550, 30);

        //! Label and TextField
        JLabel withdrawLabel = Utils.createLabel("Withdraw Amount :", 90, 180, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(withdrawLabel);

        JTextField withdrawField = Utils.createTextField(240, 180, 200, 28);
        panel.add(withdrawField);

        //! Button
        JButton btnWithdraw = Utils.createButton("Withdraw", 150, 250, 100, 40);
        panel.add(btnWithdraw);

        JButton btnBack = Utils.createButton("Back", 270, 250, 100, 40);
        panel.add(btnBack);

        btnBack.addActionListener(e -> {
            this.dispose();
            new Transaction(account);
        });

        btnWithdraw.addActionListener(e -> {

            if(withdrawField.getText().isEmpty()) {
                Utils.showMessage(this, "Please enter a withdraw amount!", "Error", 350);
                return;
            }

            try {
                double amount = Double.parseDouble(withdrawField.getText());
                if(amount > 0) {
                    if(account.withdraw(amount)) {
                        AccountFileHandler.updateAccount(account);
                        Utils.updatedBalanceMessage(this, "Withdraw Successful!", "Updated Balance: " + account.getBalance(), "Success");
                        this.dispose();
                        new Transaction(account);
                    } else {
                        Utils.showMessage(this, "Insufficient balance!", "Error", 350);
                    }
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
