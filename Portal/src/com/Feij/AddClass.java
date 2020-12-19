package com.Feij;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AddClass extends ProfessorPage{

    private JTextField day, credits, time, name, capacity;
    private JButton addClass;

    public AddClass(){
        super();

        JLabel info = new JLabel(String.format("Please Enter Class Information"));
        info.setBackground(Color.ORANGE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        info.setBorder(border);
        info.setOpaque(true);
        info.setFont(new Font("serif", Font.BOLD, 20));
        info.setHorizontalAlignment(SwingConstants.CENTER);


        JLabel dayLabel, creditsLabel, timeLabel, nameLabel, capacityLabel;

        dayLabel = new JLabel(" Day:");
        creditsLabel = new JLabel(" credits:");
        timeLabel = new JLabel(" Time:");
        nameLabel = new JLabel(" Name Of The Class:");
        capacityLabel = new JLabel(" Capacity:");

        day = new JTextField();
        capacity = new JTextField();
        credits = new JTextField();
        time = new JTextField();
        name = new JTextField();

        addClass = new JButton("Add Class");


        addComponent(info,7,6, 10, 3);
        addComponent(nameLabel,7,9, 3, 2);
        addComponent(name,10,9, 7, 2);
        addComponent(creditsLabel,7,11, 3, 2);
        addComponent(credits,10,11, 7, 2);
        addComponent(capacityLabel,7,13, 3, 2);
        addComponent(capacity,10,13, 7, 2);
        addComponent(dayLabel,7,15, 3, 2);
        addComponent(day,10,15, 7, 2);
        addComponent(timeLabel,7,17, 3, 2);
        addComponent(time,10,17, 7, 2);
        addComponent(addClass,7,19, 10, 2);
    }
}
