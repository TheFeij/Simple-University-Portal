package Gui;

import com.Feij.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentFoodTable extends Panel {

    private final GridBagLayout layout;
    private final GridBagConstraints constraints;
    private JButton[][][] schedule;
    private Controller controller;
    private String username;

    public StudentFoodTable(Controller controller, String username, String[][][] info){

        super();
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        setLayout(layout);

        this.controller = controller;
        this.username = username;

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        Handler handler = new Handler();

        schedule = new JButton[6][2][2];
        initializeTable(handler);
        updateTable(info);


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

    public void initializeTable(Handler handler){
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        for(int i = 0 ; i < 6 ; i++){
            schedule[i][0][0] = new JButton(" First Choice");
            schedule[i][0][0].setBorder(border);
            schedule[i][0][0].addActionListener(handler);
            //schedule[i][0][0].setHorizontalAlignment(SwingConstants.CENTER);

            schedule[i][0][1] = new JButton(" Second Choice");
            schedule[i][0][1].setBorder(border);
            schedule[i][0][1].addActionListener(handler);
            //schedule[i][0][1].setHorizontalAlignment(SwingConstants.CENTER);

            schedule[i][1][0] = new JButton(" First Choice");
            schedule[i][1][0].setBorder(border);
            schedule[i][1][0].addActionListener(handler);
            //schedule[i][1][0].setHorizontalAlignment(SwingConstants.CENTER);

            schedule[i][1][1] = new JButton(" Second Choice");
            schedule[i][1][1].setBorder(border);
            schedule[i][1][1].addActionListener(handler);
            //schedule[i][1][1].setHorizontalAlignment(SwingConstants.CENTER);
        }
    }

    /**
     * A method to update table
     * @param info information to be added to table
     */
    public void updateTable(String[][][] info){
        for(int i = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                for(int k = 0 ; k < 2  ;k++){
                    if(!info[i][j][k].equals("")){
                        schedule[i][j][k].setText(info[i][j][k]);
                        schedule[i][j][k].setBackground(Color.GREEN);
                    }
                }
            }
        }
    }


    private class Handler implements ActionListener{


        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String food = null;
            if(e.getSource() == schedule[0][0][0]){
                if(!check(schedule[0][0][0])){
                    return;
                }
                food = schedule[0][0][0].getText();
                if(controller.studentReserveFood(username, food, 0, 0, 0)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[0][0][0].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[0][0][1]){
                if(!check(schedule[0][0][1])){
                    return;
                }
                food = schedule[0][0][1].getText();
                if(controller.studentReserveFood(username, food, 0, 0, 1)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[0][0][1].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[0][1][0]){
                if(!check(schedule[0][1][0])){
                    return;
                }
                food = schedule[0][1][0].getText();
                if(controller.studentReserveFood(username, food, 0, 1, 0)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[0][1][0].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[0][1][1]){
                if(!check(schedule[0][1][1])){
                    return;
                }
                food = schedule[0][1][1].getText();
                if(controller.studentReserveFood(username, food, 0, 1, 1)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[0][1][1].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[1][0][0]){
                if(!check(schedule[1][0][0])){
                    return;
                }
                food = schedule[1][0][0].getText();
                if(controller.studentReserveFood(username, food, 1, 0, 0)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[1][0][0].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[1][0][1]){
                if(!check(schedule[1][0][1])){
                    return;
                }
                food = schedule[1][0][1].getText();
                if(controller.studentReserveFood(username, food, 1, 0, 1)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[1][0][1].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[1][1][0]){
                if(!check(schedule[1][1][0])){
                    return;
                }
                food = schedule[1][1][0].getText();
                if(controller.studentReserveFood(username, food, 1, 1, 0)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[1][1][0].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[1][1][1]){
                if(!check(schedule[1][1][1])){
                    return;
                }
                food = schedule[1][1][1].getText();
                if(controller.studentReserveFood(username, food, 1, 1, 1)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[1][1][1].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[2][0][0]){
                if(!check(schedule[2][0][0])){
                    return;
                }
                food = schedule[2][0][0].getText();
                if(controller.studentReserveFood(username, food, 2, 0, 0)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[2][0][0].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[2][0][1]){
                if(!check(schedule[2][0][1])){
                    return;
                }
                food = schedule[2][0][1].getText();
                if(controller.studentReserveFood(username, food, 2, 0, 1)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[2][0][1].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[2][1][0]){
                if(!check(schedule[2][1][0])){
                    return;
                }
                food = schedule[2][1][0].getText();
                if(controller.studentReserveFood(username, food, 2, 1, 0)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[2][1][0].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[2][1][1]){
                if(!check(schedule[2][1][1])){
                    return;
                }
                food = schedule[2][1][1].getText();
                if(controller.studentReserveFood(username, food, 2, 1, 1)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[2][1][1].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[3][0][0]){
                if(!check(schedule[3][0][0])){
                    return;
                }
                food = schedule[3][0][0].getText();
                if(controller.studentReserveFood(username, food, 3, 0, 0)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[3][0][0].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[3][0][1]){
                if(!check(schedule[3][0][1])){
                    return;
                }
                food = schedule[3][0][1].getText();
                if(controller.studentReserveFood(username, food, 3, 0, 1)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[3][0][1].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[3][1][0]){
                if(!check(schedule[3][1][0])){
                    return;
                }
                food = schedule[3][1][0].getText();
                if(controller.studentReserveFood(username, food, 3, 1, 0)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[3][1][0].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[3][1][1]){
                if(!check(schedule[3][1][1])){
                    return;
                }
                food = schedule[3][1][1].getText();
                if(controller.studentReserveFood(username, food, 3, 1, 1)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[3][1][1].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[4][0][0]){
                if(!check(schedule[4][0][0])){
                    return;
                }
                food = schedule[4][0][0].getText();
                if(controller.studentReserveFood(username, food, 4, 0, 0)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[4][0][0].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[4][0][1]){
                if(!check(schedule[4][0][1])){
                    return;
                }
                food = schedule[4][0][1].getText();
                if(controller.studentReserveFood(username, food, 4, 0, 1)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[4][0][1].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[4][1][0]){
                if(!check(schedule[4][1][0])){
                    return;
                }
                food = schedule[4][1][0].getText();
                if(controller.studentReserveFood(username, food, 4, 1, 0)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[4][1][0].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[4][1][1]){
                if(!check(schedule[4][1][1])){
                    return;
                }
                food = schedule[4][1][1].getText();
                if(controller.studentReserveFood(username, food, 4, 1, 1)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[4][1][1].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[5][0][0]){
                if(!check(schedule[5][0][0])){
                    return;
                }
                food = schedule[5][0][0].getText();
                if(controller.studentReserveFood(username, food, 5, 0, 0)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[5][0][0].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[5][0][1]){
                if(!check(schedule[5][0][1])){
                    return;
                }
                food = schedule[5][0][1].getText();
                if(controller.studentReserveFood(username, food, 5, 0, 1)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[5][0][1].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[5][1][0]){
                if(!check(schedule[5][1][0])){
                    return;
                }
                food = schedule[5][1][0].getText();
                if(controller.studentReserveFood(username, food, 5, 1, 0)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[5][1][0].setOpaque(true);
                }
            }
            else if(e.getSource() == schedule[5][1][1]){
                if(!check(schedule[5][1][1])){
                    return;
                }
                food = schedule[5][1][1].getText();
                if(controller.studentReserveFood(username, food, 5, 1, 1)){
                    updateTable(controller.getStudentFoodTable(username));
                    schedule[5][1][1].setOpaque(true);
                }
            }

        }

        public boolean check(JButton button){
            if(button.getText().equals("First Choice") || button.getText().equals("Second Choice"))
                return false;
            return true;
        }
    }

}
