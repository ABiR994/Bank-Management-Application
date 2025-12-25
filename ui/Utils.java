package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Utils {
    //* Colors
    public static final Color FRAME_BG = new Color(0x0B0B0B);
    public static final Color PANEL_BG = new Color(0x151515);
    public static final Color HEADING_COLOR = new Color(0xF5C542);
    public static final Color SUBHEADING_COLOR = new Color(0xB0B0B0);
    public static final Color BUTTON_BG = new Color(0xF5C542);
    public static final Color BUTTON_HOVER = new Color(0xFFD966);
    public static final Color BUTTON_PRESS = new Color(0xD4AF37);
    public static final Color TEXT_COLOR = new Color(0x0B0B0B);
    public static final Color TEXTFIELD_BG = new Color(0x1E1E1E);
    public static final Color TEXTFIELD_FG = new Color(0xFFFFFF);

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
        button.setForeground(TEXT_COLOR);

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


    //*Create Label
    public static JLabel createLabel(String text, int x, int y, int w, int h, int horizontalAlignment, Color color, Font font) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, w, h);
        label.setHorizontalAlignment(horizontalAlignment);
        label.setForeground(color);
        label.setFont(font);
        return label;
    }

    //* Create TextField
    public static JTextField createTextField(int x, int y, int w, int h) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, w, h);
        textField.setBackground(Utils.TEXTFIELD_BG);
        textField.setForeground(Utils.TEXTFIELD_FG);
        textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textField.setCaretColor(Utils.SUBHEADING_COLOR);
        return textField;
    }
}