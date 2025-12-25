package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.*;

public class MainFrame extends JFrame {

    protected static JPanel panel;
    protected static JLabel label;

    public MainFrame(String title, String headingText, int f_width, int f_height, boolean exit, int h_x, int h_y, int h_width, int h_height) {
        //!Frame Settings
        this.setTitle(title);
        this.setLayout(null);
        this.setSize(f_width, f_height);
        this.setResizable(false);
        if (exit == true) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        this.setLocationRelativeTo(null);

        //!Application Icon
        ImageIcon icon = new ImageIcon("assets/logo(60x60).png");
        this.setIconImage(icon.getImage());

        //!Panel
        panel = new JPanel(null);
        panel.setBackground(Utils.FRAME_BG);
        this.setContentPane(panel);

        //!Heading
        JLabel heading = Utils.createLabel(headingText, h_x, h_y, h_width, h_height, JLabel.CENTER, Utils.HEADING_COLOR, new Font("Segoe UI", Font.BOLD, 18));
        panel.add(heading);
    }

    //!Logo
    public static void logo(int l_x, int l_y) {
        ImageIcon logo = new ImageIcon("assets/logo(50x50).png");
        label = new JLabel(logo);
        label.setBounds(l_x, l_y, 50, 50);
        panel.add(label);
    }
}