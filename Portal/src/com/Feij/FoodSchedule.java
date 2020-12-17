package com.Feij;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FoodSchedule extends AdminPage {

    private JLabel[][][] schedule;



    public FoodSchedule(){
        super();



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


        addComponent(dinner, 1, 5, 8, 2);
        addComponent(schedule[0][1][0], 1, 7, 8, 3);
        addComponent(schedule[0][1][1], 5, 7, 8, 3);
        addComponent(schedule[1][1][0], 1, 10, 8, 3);
        addComponent(schedule[1][1][1], 5, 10, 8, 3);
        addComponent(schedule[2][1][0], 1, 13, 8, 3);
        addComponent(schedule[2][1][1], 5, 13, 8, 3);
        addComponent(schedule[3][1][0], 1, 16, 8, 3);
        addComponent(schedule[3][1][1], 5, 16, 8, 3);
        addComponent(schedule[4][1][0], 1, 19, 8, 3);
        addComponent(schedule[4][1][1], 5, 19, 8, 3);
        addComponent(schedule[5][1][0], 1, 22, 8, 3);
        addComponent(schedule[5][1][1], 5, 22, 8, 3);


        addComponent(lunch, 9, 5, 8, 2);
        addComponent(schedule[0][0][0], 9, 7, 8, 3);
        addComponent(schedule[0][0][1], 13, 7, 8, 3);
        addComponent(schedule[1][0][0], 9, 10, 8, 3);
        addComponent(schedule[1][0][1], 13, 10, 8, 3);
        addComponent(schedule[2][0][0], 9, 13, 8, 3);
        addComponent(schedule[2][0][1], 13, 13, 8, 3);
        addComponent(schedule[3][0][0], 9, 16, 8, 3);
        addComponent(schedule[3][0][1], 13, 16, 8, 3);
        addComponent(schedule[4][0][0], 9, 19, 8, 3);
        addComponent(schedule[4][0][1], 13, 19, 8, 3);
        addComponent(schedule[5][0][0], 9, 22, 8, 3);
        addComponent(schedule[5][0][1], 13, 22, 8, 3);


        addComponent(day, 17, 5, 4, 2);
        addComponent(days[0], 17, 7, 4, 3);
        addComponent(days[1], 17, 10, 4, 3);
        addComponent(days[2], 17, 13, 4, 3);
        addComponent(days[3], 17, 16, 4, 3);
        addComponent(days[4], 17, 19, 4, 3);
        addComponent(days[5], 17, 22, 4, 3);


    }

}
