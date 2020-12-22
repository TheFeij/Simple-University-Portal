package Gui;

import Gui.ProfessorPage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;

public class AddClass extends ProfessorPage {

    private JComboBox dayBox, creditsBox, timeBox;
    private JTextField nameField, capacityField;
    private JButton addClass;

    public AddClass(String username){
        super(username);

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

        String[] days = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","friday"};
        dayBox = new JComboBox(days);

        String[] credit = {"1", "2", "3", "4"};
        creditsBox = new JComboBox(credit);

        String[] times = {"8-10", "10-12", "14-16"};
        timeBox = new JComboBox(times);

        capacityField = new JTextField();
        nameField = new JTextField();

        addClass = new JButton("Add Class");

        Handler handler = new Handler();

        nameField.addActionListener(handler);
        capacityField.addActionListener(handler);
        addClass.addActionListener(handler);

        addComponent(info,7,6, 10, 3);
        addComponent(nameLabel,7,9, 3, 2);
        addComponent(nameField,10,9, 7, 2);
        addComponent(capacityLabel,7,11, 3, 2);
        addComponent(capacityField,10,11, 7, 2);
        addComponent(creditsLabel,7,13, 3, 2);
        addComponent(creditsBox,10,13, 7, 2);
        addComponent(dayLabel,7,15, 3, 2);
        addComponent(dayBox,10,15, 7, 2);
        addComponent(timeLabel,7,17, 3, 2);
        addComponent(timeBox,10,17, 7, 2);
        addComponent(addClass,7,19, 10, 2);
    }



    private class Handler implements ActionListener{


        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            String name = nameField.getText();
            try{
                int capacity = Integer.parseInt(capacityField.getText());
                int credits = Integer.parseInt(String.valueOf(creditsBox.getSelectedItem()));
                String time = String.valueOf(timeBox.getSelectedItem());
                String day = String.valueOf(dayBox.getSelectedItem());
                getController().addClass(getUsername(), name, credits, capacity, time, day);
            }
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "please enter a number between 15 to 80",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            }

        }
    }
}
