package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.*;
import data.*;
import model.*;

public class ShowAccountInfo extends MainFrame {

    public ShowAccountInfo(Account account) {
        super("Account Information", "Account Information", 550, 600, 0, 110, 550, 30);

        //!Account Number Label and Account Number
        JLabel accNumLabel = Utils.createLabel(Utils.arrLabel[0], 90, 180, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumLabel);

        JLabel accNumInfo = Utils.createLabel(account.getAccNo(), 240, 180, 200, 28, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumInfo);

        //!Name Label and Name
        JLabel nameLabel = Utils.createLabel(Utils.arrLabel[1], 90, 220, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(nameLabel);

        JLabel nameInfo = Utils.createLabel(account.getName(), 240, 220, 200, 28, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(nameInfo);

        //!Account Type Label and Account Type
        JLabel typeLabel = Utils.createLabel(Utils.arrLabel[3], 90, 260, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(typeLabel);

        JLabel typeInfo = Utils.createLabel(account.getType(), 240, 260, 200, 28, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(typeInfo);

        //!Email Label and Email
        JLabel emailLabel = Utils.createLabel(Utils.arrLabel[4], 90, 300, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(emailLabel);

        JLabel emailInfo = Utils.createLabel(account.getEmail(), 240, 300, 200, 28, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(emailInfo);

        //!Phone Label and Phone
        JLabel phoneLabel = Utils.createLabel(Utils.arrLabel[5], 90, 340, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(phoneLabel);

        JLabel phoneInfo = Utils.createLabel(account.getPhoneNum(), 240, 340, 200, 28, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(phoneInfo);

        //!Balance Label and Balance
        JLabel balanceLabel = Utils.createLabel(Utils.arrLabel[6], 90, 380, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(balanceLabel);

        JLabel balanceInfo = Utils.createLabel(String.valueOf(account.getBalance()), 240, 380, 200, 28, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(balanceInfo);

        //!Exit Button
        JButton btnExit = Utils.createButton("Exit", 225, 450, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> {
            this.dispose();
            new Menu();
        });

        this.setVisible(true);
    }
}