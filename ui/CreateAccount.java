package ui;
import java.awt.*;
import javax.swing.*;
import utils.*;
import data.*;

public class CreateAccount extends MainFrame {
    public CreateAccount() {

        super("Create New Account", "Create a New Bank Account", 550, 750, false, 40, 110, 470, 30);

        MainFrame.logo(250, 40);

        //!Name Label and TextField
        JLabel nameLabel = Utils.createLabel("Full Name:", 90, 190, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(nameLabel);

        JTextField nameField = Utils.createTextField(240, 190, 200, 28);
        panel.add(nameField);

        //!Date of Birth Label and TextField
        JLabel dobLabel = Utils.createLabel("Date of Birth:", 90, 230, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(dobLabel);

        JTextField dobField = Utils.createTextField(240, 230, 200, 28);
        dobField.setText("DD/MM/YYYY");
        panel.add(dobField);

        //!Phone Number Label and TextField
        JLabel phoneLabel = Utils.createLabel("Phone Number:", 90, 270, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(phoneLabel);

        JTextField phoneField = Utils.createTextField(240, 270, 200, 28);
        panel.add(phoneField);

        //!Email
        JLabel emailLabel = Utils.createLabel("Email Address:", 90, 310, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(emailLabel);

        JTextField emailField = Utils.createTextField(240, 310, 200, 28);
        panel.add(emailField);

        //!Acount Type
        JLabel typeLabel = Utils.createLabel("Account Type:", 90, 350, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(typeLabel);

        JRadioButton checkingButton = Utils.createRadioButton("Saving", 240, 350, 100, 25);
        panel.add(checkingButton);

        JRadioButton savingButton = Utils.createRadioButton("Checking", 350, 350, 100, 25);
        panel.add(savingButton);

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savingButton);
        accountTypeGroup.add(checkingButton);

        //!Account Number Label and TextField
        JLabel accNumLabel = Utils.createLabel("Account Number:", 90, 390, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumLabel);

        JTextField accNumField = Utils.createTextField(240, 390, 200, 28);
        panel.add(accNumField);

        //!Password Label and PasswordField
        JLabel passwordLabel = Utils.createLabel("Password:", 90, 430, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(passwordLabel);

        JPasswordField passwordField = Utils.createPasswordField(240, 430, 200, 28);
        panel.add(passwordField);

        //!Initial Deposit Label and TextField
        JLabel depositLabel = Utils.createLabel("Initial Deposit:", 90, 470, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(depositLabel);

        JTextField depositField = Utils.createTextField(240, 470, 200, 28);
        panel.add(depositField);

        //!exit and submit buttons
        JButton btnSubmit = Utils.createButton("Submit", 170, 540, 100, 40);
        panel.add(btnSubmit);
        JButton btnExit = Utils.createButton("Exit", 290, 540, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> this.dispose());

        btnSubmit.addActionListener(e -> {

            String acc = accNumField.getText();
            String name = nameField.getText();
            String pass = new String(passwordField.getPassword());
            String email = emailField.getText();
            String phone = phoneField.getText();
            double deposit = Double.parseDouble(depositField.getText());

            String type = savingButton.isSelected() ? "Saving" : "Checking";

            String record = acc + "," + name + "," + pass + "," + type + "," + email + "," + phone + "," + deposit;
            AccountFileHandler.saveAccount(record);

            Utils.showMessage(this, "Account Created Successfully!", "Success");
            this.dispose();
        });





        this.setVisible(true);


    }
}