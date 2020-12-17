package com.Feij;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FrontPage extends Page {

    private JLabel portalLabel;
    private JLabel adminIcon, studentIcon, professorIcon;
    private JButton adminLogin, studentLogin, professorLogin;

    public FrontPage(){
        super();
        fillPage(40, 40, Color.CYAN);
        getContentPane().setBackground(Color.CYAN);

        portalLabel = new JLabel("University Portal");
        portalLabel.setBackground(Color.ORANGE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        portalLabel.setBorder(border);
        portalLabel.setOpaque(true);
        portalLabel.setFont(new Font("serif", Font.BOLD, 40));
        portalLabel.setHorizontalAlignment(SwingConstants.CENTER);

        adminIcon = new JLabel(new ImageIcon("./pics/1.jpg"));
        studentIcon = new JLabel(new ImageIcon("./pics/2.jpg"));
        professorIcon = new JLabel(new ImageIcon("./pics/3.jpg"));

        adminLogin = new JButton("Login As Admin");
        studentLogin = new JButton("Login As Student");
        professorLogin = new JButton("Login As Professor");

        addComponent(portalLabel, 4 ,9 ,30 ,5);
        addComponent(adminIcon, 4 ,14 ,10 ,10);
        addComponent(studentIcon, 14 ,14 ,10 ,10);
        addComponent(professorIcon, 24 ,14 ,10 ,10);
        addComponent(adminLogin, 5 ,24 ,8 ,5);
        addComponent(studentLogin, 15 ,24 ,8 ,5);
        addComponent(professorLogin, 25 ,24 ,8 ,5);

    }




}
