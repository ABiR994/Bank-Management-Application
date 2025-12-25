package ui;
import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    public Menu() {

        //!Frame Settings
        this.setTitle("Bank Management Application");
        this.setLayout(null);
        this.setSize(500, 750);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //!App Icon
        ImageIcon icon = new ImageIcon("assets/logo(60x60).png");
        this.setIconImage(appIcon.getImage());

        //!Panel
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(0x121212));
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
        heading.setForeground(new Color(0xEDEDED));
        heading.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
        panel.add(heading);

        //!Subheading
        JLabel subHeading = new JLabel("Your Trusted Financial Partner");
        subHeading.setBounds(40, 140, 420, 25);
        subHeading.setHorizontalAlignment(JLabel.CENTER);
        subHeading.setForeground(new Color(0xB3B3B3));
        subHeading.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(subHeading);

        this.setVisible(true);
    }
}