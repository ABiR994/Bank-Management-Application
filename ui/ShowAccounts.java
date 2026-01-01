package ui;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.io.*;
import data.*;
import model.*;
import utils.*;

public class ShowAccounts extends MainFrame {

    public ShowAccounts() {
        super("All Bank Accounts", "Displaying All Bank Accounts", 900, 650, 0, 110, 900, 30);

        //! Columns
        String[] columnNames = {"Account Number", "Full Name", "Account Type", "Email", "Phone", "Balance"};

        //! Table Model
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        //! Read all accounts and add to table
        try (BufferedReader br = AccountFileHandler.readAccounts()) {
            String line;
            while ((line = br.readLine()) != null) {
                Account account = Utils.lineToAccount(line);

                if (account != null) {
                    String[] rowData = new String[] {account.getAccNo(), account.getName(), account.getType(), account.getEmail(), account.getPhoneNum(), String.valueOf(account.getBalance())};
                    model.addRow(rowData);
                }
            }
        } catch (Exception e) {
            Utils.showMessage(this, "Error reading accounts!", "Error", 350);
        }

        //! JTable
        JTable table = new JTable(model);
        table.setEnabled(false);
        table.setRowHeight(35);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setBackground(Utils.PANEL_BG);
        table.setForeground(Utils.SUBHEADING_COLOR);

        //! Grid color
        table.setGridColor(Utils.BORDER_COLOR);

        //! Header
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(Utils.BUTTON_BG);
        header.setForeground(Utils.TEXT_COLOR);
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Utils.BORDER_COLOR));

        //! Cell Renderer
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        center.setForeground(Utils.SUBHEADING_COLOR);
        center.setBackground(Utils.PANEL_BG);
        center.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Utils.BORDER_COLOR));

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(center);
        }

        //! Column widths
        int[] widths = {130, 200, 130, 180, 130, 100};
        for (int i = 0; i < widths.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
        }

        //! ScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 160, 850, 350);

        scrollPane.setBorder(BorderFactory.createLineBorder(Utils.SUBHEADING_COLOR, 1));
        scrollPane.setBackground(Utils.PANEL_BG);
        scrollPane.getViewport().setBackground(Utils.PANEL_BG);

        //! Remove white corner
        JPanel corner = new JPanel();
        corner.setBackground(Utils.PANEL_BG);
        scrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, corner);

        //! Vertical Scrollbar
        JScrollBar vBar = scrollPane.getVerticalScrollBar();
        vBar.setPreferredSize(new Dimension(7, Integer.MAX_VALUE));
        vBar.setUI(new BasicScrollBarUI() {

            @Override
            protected void configureScrollBarColors() {
                thumbColor = Utils.BUTTON_BG;
                trackColor = Utils.PANEL_BG;
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
                g.setColor(Utils.PANEL_BG);
                g.fillRect(r.x, r.y, r.width, r.height);
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Utils.BUTTON_BG);
                g2.fillRoundRect(r.x, r.y, r.width, r.height, 8, 8);
            }

            @Override protected JButton createDecreaseButton(int o) { return zeroBtn(); }
            @Override protected JButton createIncreaseButton(int o) { return zeroBtn(); }

            private JButton zeroBtn() {
                JButton b = new JButton();
                b.setPreferredSize(new Dimension(0, 0));
                b.setBorder(null);
                b.setOpaque(false);
                return b;
            }
        });

        panel.add(scrollPane);

        //! Exit Button
        JButton btnExit = Utils.createButton("Exit", 400, 540, 100, 40);
        panel.add(btnExit);
        btnExit.addActionListener(e -> {
            this.dispose();
            new Menu();
        });

        setVisible(true);
    }
}
