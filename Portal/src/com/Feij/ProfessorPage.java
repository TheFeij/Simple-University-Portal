package com.Feij;

import javax.swing.*;
import java.awt.*;

public class ProfessorPage extends PortalPage {

    private JButton addClassButton, gradingButton, closingClassButton;

    public ProfessorPage(){
        super("Professor");

        addClassButton = new JButton("Add Class");
        gradingButton = new JButton("Give Grade");
        closingClassButton = new JButton("Close Class");

        JLabel empty2 = new JLabel();
        empty2.setBackground(Color.BLUE);
        empty2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        empty2.setOpaque(true);

        addComponent(addClassButton, 25, 2, 5, 1);
        addComponent(gradingButton, 25, 3, 5, 1);
        addComponent(closingClassButton, 25, 4, 5, 1);
        addComponent(empty2, 25, 5, 5, 25);
    }
}
