package ui;
import java.awt.*;
import javax.swing.*;
import utils.*;

public class Menu extends MainFrame {

    public Menu() {

        super("Bank Management Application", "Welcome to the Bank Management Application", 500, 750, 0, 105, 500, 30);

        //!Subheading
        JLabel subHeading = Utils.createLabel("Your Trusted Financial Partner", 50, 150, 400, 25, JLabel.CENTER, Utils.SUBHEADING_COLOR, new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(subHeading);

        //!Buttons

        JButton btnCreate = Utils.createButton("Create Account", 150, 220, 200, 45);
        panel.add(btnCreate);
        JButton btnLogin = Utils.createButton("Login", 150, 280, 200, 45);
        panel.add(btnLogin);
        JButton btnSearch = Utils.createButton("Search Account", 150, 340, 200, 45);
        panel.add(btnSearch);
        JButton btnShow = Utils.createButton("Display All Accounts", 150, 400, 200, 45);
        panel.add(btnShow);
        JButton btnDelete = Utils.createButton("Delete Account", 150, 460, 200, 45);
        panel.add(btnDelete);
        JButton btnExit = Utils.createButton("Exit", 150, 520, 200, 45);
        panel.add(btnExit);

        btnCreate.addActionListener(e -> {
            this.dispose();
            new CreateAccount();
        });

        btnLogin.addActionListener(e -> {
            this.dispose();
            new Login();
        });
        btnSearch.addActionListener(e -> {
            this.dispose();
            new SearchAccount();
        });
        btnDelete.addActionListener(e -> {
            this.dispose();
            new DeleteAccount();
        });
        btnShow.addActionListener(e -> {
            this.dispose();
            new ShowAccounts();
        });
        btnExit.addActionListener(e -> System.exit(0));

        this.setVisible(true);
    }
}