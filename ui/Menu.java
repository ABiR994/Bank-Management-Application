package ui;
import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    public Menu() {
        this.setTitle("Bank Management Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 750);
        this.setResizable(false);
        this.setLocation(450, 50);
        this.setVisible(true);

        ImageIcon icon = new ImageIcon("assets/logo.png");
        this.setIconImage(icon.getImage());

        this.getContentPane().setBackground(new Color(0x121212));
    }
}