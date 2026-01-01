package utils;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;
import data.*;

public class Utils {
    //* Colors
    public static final Color FRAME_BG = new Color(0x0B0B0B);
    public static final Color PANEL_BG = new Color(0x171717);
    public static final Color HEADING_COLOR = new Color(0xF5C542);
    public static final Color SUBHEADING_COLOR = new Color(0xB8B8B8);
    public static final Color BUTTON_BG    = new Color(0xF5C542);
    public static final Color BUTTON_HOVER = new Color(0xFFD966);
    public static final Color BUTTON_PRESS = new Color(0xD4AF37);
    public static final Color TEXT_COLOR    = new Color(0x0B0B0B);
    public static final Color TEXTFIELD_BG  = new Color(0x1F1F1F);
    public static final Color TEXTFIELD_FG  = new Color(0xFFFFFF);
    public static final Color BORDER_COLOR = new Color(0x2A2A2A);

    public static String[] arrLabel = {"Account Number :", "Full Name             :", "Password              :", "Account Type       :", "Email Address      :", "Phone Number    :", "Balance                 :", "Initial Deposit      :", "Date of Birth        :"};

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


    //* Create Label
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

    //* Create PasswordField
    public static JPasswordField createPasswordField(int x, int y, int w, int h) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(x, y, w, h);
        passwordField.setBackground(Utils.TEXTFIELD_BG);
        passwordField.setForeground(Utils.TEXTFIELD_FG);
        passwordField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        passwordField.setCaretColor(Utils.SUBHEADING_COLOR);
        return passwordField;
    }

    //* Create RadioButton
    public static JRadioButton createRadioButton(String text, int x, int y, int w, int h) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, w, h);
        radioButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        radioButton.setBackground(Utils.FRAME_BG);
        radioButton.setForeground(Utils.SUBHEADING_COLOR);
        radioButton.setFocusPainted(false);
        radioButton.setBorderPainted(false);
        radioButton.setContentAreaFilled(false);
        radioButton.setOpaque(true);
        return radioButton;
    }

    //* Show Message
    public static void showMessage(JFrame frame, String message, String title, int width) {

        JDialog dialog = new JDialog(frame, title, true);
        dialog.setSize(width, 150);
        dialog.setLayout(new BorderLayout());
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(frame);

        //! Panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Utils.FRAME_BG);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //! Message
        JLabel label = Utils.createLabel(message, 0, 0, 0, 0, JLabel.CENTER, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 14));
        panel.add(label, BorderLayout.CENTER);

        //! OK Button
        JButton okButton = Utils.createButton("OK", 0, 0, 80, 30);
        okButton.addActionListener(e -> dialog.dispose());
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Utils.FRAME_BG);
        btnPanel.add(okButton);
        panel.add(btnPanel, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.setVisible(true);
    }


    //* Updated Balance Message
    public static void updatedBalanceMessage(JFrame frame, String message, String balanceMsg, String title) {

        JDialog dialog = new JDialog(frame, title, true);
        dialog.setSize(350, 200);
        dialog.setLayout(new BorderLayout());
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(frame);

        //! Panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Utils.FRAME_BG);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //! Message
        JLabel label = Utils.createLabel(message, 0, 0, 0, 0, JLabel.CENTER, Utils.SUBHEADING_COLOR, new Font("Segoe UI Semibold", Font.PLAIN, 16));
        panel.add(label, BorderLayout.NORTH);

        //! Balance Message
        JLabel label2 = Utils.createLabel(balanceMsg, 0, 0, 0, 0, JLabel.CENTER, Utils.TEXTFIELD_FG, new Font("Segoe UI Semibold", Font.PLAIN, 15));
        panel.add(label2, BorderLayout.CENTER);

        //! OK Button
        JButton okButton = Utils.createButton("OK", 0, 0, 80, 30);
        okButton.addActionListener(e -> dialog.dispose());
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Utils.FRAME_BG);
        btnPanel.add(okButton);
        panel.add(btnPanel, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    //* Show Confirmation Dialog (YES / NO)
    public static boolean showConfirmDialog(JFrame frame, String message, String title) {

        final boolean[] result = { false };

        JDialog dialog = new JDialog(frame, title, true);
        dialog.setSize(380, 170);
        dialog.setLayout(new BorderLayout());
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(frame);

        //! Panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Utils.FRAME_BG);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //! Message
        JLabel label = Utils.createLabel(
            message,
            0, 0, 0, 0,
            JLabel.CENTER,
            Utils.SUBHEADING_COLOR,
            new Font("Segoe UI Semibold", Font.PLAIN, 14)
        );
        panel.add(label, BorderLayout.CENTER);

        //! Buttons
        JButton btnYes = Utils.createButton("Yes", 0, 0, 80, 30);
        JButton btnNo = Utils.createButton("No", 0, 0, 80, 30);

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Utils.FRAME_BG);
        btnPanel.add(btnYes);
        btnPanel.add(btnNo);

        panel.add(btnPanel, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.setVisible(true);

        btnYes.addActionListener(e -> {
            result[0] = true;
            dialog.dispose();
        });

        btnNo.addActionListener(e -> dialog.dispose());

        return result[0];
    }

    //* Center Logo
    public static int centerLogo(int frameWidth, int LogoWidth) {
        return (frameWidth - LogoWidth) / 2;
    }


    //* Convert Account into line
    public static String accountToLine(Account account) {
                String accNo = account.getAccNo();
                String name = account.getName();
                String password = account.getPassword();
                String type = account.getType();
                String email = account.getEmail();
                String phone = account.getPhoneNum();
                String balance = String.valueOf(account.getBalance());

                String record = accNo + "," + name + "," + password + "," + type + "," + email + "," + phone + "," + balance;
                return record;
    }

    //* Convert line into Account
    public static Account lineToAccount(String line) {
        if (line == null || line.isEmpty()) {
            return null;
        }

        String[] data = line.split(",");

        if (data.length < 7) {
            return null;
        }

        String accNo = data[0];
        String name = data[1];
        String password = data[2];
        String type = data[3];
        String email = data[4];
        String phone = data[5];
        double balance = Double.parseDouble(data[6]);

        if (type.equalsIgnoreCase("Savings")) {
            return (new SavingsAccount(accNo, name, password, email, phone, balance));
        } else {
            return (new CheckingAccount(accNo, name, password, email, phone, balance));
        }
    }

}