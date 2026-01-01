package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.*;
import data.*;
import model.*;

public class Login extends MainFrame {
    public Login() {
        super("Login to your Account", "Login to your Bank Account", 550, 500, 0, 110, 550, 30);

        //!Account Number Label and TextField
        JLabel accNumLabel = Utils.createLabel(Utils.arrLabel[0], 90, 200, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumLabel);

        JTextField accNumField = Utils.createTextField(240, 200, 200, 28);
        panel.add(accNumField);

        //!Password Label and PasswordField
        JLabel passwordLabel = Utils.createLabel(Utils.arrLabel[2], 90, 250, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(passwordLabel);

        JPasswordField passwordField = Utils.createPasswordField(240, 250, 200, 28);
        panel.add(passwordField);

        //!Login and Exit buttons
        JButton btnLogin = Utils.createButton("Login", 165, 330, 100, 40);
        panel.add(btnLogin);
        JButton btnExit = Utils.createButton("Exit", 285, 330, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> {
            this.dispose();
            new Menu();
        });

        btnLogin.addActionListener(e -> {

            String accNo = accNumField.getText();
            String pass = new String(passwordField.getPassword());

            Account accountData = AccountFileHandler.validateAccount(accNo, pass);

            if(accNo.isEmpty() || pass.isEmpty()) {
                Utils.showMessage(this, "Please enter account number and password!", "Error", 350);
                return;
            }

            if (accountData != null) {
                new Transaction(accountData);
                this.dispose();
            } else {
                Utils.showMessage(this, "Invalid account number or password!", "Login Failed", 350);
            }
        });


        this.setVisible(true);
    }

}