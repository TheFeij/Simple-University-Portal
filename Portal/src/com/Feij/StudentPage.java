package com.Feij;

import javax.swing.*;
import java.awt.*;

public class StudentPage extends PortalPage{

    private JButton increaseBalance, reserveFood, chooseClasses;

    public StudentPage(){
        super("Student");


        increaseBalance = new JButton("Increase Balance");
        reserveFood = new JButton("Reserve Food");
        chooseClasses = new JButton("ChooseClasses");

        JLabel empty2 = new JLabel();
        empty2.setBackground(Color.BLUE);
        empty2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        empty2.setOpaque(true);

        addComponent(increaseBalance, 25, 2, 5, 1);
        addComponent(reserveFood, 25, 3, 5, 1);
        addComponent(chooseClasses, 25, 4, 5, 1);
        addComponent(empty2, 25, 5, 5, 25);

    }
}
