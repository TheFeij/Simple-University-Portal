package com.Feij;


import javax.swing.*;
import java.awt.*;

public class AdminPage extends PortalPage {

    private JButton addUserButton, foodScheduleButton, usersListButton;
    private JButton classesButton;


    public AdminPage(){
        super("Admin");

        addUserButton = new JButton("Add User");
        foodScheduleButton = new JButton("Food Schedule");
        usersListButton = new JButton("Users List");
        classesButton = new JButton("Classes");

        JLabel empty2 = new JLabel();
        empty2.setBackground(Color.BLUE);
        empty2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        empty2.setOpaque(true);

        addComponent(addUserButton, 25, 3, 5, 1);
        addComponent(foodScheduleButton, 25, 4, 5, 1);
        addComponent(usersListButton, 25, 5, 5, 1);
        addComponent(classesButton, 25, 6, 5, 1);
        addComponent(empty2, 25, 7, 5, 23);
    }

}
