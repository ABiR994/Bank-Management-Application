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
        panel.setBackground(new Color(0x0B0B0B));
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
        heading.setForeground(new Color(0xF5C542));
        heading.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(heading);

        //!Subheading
        JLabel subHeading = new JLabel("Your Trusted Financial Partner");
        subHeading.setBounds(40, 140, 420, 25);
        subHeading.setHorizontalAlignment(JLabel.CENTER);
        subHeading.setForeground(new Color(0xB0B0B0));
        subHeading.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(subHeading);

        //!Buttons

        JButton btnCreate = createButton("Create Account", 150, 220, 200, 45);
        panel.add(btnCreate);
        JButton btnLogin = createButton("Login", 150, 220 + 60, 200, 45);
        panel.add(btnLogin);
        JButton btnSearch = createButton("Search Account", 150, 220 + 120, 200, 45);
        panel.add(btnSearch);
        JButton btnShow = createButton("Display All Accounts", 150, 220 + 180, 200, 45);
        panel.add(btnShow);
        JButton btnExit = createButton("Exit", 150, 220 + 240, 200, 45);
        panel.add(btnExit);

        this.setVisible(true);
    }


    //* Create Button
    public JButton createButton(String text, int x, int y, int w, int h) {
        JButton button = new JButton(text);
        button.setBounds(x, y, w, h);
        button.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);


        Color normalBg = new Color(0xF5C542);
        Color hoverBg  = new Color(0xFFD966);
        Color pressBg  = new Color(0xD4AF37);
        Color textCol  = new Color(0x0B0B0B);


        button.setBackground(normalBg);
        button.setForeground(textCol);

        button.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverBg);
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(normalBg);
            }

            public void mousePressed(MouseEvent e) {
                button.setBackground(pressBg);
            }

            public void mouseReleased(MouseEvent e) {
                if (button.contains(e.getPoint()))
                    button.setBackground(hoverBg);
                else
                    button.setBackground(normalBg);
            }
        });


        return button;
    }
}