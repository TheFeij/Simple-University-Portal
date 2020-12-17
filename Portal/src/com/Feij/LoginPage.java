package com.Feij;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoginPage extends Page {

    private JLabel usernameLabel, passwordLabel, infoLabel;
    private JButton loginButton;
    private JTextField usernameField;
    private JPasswordField passwordField;


    public LoginPage(){

        super();
        this.setSize(new Dimension(400, 250));
        fillPage(13, 17, Color.LIGHT_GRAY);
        getContentPane().setBackground(Color.LIGHT_GRAY);


        infoLabel = new JLabel("Please Enter Your Information");
        infoLabel.setBackground(Color.ORANGE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        infoLabel.setBorder(border);
        infoLabel.setOpaque(true);
        infoLabel.setFont(new Font("serif", Font.BOLD, 20));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        usernameField = new JPasswordField();
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");

        addComponent(infoLabel, 2, 2, 10 ,2);
        addComponent(usernameLabel, 2, 4, 5 ,4);
        addComponent(usernameField, 7, 4, 5 ,4);
        addComponent(passwordLabel, 2, 8, 5 ,4);
        addComponent(passwordField, 7, 8, 5 ,4);
        addComponent(loginButton, 2, 12, 10 ,4);

    }

}
