package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.*;

public class MainFrame extends JFrame {

    protected static JPanel panel;
    protected static JLabel logoLabel;

    public MainFrame(String title, String headingText, int frameWidth, int frameHeight, boolean exit, int h_x, int h_y, int h_width, int h_height) {

        //! Frame settings
        this.setTitle(title);
        this.setSize(frameWidth, frameHeight);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(exit ? JFrame.EXIT_ON_CLOSE : JFrame.DISPOSE_ON_CLOSE);

        //! Icon
        ImageIcon icon = new ImageIcon("assets/logo(60x60).png");
        this.setIconImage(icon.getImage());

        //! Panel
        panel = new JPanel(null);
        panel.setBackground(Utils.FRAME_BG);
        this.setContentPane(panel);

        //! Heading
        JLabel heading = Utils.createLabel(headingText, h_x, h_y, h_width, h_height, JLabel.CENTER, Utils.HEADING_COLOR, new Font("Segoe UI", Font.BOLD, 18));
        panel.add(heading);

        //! Logo
        ImageIcon logo = new ImageIcon("assets/logo(50x50).png");
        logoLabel = new JLabel(logo);
        logoLabel.setBounds(Utils.centerLogo(frameWidth, 50), 40, 50, 50);
        panel.add(logoLabel);
    }
}
