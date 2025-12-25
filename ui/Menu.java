package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {

    public Menu() {

        //!Frame Settings
        this.setTitle("Bank Management Application");
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
        JLabel heading = new JLabel("Welcome to the Bank Management Application");
        heading.setBounds(40, 105, 420, 30);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setForeground(Utils.HEADING);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(heading);

        //!Subheading
        JLabel subHeading = new JLabel("Your Trusted Financial Partner");
        subHeading.setBounds(40, 140, 420, 25);
        subHeading.setHorizontalAlignment(JLabel.CENTER);
        subHeading.setForeground(Utils.SUBHEADING);
        subHeading.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(subHeading);

        //!Buttons

        JButton btnCreate = Utils.createButton("Create Account", 150, 220, 200, 45);
        panel.add(btnCreate);
        JButton btnLogin = Utils.createButton("Login", 150, 220 + 60, 200, 45);
        panel.add(btnLogin);
        JButton btnSearch = Utils.createButton("Search Account", 150, 220 + 120, 200, 45);
        panel.add(btnSearch);
        JButton btnShow = Utils.createButton("Display All Accounts", 150, 220 + 180, 200, 45);
        panel.add(btnShow);
        JButton btnExit = Utils.createButton("Exit", 150, 220 + 240, 200, 45);
        panel.add(btnExit);

        this.setVisible(true);
    }
}