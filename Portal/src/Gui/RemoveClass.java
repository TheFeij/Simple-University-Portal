package Gui;

import com.Feij.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveClass extends ProfessorPage {

    private ProfessorsClasses classes;
    private JTextField classNameCloseField;

    private JTextField classNameEnterField;
    private JButton enterClassButton;

    private JButton removeButton;

    public RemoveClass(String username, Controller controller){
        super(username);

        classes = new ProfessorsClasses();
        classes.setInformation(controller.getProfessorClassesInfo(getUsername()));
        classes.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));

        JScrollPane scrollPane = new JScrollPane(classes);

        JLabel closeInfo = new JLabel("Remove A Class");
        closeInfo.setBackground(Color.ORANGE);
        closeInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        closeInfo.setHorizontalAlignment(SwingConstants.CENTER);
        closeInfo.setOpaque(true);

        JLabel enterInfo = new JLabel("Enter A Class");
        enterInfo.setBackground(Color.ORANGE);
        enterInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        enterInfo.setHorizontalAlignment(SwingConstants.CENTER);
        enterInfo.setOpaque(true);

        JLabel nameLabel = new JLabel("  Class Name");
        JLabel nameLabel1 = new JLabel("  Class Name");

        classNameCloseField = new JTextField();
        removeButton = new JButton("Remove");

        classNameEnterField = new JTextField();
        enterClassButton = new JButton("Enter Class");

        Handler handler = new Handler();
        removeButton.addActionListener(handler);
        classNameCloseField.addActionListener(handler);
        classNameEnterField.addActionListener(handler);
        enterClassButton.addActionListener(handler);

        addComponent(closeInfo, 12, 5, 8, 1);
        addComponent(nameLabel, 12, 6, 3, 1);
        addComponent(classNameCloseField, 15, 6, 5, 1);
        addComponent(removeButton, 12, 7, 8, 1);
        addComponent(enterInfo, 2, 5, 8, 1);
        addComponent(nameLabel1, 2, 6, 3, 1);
        addComponent(classNameEnterField, 5, 6, 5, 1);
        addComponent(enterClassButton, 2, 7, 8, 1);
        addComponent(scrollPane, 5, 10, 12, 15);

    }


    private class Handler implements ActionListener{



        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == removeButton || e.getSource() == classNameCloseField){
                String className = classNameCloseField.getText();
                getController().removeAClass(getUsername(), className);
                classes.resetInformation();
                classes.setInformation(getController().getProfessorClassesInfo(getUsername()));
            }
            else{
                String className = classNameEnterField.getText();
                if(getController().classExists(className)){
                    GiveGrade giveGrade = new GiveGrade(getUsername(), className);
                    giveGrade.setController(getController());
                    giveGrade.setInformation(getController().getClassStudentsInfo(className));
                    setVisible(false);
                    giveGrade.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Class does not exist!",
                            "Warning!", JOptionPane.WARNING_MESSAGE);
                }


            }

        }
    }




}
