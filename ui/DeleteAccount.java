package ui;
import java.awt.*;
import javax.swing.*;
import utils.*;

public class DeleteAccount extends MainFrame {

    public DeleteAccount() {

        super("Delete Bank Account", "Delete your Bank Account", 550, 500, false, 40, 110, 470, 30);

        MainFrame.logo(250, 40);

        //!Account Number Label and TextField
        JLabel accNumLabel = Utils.createLabel("Account Number:", 90, 200, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumLabel);

        JTextField accNumField = Utils.createTextField(240, 200, 200, 28);
        panel.add(accNumField);
        //Password Label and PasswordField
        JLabel passwordLabel = Utils.createLabel("Password:", 90, 250, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(passwordLabel);
        JPasswordField passwordField = Utils.createPasswordField(240, 250, 200, 28);
        panel.add(passwordField);

        //!Delete and Exit buttons
        JButton btnDelete = Utils.createButton("Delete", 150, 300, 100, 40);
        panel.add(btnDelete);
        JButton btnExit = Utils.createButton("Exit", 270, 300, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> this.dispose());

        btnDelete.addActionListener(e -> {
            // handle delete logic here
            Utils.showMessage(this, "Account Deleted Successfully!", "Deletion Result");
            this.dispose();
        });

        this.setVisible(true);
    }

}
