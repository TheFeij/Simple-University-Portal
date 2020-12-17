package com.Feij;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PortalPage extends Page{

    private JLabel info;
    private JButton changeUsername, changePassword, logOut;


    public PortalPage(String privilege){
        super();
        fillPage(30, 30, Color.CYAN);


        JLabel empty1 = new JLabel(privilege);
        empty1.setBackground(Color.ORANGE);
        empty1.setHorizontalAlignment(SwingConstants.CENTER);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        empty1.setBorder(border);
        empty1.setOpaque(true);

        info = new JLabel("Admin");
        info.setBackground(Color.ORANGE);
        info.setBorder(border);
        info.setOpaque(true);
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setVerticalAlignment(SwingConstants.CENTER);

        changePassword = new JButton("Change Password");
        changeUsername = new JButton("Change Username");

        logOut = new JButton("Log Out");
        logOut.setBackground(Color.RED);
        logOut.setOpaque(true);
        logOut.setBorder(border);


        addComponent(logOut, 0, 0, 1 ,1);
        addComponent(info, 1, 0, 3 ,1);
        addComponent(empty1, 25, 0, 5 ,1);
        addComponent(changeUsername, 25, 1, 5, 1);
        addComponent(changePassword, 25, 2, 5, 1);



    }


    public void setName(String name){
        info.setText(name);
    }

}
