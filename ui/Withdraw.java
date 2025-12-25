package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.*;

public class Withdraw extends MainFrame {
    public Withdraw(String accountData) {
        super("Withdraw", "Enter Amount to Withdraw", 550, 400, false, 40, 110, 470, 30);
        MainFrame.logo(250, 40);

        //! Label and TextField
        JLabel withdrawLabel = Utils.createLabel("Withdraw Amount:", 90, 180, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(withdrawLabel);

        JTextField withdrawField = Utils.createTextField(240, 180, 200, 28);
        panel.add(withdrawField);

        //! Button
        JButton btnWithdraw = Utils.createButton("Withdraw", 150, 250, 100, 40);
        panel.add(btnWithdraw);

        JButton btnExit = Utils.createButton("Exit", 270, 250, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> this.dispose());

        btnWithdraw.addActionListener(e -> {
            // handle withdraw logic here
        });

        this.setVisible(true);
    }
}
