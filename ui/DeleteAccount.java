package ui;
import java.awt.*;
import javax.swing.*;
import utils.*;
import data.*;
import model.*;

public class DeleteAccount extends MainFrame {

    public DeleteAccount() {

        super("Delete Bank Account", "Delete your Bank Account", 550, 500, 0, 110, 550, 30);

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

        //!Delete and Exit buttons
        JButton btnDelete = Utils.createButton("Delete", 165, 330, 100, 40);
        panel.add(btnDelete);
        JButton btnExit = Utils.createButton("Exit", 285, 330, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> {
            this.dispose();
            new Menu();
        });

        btnDelete.addActionListener(e -> {
            String accNo = accNumField.getText();
            String pass = new String(passwordField.getPassword());

            Account accountData = AccountFileHandler.validateAccount(accNo, pass);

            if(accNo.isEmpty() || pass.isEmpty()) {
                Utils.showMessage(this, "Please enter account number and password!", "Error", 350);
                return;
            }

            boolean confirm = Utils.showConfirmDialog(this, "Are you sure you want to delete this account?", "Confirm Deletion");

            if (!confirm) {
                return;
            }

            if (accountData != null) {
                AccountFileHandler.deleteAccount(accNo);
                Utils.showMessage(this, "Account deleted successfully!", "Delete Account", 350);
                this.dispose();
                new Menu();
            } else {
                Utils.showMessage(this, "Invalid account number or password!", "Error", 350);
            }
        });

        this.setVisible(true);
    }

}
