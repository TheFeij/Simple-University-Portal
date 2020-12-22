package Gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseClass extends StudentPage {

    private JTable classesTable;
    private DefaultTableModel classesModel;
    private JLabel infoLabel;
    private JTextField classNameField;
    private JButton addButton;


    public ChooseClass(String username){
        super(username);

        classesModel = new DefaultTableModel();
        classesTable = new JTable(classesModel);
        classesModel.addColumn("Name");
        classesModel.addColumn("Credits");
        classesModel.addColumn("Professor");
        classesModel.addColumn("Capacity");
        classesModel.addColumn("Students");
        classesModel.addColumn("Day");
        classesModel.addColumn("Time");

        infoLabel = new JLabel("Enter a class name to add");
        infoLabel.setBackground(Color.ORANGE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 4);
        infoLabel.setBorder(border);
        infoLabel.setOpaque(true);
        infoLabel.setFont(new Font("serif", Font.BOLD, 20));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel classNameLabel = new JLabel(" Class Name: ");

        classNameField = new JTextField();
        addButton = new JButton("Add");

        JScrollPane scrollPane = new JScrollPane(classesTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));

        Handler handler = new Handler();
        classNameField.addActionListener(handler);
        addButton.addActionListener(handler);

        addComponent(scrollPane, 3, 13, 17, 10);
        addComponent(infoLabel, 7, 4, 8, 3);
        addComponent(classNameLabel, 7, 7, 3, 2);
        addComponent(classNameField, 10, 7, 5, 2);
        addComponent(addButton, 7, 9, 8, 2);


    }


    /**
     * A method to add a new row to classes table
     * @param info information to be added
     */
    public void addClassInfo(String[] info) {
        classesModel.insertRow(classesModel.getRowCount(), info);
    }

    /**
     * A method to set information of the table
     * @param classesInfo information of classes
     */
    public void setInformation(String[][] classesInfo){
        for(String[] info : classesInfo){
            addClassInfo(info);
        }
    }

    /**
     * A method to reset information of table
     */
    public void resetInformation(){
        System.out.println(classesModel.getRowCount());
        for(int i = 0 ; i < classesModel.getRowCount() ; i++){
            classesModel.removeRow(i);
        }
        classesModel.setRowCount(0);
    }


    private class Handler implements ActionListener{


        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String className = classNameField.getText();
            getController().addStudentToClass(getUsername(), className);
            resetInformation();
            setInformation(getController().getClassesInfo());
        }
    }
}
