package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Utils extends JFrame {
    public static final Color FRAME_BG = new Color(0x0B0B0B);
    public static final Color PANEL_BG = new Color(0x151515);
    public static final Color HEADING = new Color(0xF5C542);
    public static final Color SUBHEADING = new Color(0xB0B0B0);
    public static final Color BUTTON_BG = new Color(0xF5C542);
    public static final Color BUTTON_HOVER = new Color(0xFFD966);
    public static final Color BUTTON_PRESS = new Color(0xD4AF37);
    public static final Color TEXT = new Color(0x0B0B0B);
    public static final Color TEXTFIELD_BG = new Color(0x1E1E1E);

    //* Create Button
    public static JButton createButton(String text, int x, int y, int w, int h) {
        JButton button = new JButton(text);
        button.setBounds(x, y, w, h);
        button.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        button.setBackground(BUTTON_BG);
        button.setForeground(TEXT);

        button.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                button.setBackground(BUTTON_HOVER);
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(BUTTON_BG);
            }

            public void mousePressed(MouseEvent e) {
                button.setBackground(BUTTON_PRESS);
            }

            public void mouseReleased(MouseEvent e) {
                if (button.contains(e.getPoint()))
                    button.setBackground(BUTTON_HOVER);
                else
                    button.setBackground(BUTTON_BG);
            }
        });


        return button;
    }
}