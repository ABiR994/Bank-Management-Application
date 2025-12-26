package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.*;


public class Deposit extends MainFrame {
    public Deposit(String accountData) {
        super("Deposit", "Enter Amount to Deposit", 550, 400, false, 0, 110, 550, 30);

        //! Label and TextField
        JLabel depositLabel = Utils.createLabel("Deposit Amount :", 90, 180, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(depositLabel);

        JTextField depositField = Utils.createTextField(240, 180, 200, 28);
        panel.add(depositField);

        //! Button
        JButton btnDeposit = Utils.createButton("Deposit", 150, 250, 100, 40);
        panel.add(btnDeposit);

        JButton btnExit = Utils.createButton("Exit", 270, 250, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> this.dispose());

        btnDeposit.addActionListener(e -> {
            // handle deposit logic here
        });

        this.setVisible(true);
    }
}
