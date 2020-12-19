package com.Feij;

import javax.swing.*;
import java.awt.*;

public class RemoveClass extends ProfessorPage {

    private ProfessorsClasses classes;
    private JTextField className;

    private JButton removeButton;

    public RemoveClass(){
        super();

        classes = new ProfessorsClasses();

        JLabel info = new JLabel("Remove A Class");
        info.setBackground(Color.ORANGE);
        info.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setOpaque(true);

        JLabel nameLabel = new JLabel("  Class Name");

        className = new JTextField();
        removeButton = new JButton("Remove");



        addComponent(info, 9, 5, 8, 1);
        addComponent(nameLabel, 9, 6, 3, 1);
        addComponent(className, 12, 6, 5, 1);
        addComponent(removeButton, 9, 7, 8, 1);
        addComponent(classes, 8, 10, 10, 10);

    }
}
