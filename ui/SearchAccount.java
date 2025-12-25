package ui;
import java.awt.*;
import javax.swing.*;
public class SearchAccount extends MainFrame {

    public SearchAccount() {

        super("Search Bank Account", "Search for a Bank Account", 550, 400, false, 40, 110, 470, 30);

        MainFrame.logo(250, 40);

        //!Account Number Label and TextField
        JLabel accNumLabel = Utils.createLabel("Account Number:", 90, 180, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumLabel);

        JTextField accNumField = Utils.createTextField(240, 180, 200, 28);
        panel.add(accNumField);

        //!Search and Exit buttons
        JButton btnSearch = Utils.createButton("Search", 150, 250, 100, 40);
        panel.add(btnSearch);
        JButton btnExit = Utils.createButton("Exit", 270, 250, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> this.dispose());

        btnSearch.addActionListener(e -> {
            // handle search logic here
        Utils.showMessage(this, "Account Found!", "Search Result");
        });

        this.setVisible(true);
    }

}
