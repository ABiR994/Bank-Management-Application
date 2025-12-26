package ui;
import java.awt.*;
import javax.swing.*;
import utils.*;
import data.*;

public class CreateAccount extends MainFrame {
    public CreateAccount() {

        super("Create New Account", "Create a New Bank Account", 550, 750, false, 0, 110, 550, 30);

        //!Name Label and TextField
        JLabel nameLabel = Utils.createLabel("Full Name", 90, 190, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(nameLabel);

        JLabel nameColon = Utils.createColonLabel(220, 190, 20, 28);
        panel.add(nameColon);

        JTextField nameField = Utils.createTextField(240, 190, 200, 28);
        panel.add(nameField);

        //!Date of Birth Label and TextField
        JLabel dobLabel = Utils.createLabel("Date of Birth", 90, 230, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(dobLabel);

        JLabel dobColon = Utils.createColonLabel(220, 230, 20, 28);
        panel.add(dobColon);

        JTextField dobField = Utils.createTextField(240, 230, 200, 28);
        dobField.setText("DD/MM/YYYY");
        panel.add(dobField);

        //!Phone Number Label and TextField
        JLabel phoneLabel = Utils.createLabel("Phone Number", 90, 270, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(phoneLabel);

        JLabel phoneColon = Utils.createColonLabel(220, 270, 20, 28);
        panel.add(phoneColon);

        JTextField phoneField = Utils.createTextField(240, 270, 200, 28);
        panel.add(phoneField);

        //!Email
        JLabel emailLabel = Utils.createLabel("Email Address", 90, 310, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(emailLabel);

        JLabel emailColon = Utils.createColonLabel(220, 310, 20, 28);
        panel.add(emailColon);

        JTextField emailField = Utils.createTextField(240, 310, 200, 28);
        panel.add(emailField);

        //!Acount Type
        JLabel typeLabel = Utils.createLabel("Account Type", 90, 350, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(typeLabel);

        JLabel typeColon = Utils.createColonLabel(220, 350, 20, 28);
        panel.add(typeColon);

        JRadioButton checkingButton = Utils.createRadioButton("Savings", 240, 350, 100, 25);
        panel.add(checkingButton);

        JRadioButton savingsButton = Utils.createRadioButton("Checking", 350, 350, 100, 25);
        panel.add(savingsButton);

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savingsButton);
        accountTypeGroup.add(checkingButton);

        //!Account Number Label and TextField
        JLabel accNumLabel = Utils.createLabel("Account Number", 90, 390, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumLabel);

        JLabel accNumColon = Utils.createColonLabel(220, 390, 20, 28);
        panel.add(accNumColon);

        JTextField accNumField = Utils.createTextField(240, 390, 200, 28);
        panel.add(accNumField);

        //!Password Label and PasswordField
        JLabel passwordLabel = Utils.createLabel("Password", 90, 430, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(passwordLabel);

        JLabel passwordColon = Utils.createColonLabel(220, 430, 20, 28);
        panel.add(passwordColon);

        JPasswordField passwordField = Utils.createPasswordField(240, 430, 200, 28);
        panel.add(passwordField);

        //!Initial Deposit Label and TextField
        JLabel depositLabel = Utils.createLabel("Initial Deposit", 90, 470, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(depositLabel);

        JLabel depositColon = Utils.createColonLabel(220, 470, 20, 28);
        panel.add(depositColon);

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

            String type = savingsButton.isSelected() ? "Savings" : "Checking";

            String record = acc + "," + name + "," + pass + "," + type + "," + email + "," + phone + "," + deposit;
            AccountFileHandler.saveAccount(record);

            Utils.showMessage(this, "Account Created Successfully!", "Success");
            this.dispose();
        });





        this.setVisible(true);


    }
}