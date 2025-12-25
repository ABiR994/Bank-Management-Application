package ui;
import java.awt.*;
import javax.swing.*;

public class CreateAccount extends JFrame {
    public CreateAccount() {

        //!Frame Settings
        this.setTitle("Create New Account");
        this.setLayout(null);
        this.setSize(500, 750);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //!Application Icon
        ImageIcon icon = new ImageIcon("assets/logo(60x60).png");
        this.setIconImage(icon.getImage());

        //!Panel
        JPanel panel = new JPanel(null);    
        panel.setBackground(Utils.FRAME_BG);
        this.setContentPane(panel);
        
        //!Logo
        ImageIcon logo = new ImageIcon("assets/logo(50x50).png");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(225, 40, 50, 50);   
        panel.add(logoLabel);   

        //!Heading
        JLabel heading = new JLabel("Welcome! Let's Get Started");
        heading.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        heading.setBounds(100, 100, 300, 40);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setForeground(Utils.HEADING);   
        panel.add(heading); 

        //!Subheading
        JLabel subHeading = new JLabel("Create an account to access our services.");
        subHeading.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        subHeading.setBounds(120, 140, 260, 25);
        subHeading.setHorizontalAlignment(JLabel.CENTER);
        subHeading.setForeground(Utils.SUBHEADING);
        panel.add(subHeading);

        //!text fields and labels for account creation
        JLabel nameLabel = new JLabel("Full Name:");   
        nameLabel.setBounds(100, 200, 100, 25);
        nameLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        nameLabel.setForeground(Utils.SUBHEADING);
        nameLabel.setHorizontalAlignment(JLabel.RIGHT);
        nameLabel.setVerticalAlignment(JLabel.CENTER);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 200, 200, 25);
        nameField.setBackground(Utils.TEXTFIELD_BG);
        nameField.setForeground(Utils.TEXT);
        nameField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        nameField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        nameField.setCaretColor(Utils.TEXT);
        panel.add(nameField); 

        //!Date of Birth
        JLabel dobLabel = new JLabel("Date of Birth:"); 
        dobLabel.setBounds(100, 240, 100, 25);
        dobLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));    
        dobLabel.setForeground(Utils.SUBHEADING);
        dobLabel.setHorizontalAlignment(JLabel.RIGHT);  
        dobLabel.setVerticalAlignment(JLabel.CENTER);
        panel.add(dobLabel);
        JTextField dobField = new JTextField();
        dobField.setBounds(200, 240, 200, 25);  
        dobField.setBackground(Utils.TEXTFIELD_BG);
        dobField.setForeground(Utils.TEXT);
        dobField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        dobField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        dobField.setCaretColor(Utils.TEXT);
        panel.add(dobField);

        //!Phone Number
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(100, 280, 100, 25);
        phoneLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        phoneLabel.setForeground(Utils.SUBHEADING);
        phoneLabel.setHorizontalAlignment(JLabel.RIGHT);
        phoneLabel.setVerticalAlignment(JLabel.CENTER);
        panel.add(phoneLabel);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(210, 280, 200, 25);
        phoneField.setBackground(Utils.TEXTFIELD_BG);
        phoneField.setForeground(Utils.TEXT);
        phoneField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        phoneField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        phoneField.setCaretColor(Utils.TEXT);
        panel.add(phoneField);

        //!Email
        JLabel emailLabel = new JLabel("Email Address:");   
        emailLabel.setBounds(100, 320, 100, 25);
        emailLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        emailLabel.setForeground(Utils.SUBHEADING);
        emailLabel.setHorizontalAlignment(JLabel.RIGHT);
        emailLabel.setVerticalAlignment(JLabel.CENTER);
        panel.add(emailLabel);
        JTextField emailField = new JTextField();
        emailField.setBounds(200, 320, 200, 25);
        emailField.setBackground(Utils.TEXTFIELD_BG);
        emailField.setForeground(Utils.TEXT);
        emailField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        emailField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        emailField.setCaretColor(Utils.TEXT);
        panel.add(emailField);

        //!Acount Type
        JLabel typeLabel = new JLabel("Account Type:"); 
        typeLabel.setBounds(100, 360, 100, 25);
        typeLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        typeLabel.setForeground(Utils.SUBHEADING);
        typeLabel.setHorizontalAlignment(JLabel.RIGHT);
        typeLabel.setVerticalAlignment(JLabel.CENTER);
        panel.add(typeLabel);

        JRadioButton checkingButton = new JRadioButton("Checking");
        checkingButton.setBounds(200, 360, 100, 25);
        checkingButton.setBackground(Utils.FRAME_BG);
        checkingButton.setForeground(Utils.SUBHEADING);
        checkingButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(checkingButton);
        JRadioButton savingButton = new JRadioButton("Saving");
        savingButton.setBounds(300, 360, 100, 25);
        savingButton.setBackground(Utils.FRAME_BG);
        savingButton.setForeground(Utils.SUBHEADING);
        savingButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(savingButton);
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savingButton);
        accountTypeGroup.add(checkingButton);
    
        //!Initial Deposit
        JLabel depositLabel = new JLabel("Initial Deposit:");       
        depositLabel.setBounds(100, 400, 100, 25);
        depositLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        depositLabel.setForeground(Utils.SUBHEADING);
        depositLabel.setHorizontalAlignment(JLabel.RIGHT);
        depositLabel.setVerticalAlignment(JLabel.CENTER);
        panel.add(depositLabel);
        JTextField depositField = new JTextField();
        depositField.setBounds(200, 400, 200, 25);
        depositField.setBackground(Utils.TEXTFIELD_BG); 
        depositField.setForeground(Utils.TEXT);
        depositField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        depositField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        depositField.setCaretColor(Utils.TEXT);
        panel.add(depositField);

        //!Account Number
        JLabel accNumLabel = new JLabel("Account Number:");     
        accNumLabel.setBounds(100, 440, 100, 25);
        accNumLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        accNumLabel.setForeground(Utils.SUBHEADING);
        accNumLabel.setHorizontalAlignment(JLabel.RIGHT);
        accNumLabel.setVerticalAlignment(JLabel.CENTER);
        panel.add(accNumLabel);
        JTextField accNumField = new JTextField();
        accNumField.setBounds(200, 440, 200, 25);
        accNumField.setBackground(Utils.TEXTFIELD_BG);
        accNumField.setForeground(Utils.TEXT);
        accNumField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        accNumField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        accNumField.setCaretColor(Utils.TEXT);
        panel.add(accNumField);

        //!Password
        JLabel passwordLabel = new JLabel("Password:");     
        passwordLabel.setBounds(100, 480, 100, 25);
        passwordLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        passwordLabel.setForeground(Utils.SUBHEADING);
        passwordLabel.setHorizontalAlignment(JLabel.RIGHT);
        passwordLabel.setVerticalAlignment(JLabel.CENTER);
        panel.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 480, 200, 25);
        passwordField.setBackground(Utils.TEXTFIELD_BG);
        passwordField.setForeground(Utils.TEXT);
        passwordField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        passwordField.setCaretColor(Utils.TEXT);
        panel.add(passwordField);

        //!exit and submit buttons
        JButton btnSubmit = Utils.createButton("Submit", 150, 530, 100, 40);
        panel.add(btnSubmit);   
        JButton btnExit = Utils.createButton("Exit", 260, 530, 100, 40);
        panel.add(btnExit); 
        btnExit.addActionListener(e -> this.dispose());
        btnSubmit.addActionListener(e -> {
            //handle account creation logic here

            JOptionPane.showMessageDialog(this, "Account Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }); 



    this.setVisible(true);


    }  
}
