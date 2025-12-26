package ui;
import java.awt.*;
import javax.swing.*;
import utils.*;

public class ShowAccounts extends MainFrame {
    public ShowAccounts() {
        super("All Bank Accounts", "Displaying All Bank Accounts", 550, 500, false, 0, 110, 550, 30);

        JLabel infoLabel = Utils.createLabel("List of all bank accounts will be displayed here.", 90, 200, 350, 25, JLabel.CENTER, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(infoLabel);

        //!Exit button
        JButton btnExit = Utils.createButton("Exit", 225, 300, 100, 40);
        panel.add(btnExit);


        btnExit.addActionListener(e -> this.dispose());
        this.setVisible(true);
    }
}