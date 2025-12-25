package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends MainFrame {

    public Transaction() {
        super("Transaction", "Transaction Menu", 500, 500, false, 40, 105, 420, 30);

        MainFrame.logo(225, 40);

        //!Subheading
        JLabel subHeading = Utils.createLabel("Make a Transaction", 50, 150, 400, 25, JLabel.CENTER, Utils.SUBHEADING_COLOR, new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(subHeading);


        //!Buttons

        JButton btnDeposit = Utils.createButton("Deposit", 150, 200, 200, 45);
        panel.add(btnDeposit);

        JButton btnWithdraw = Utils.createButton("Withdraw", 150, 260, 200, 45);
        panel.add(btnWithdraw);

        JButton btnExit = Utils.createButton("Exit", 150, 320, 200, 45);
        panel.add(btnExit);


        btnExit.addActionListener(e -> this.dispose());

        this.setVisible(true);
    }
}
