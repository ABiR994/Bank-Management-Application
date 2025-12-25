package ui;
import java.awt.*;
import javax.swing.*;
public class SearchAccount extends MainFrame {

    public SearchAccount() {

        super("Search Bank Account", "Search for a Bank Account", 550, 500, false, 40, 110, 470, 30);

        MainFrame.logo(250, 40);

        //!Account Number Label and TextField
        JLabel accNumLabel1 = Utils.createLabel("Account Type:", 90, 160, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumLabel1);

        //!Riadio Buttons for Account Type
        JRadioButton checkingButton = new JRadioButton("Checking");
        checkingButton.setBounds(240, 160, 100, 25);    
        checkingButton.setBackground(Utils.FRAME_BG);
        checkingButton.setForeground(Utils.SUBHEADING_COLOR);
        checkingButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(checkingButton);
        
        JRadioButton savingButton = new JRadioButton("Saving");
        savingButton.setBounds(350, 160, 100, 25);
        savingButton.setBackground(Utils.FRAME_BG);
        savingButton.setForeground(Utils.SUBHEADING_COLOR);
        savingButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(savingButton);
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savingButton);
        accountTypeGroup.add(checkingButton);

        JLabel accNumLabel2 = Utils.createLabel("Account Number:", 90, 200, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumLabel2);

        JTextField accNumField = Utils.createTextField(240, 200, 200, 28);
        panel.add(accNumField);

        //!Search and Exit buttons
        JButton btnSearch = Utils.createButton("Search", 150, 300, 100, 40);
        panel.add(btnSearch);
        JButton btnExit = Utils.createButton("Exit", 270, 300, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> this.dispose());

        btnSearch.addActionListener(e -> {
            // handle search logic here
        Utils.showMessage(this, "Account Found!", "Search Result");
        });

        this.setVisible(true);
    }
    
}
