package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.*;

public class ShowAccountInfo extends MainFrame {
    private String[] account;

    public ShowAccountInfo(String accountData) {
        super("Account Information", "Account Information", 550, 600, false, 0, 110, 550, 30);

        //! Split account data
        account = accountData.split(",");

        //!Account Number Label and Account Number
        JLabel accNumLabel = Utils.createLabel("Account Number", 90, 180, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumLabel);

        JLabel accNumInfo = Utils.createLabel(": " + account[0], 240, 180, 200, 28, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumInfo);

        //!Name Label and Name
        JLabel nameLabel = Utils.createLabel("Full Name", 90, 220, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(nameLabel);

        JLabel nameInfo = Utils.createLabel(": " + account[1], 240, 220, 200, 28, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(nameInfo);

        //!Account Type Label and Account Type
        JLabel typeLabel = Utils.createLabel("Account Type", 90, 260, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(typeLabel);

        JLabel typeInfo = Utils.createLabel(": " + account[3], 240, 260, 200, 28, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(typeInfo);

        //!Email Label and Email
        JLabel emailLabel = Utils.createLabel("Email Address", 90, 300, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(emailLabel);

        JLabel emailInfo = Utils.createLabel(": " + account[4], 240, 300, 200, 28, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(emailInfo);

        //!Phone Label and Phone
        JLabel phoneLabel = Utils.createLabel("Phone Number", 90, 340, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(phoneLabel);

        JLabel phoneInfo = Utils.createLabel(": " + account[5], 240, 340, 200, 28, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(phoneInfo);

        //!Balance Label and Balance
        JLabel balanceLabel = Utils.createLabel("Balance", 90, 380, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(balanceLabel);

        JLabel balanceInfo = Utils.createLabel(": " + account[6], 240, 380, 200, 28, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(balanceInfo);

        //!Exit Button
        JButton btnExit = Utils.createButton("Exit", 225, 450, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> this.dispose());

        this.setVisible(true);
    }
}