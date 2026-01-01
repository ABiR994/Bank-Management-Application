package ui;
import java.awt.*;
import javax.swing.*;
import utils.*;
import data.*;

public class SearchAccount extends MainFrame {

    public SearchAccount() {

        super("Search Bank Account", "Search for a Bank Account", 550, 400, false, 0, 110, 550, 30);

        //!Account Number Label and TextField
        JLabel accNumLabel = Utils.createLabel(Utils.arrLabel[0], 90, 180, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumLabel);

        JTextField accNumField = Utils.createTextField(240, 180, 200, 28);
        panel.add(accNumField);

        //!Search and Exit buttons
        JButton btnSearch = Utils.createButton("Search", 165, 250, 100, 40);
        panel.add(btnSearch);

        JButton btnExit = Utils.createButton("Exit", 285, 250, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> this.dispose());

        btnSearch.addActionListener(e -> {
            String accNo = accNumField.getText();
            Account accountData = AccountFileHandler.findAccount(accNo);

            if(accNo.isEmpty()) {
                Utils.showMessage(this, "Please enter account number to search!", "Error", 350);
                return;
            }

            if (accountData != null) {
                this.dispose();
                new ShowAccountInfo(accountData);
            } else {
                Utils.showMessage(this, "Account not found!", "Search Result", 350);
            }
        });

        this.setVisible(true);
    }

}
