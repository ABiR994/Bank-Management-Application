package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import utils.*;
import data.*;
import model.*;

public class CreateAccount extends MainFrame {
    public CreateAccount() {

        super("Create New Account", "Create a New Bank Account", 550, 750, false, 0, 110, 550, 30);

        //!Name Label and TextField
        JLabel nameLabel = Utils.createLabel(Utils.arrLabel[1], 90, 190, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(nameLabel);

        JTextField nameField = Utils.createTextField(240, 190, 200, 28);
        panel.add(nameField);

        //!Date of Birth Label and TextField
        JLabel dobLabel = Utils.createLabel(Utils.arrLabel[8], 90, 230, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(dobLabel);

        JTextField dobField = Utils.createTextField(240, 230, 200, 28);
        dobField.setText("DD/MM/YYYY");
        dobField.setForeground(Color.GRAY);

        //! Add focus listener
        dobField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (dobField.getText().equals("DD/MM/YYYY")) {
                    dobField.setText("");
                    dobField.setForeground(Utils.TEXTFIELD_FG);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (dobField.getText().isEmpty()) {
                    dobField.setText("DD/MM/YYYY");
                    dobField.setForeground(Color.GRAY);
                }
            }
        });

        panel.add(dobField);

        //!Email Label and TextField
        JLabel emailLabel = Utils.createLabel(Utils.arrLabel[4], 90, 270, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(emailLabel);

        JTextField emailField = Utils.createTextField(240, 270, 200, 28);
        panel.add(emailField);

        //!Phone Number Label and TextField
        JLabel phoneLabel = Utils.createLabel(Utils.arrLabel[5], 90, 310, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(phoneLabel);

        JTextField phoneField = Utils.createTextField(240, 310, 200, 28);
        panel.add(phoneField);

        //!Acount Type Label and RadioButton
        JLabel typeLabel = Utils.createLabel(Utils.arrLabel[3], 90, 350, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(typeLabel);

        JRadioButton savingsButton = Utils.createRadioButton("Savings", 240, 350, 100, 25);
        panel.add(savingsButton);

        JRadioButton checkingButton = Utils.createRadioButton("Checking", 350, 350, 100, 25);
        panel.add(checkingButton);

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savingsButton);
        accountTypeGroup.add(checkingButton);

        //!Account Number Label and TextField
        JLabel accNumLabel = Utils.createLabel(Utils.arrLabel[0], 90, 390, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(accNumLabel);

        JTextField accNumField = Utils.createTextField(240, 390, 200, 28);
        panel.add(accNumField);

        //!Password Label and PasswordField
        JLabel passwordLabel = Utils.createLabel(Utils.arrLabel[2], 90, 430, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(passwordLabel);

        JPasswordField passwordField = Utils.createPasswordField(240, 430, 200, 28);
        panel.add(passwordField);

        //!Initial Deposit Label and TextField
        JLabel depositLabel = Utils.createLabel(Utils.arrLabel[7], 90, 470, 140, 25, JLabel.LEFT, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(depositLabel);

        JTextField depositField = Utils.createTextField(240, 470, 200, 28);
        panel.add(depositField);

        //!exit and submit buttons
        JButton btnSubmit = Utils.createButton("Submit", 170, 540, 100, 40);
        panel.add(btnSubmit);
        JButton btnExit = Utils.createButton("Exit", 290, 540, 100, 40);
        panel.add(btnExit);

        btnExit.addActionListener(e -> {
            this.dispose();
            new Menu();
        });

        btnSubmit.addActionListener(e -> {

            String acc = accNumField.getText();
            String name = nameField.getText();
            String pass = new String(passwordField.getPassword());
            String email = emailField.getText();
            String phone = phoneField.getText();
            String dob = dobField.getText();
            double deposit;
            String type;

            //? Validations

            //! Check if any field is empty
            if (acc.isEmpty() || name.isEmpty() || pass.isEmpty() || email.isEmpty() || phone.isEmpty() || dob.isEmpty() ||dob.equals("DD/MM/YYYY") || depositField.getText().isEmpty()) {
                Utils.showMessage(this, "Please fill all the required fields.", "Incomplete Form", 350);
                return;
            }

            //! Check if account number already exists
            if (AccountFileHandler.findAccount(acc) != null) {
                Utils.showMessage(this, "Account number already exists.", "Duplicate Account", 350);
                return;
            }

            //! Check if password is at least 8 characters long
            if(pass.length() < 8) {
                Utils.showMessage(this, "Password must be at least 8 characters long.", "Weak Password", 350);
                return;
            }

            //! Check if phone number is valid
            if(!phone.matches("\\d+")) {
                Utils.showMessage(this, "Phone Enter a valid phone number.", "Invalid Phone Number", 350);
                return;
            }

            //! Check if phone number is 11 digits long
            if(phone.length() != 11) {
                Utils.showMessage(this, "Phone number must be 11 digits long.", "Invalid Phone Number", 350);
                return;
            }

            //! Check if date of birth is valid
            if(!dob.matches("\\d{2}/\\d{2}/\\d{4}")) {
                Utils.showMessage(this, "Please enter a valid date of birth (DD/MM/YYYY).", "Invalid Date", 400);
                return;
            }

            //! Convert initial deposit to double
            try {
                deposit = Double.parseDouble(depositField.getText());
            } catch (NumberFormatException ex) {
                Utils.showMessage(this, "Please enter a valid amount for Initial Deposit.", "Invalid Input", 370);
                return;
            }

            //! Check if initial deposit is at least 1000
            if(deposit < 1000) {
                Utils.showMessage(this, "Initial Deposit must be at least 1000.", "Invalid Input", 350);
                return;
            }

            //! Check if account type is selected
            if (savingsButton.isSelected()) {
                type = "Savings";
            } else if (checkingButton.isSelected()) {
                type = "Checking";
            } else {
                Utils.showMessage(this, "Please select an account type.", "Input Required", 350);
                return;
            }

            //! Save account to file
            Account account;

            if (type.equals("Savings")) {
                account = new SavingsAccount(acc, name, pass, email, phone, deposit);
            } else {
                account = new CheckingAccount(acc, name, pass, email, phone, deposit);
            }

            AccountFileHandler.saveAccount(account);

            Utils.showMessage(this, "Account Created Successfully!", "Success", 350);
            this.dispose();
        });





        this.setVisible(true);


    }
}