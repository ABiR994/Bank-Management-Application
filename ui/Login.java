package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.*;
import data.*;

public class Login extends MainFrame {
    public Login() {
        super("Login to your Account", "Login to your Bank Account", 550, 500, false, 40, 110, 470, 30);

        MainFrame.logo(250, 40);

        //!Account Number Label and TextField
        JLabel accNumLabel = Utils.createLabel("Account Number:", 90, 200, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumLabel);

        JTextField accNumField = Utils.createTextField(240, 200, 200, 28);
        panel.add(accNumField);

        //!Password Label and PasswordField
        JLabel passwordLabel = Utils.createLabel("Password:", 90, 250, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(passwordLabel);

        JPasswordField passwordField = Utils.createPasswordField(240, 250, 200, 28);
        panel.add(passwordField);

        //!Login and Exit buttons
        JButton btnLogin = Utils.createButton("Login", 150, 330, 100, 40);
        panel.add(btnLogin);
        JButton btnExit = Utils.createButton("Exit", 270, 330, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> this.dispose());

        btnLogin.addActionListener(e -> {

            String accNo = accNumField.getText();
            String pass = new String(passwordField.getPassword());

            String accountData = AccountFileHandler.findAccount(accNo, pass);

            if (accountData != null) {
                new Transaction(accountData);
                this.dispose();
            } else {
                Utils.showMessage(this, "Invalid account number or password!", "Login Failed");
            }
        });


        this.setVisible(true);
    }

}