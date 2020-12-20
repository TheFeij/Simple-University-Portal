package com.Feij;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FoodTableGui extends Panel {

    private final GridBagLayout layout;
    private final GridBagConstraints constraints;
    private JLabel[][][] schedule;

    public FoodTableGui(){

        super();
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        setLayout(layout);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        schedule = new JLabel[6][2][2];
        for(int i = 0 ; i < 6 ; i++){
            schedule[i][0][0] = new JLabel(" First Choice");
            schedule[i][0][0].setBorder(border);
            //schedule[i][0][0].setHorizontalAlignment(SwingConstants.CENTER);

            schedule[i][0][1] = new JLabel(" Second Choice");
            schedule[i][0][1].setBorder(border);
            //schedule[i][0][1].setHorizontalAlignment(SwingConstants.CENTER);

            schedule[i][1][0] = new JLabel(" First Choice");
            schedule[i][1][0].setBorder(border);
            //schedule[i][1][0].setHorizontalAlignment(SwingConstants.CENTER);

            schedule[i][1][1] = new JLabel(" Second Choice");
            schedule[i][1][1].setBorder(border);
            //schedule[i][1][1].setHorizontalAlignment(SwingConstants.CENTER);
        }

        JLabel lunch, dinner, day;
        lunch = new JLabel("Lunch");
        lunch.setHorizontalAlignment(SwingConstants.CENTER);
        lunch.setBorder(border);
        dinner = new JLabel("Dinner");
        dinner.setHorizontalAlignment(SwingConstants.CENTER);
        dinner.setBorder(border);
        day = new JLabel("Day");
        day.setHorizontalAlignment(SwingConstants.CENTER);
        day.setBorder(border);

        JLabel[] days = new JLabel[6];
        days[0] = new JLabel("Saturday");
        days[1] = new JLabel("Sunday");
        days[2] = new JLabel("Monday");
        days[3] = new JLabel("Tuesday");
        days[4] = new JLabel("Wednesday");
        days[5] = new JLabel("Thursday");

        for(int i = 0 ; i < 6 ; i++){
            days[i].setHorizontalAlignment(SwingConstants.CENTER);
            days[i].setBorder(border);
        }


        addComponent(dinner, 0, 0, 8, 2);
        addComponent(schedule[0][1][0], 0, 2, 4, 3);
        addComponent(schedule[0][1][1], 4, 2, 4, 3);
        addComponent(schedule[1][1][0], 0, 5, 4, 3);
        addComponent(schedule[1][1][1], 4, 5, 4, 3);
        addComponent(schedule[2][1][0], 0, 8, 4, 3);
        addComponent(schedule[2][1][1], 4, 8, 4, 3);
        addComponent(schedule[3][1][0], 0, 11, 4, 3);
        addComponent(schedule[3][1][1], 4, 11, 4, 3);
        addComponent(schedule[4][1][0], 0, 14, 4, 3);
        addComponent(schedule[4][1][1], 4, 14, 4, 3);
        addComponent(schedule[5][1][0], 0, 17, 4, 3);
        addComponent(schedule[5][1][1], 4, 17, 4, 3);


        addComponent(lunch, 8, 0, 8, 2);
        addComponent(schedule[0][0][0], 8, 2, 4, 3);
        addComponent(schedule[0][0][1], 12, 2, 4, 3);
        addComponent(schedule[1][0][0], 8, 5, 4, 3);
        addComponent(schedule[1][0][1], 12, 5, 4, 3);
        addComponent(schedule[2][0][0], 8, 8, 4, 3);
        addComponent(schedule[2][0][1], 12, 8, 4, 3);
        addComponent(schedule[3][0][0], 8, 11, 4, 3);
        addComponent(schedule[3][0][1], 12, 11, 4, 3);
        addComponent(schedule[4][0][0], 8, 14, 4, 3);
        addComponent(schedule[4][0][1], 12, 14, 4, 3);
        addComponent(schedule[5][0][0], 8, 17, 4, 3);
        addComponent(schedule[5][0][1], 12, 17, 4, 3);


        addComponent(day, 16, 0, 4, 2);
        addComponent(days[0], 16, 2, 4, 3);
        addComponent(days[1], 16, 5, 4, 3);
        addComponent(days[2], 16, 8, 4, 3);
        addComponent(days[3], 16, 11, 4, 3);
        addComponent(days[4], 16, 14, 4, 3);
        addComponent(days[5], 16, 17, 4, 3);




    }

    /**
     *
     * @param component component to be added
     * @param row number of the row
     * @param column number of the column
     * @param width width of the component
     * @param height height of the component
     */
    public void addComponent(Component component, int column, int row, int width, int height){
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        layout.setConstraints(component, constraints);
        add(component);
    }

}
