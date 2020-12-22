package Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class GiveGrade extends ProfessorPage {

    private JTable studentsTable;
    private DefaultTableModel model;

    private JLabel infoLabel;
    private JLabel usernameLabel, gradeLabel;
    private JTextField usernameField, gradeField;
    private JButton giveGradeButton;
    private String className;


    public GiveGrade(String username, String className){
        super(username);

        infoLabel = new JLabel("Give Grade");
        infoLabel.setBackground(Color.ORANGE);
        infoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setFont(new Font("serif", Font.BOLD, 20));
        infoLabel.setOpaque(true);

        this.className = className;

        usernameLabel = new JLabel(" Username: ");
        gradeLabel = new JLabel(" Grade: ");

        usernameField = new JTextField();
        gradeField = new JTextField();
        giveGradeButton = new JButton("Give Grade");

        model = new DefaultTableModel();
        studentsTable = new JTable(model);
        model.addColumn("Username");
        model.addColumn("Grade");

        JScrollPane scrollPane = new JScrollPane(studentsTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 4));

        Handler handler = new Handler();
        usernameField.addActionListener(handler);
        gradeField.addActionListener(handler);
        giveGradeButton.addActionListener(handler);

        addComponent(infoLabel, 8, 5, 8, 2);
        addComponent(usernameLabel, 8, 7, 3, 2);
        addComponent(usernameField, 11, 7, 5, 2);
        addComponent(gradeLabel, 8, 9, 3, 2);
        addComponent(gradeField, 11, 9, 5, 2);
        addComponent(giveGradeButton, 8, 11, 8, 2);
        addComponent(scrollPane, 2, 15, 20, 10);







    }

    /**
     * A method to add a new row to students table
     * @param info information to be added
     */
    public void addStudentInfo(String[] info){
        model.insertRow(model.getRowCount(), info);
    }

    /**
     * A method to set information of the table
     * @param studentsInfo information of students
     */
    public void setInformation(String[][] studentsInfo){

        for(String[] info : studentsInfo){
            addStudentInfo(info);
        }
    }

    /**
     * A method to reset information of table
     */
    public void resetInformation(){
        System.out.println(model.getRowCount());
        for(int i = 0 ; i < model.getRowCount() ; i++){
            model.removeRow(i);
        }
        model.setRowCount(0);
    }

    private class Handler implements ActionListener{


        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String username = usernameField.getText();
                int grade = Integer.parseInt(gradeField.getText());
                if(grade >= 0 && grade <= 20){
                    getController().giveGrade(className, username, grade);
                    JOptionPane.showMessageDialog(null, "grade is set!",
                            "Warning!", JOptionPane.WARNING_MESSAGE);
                    resetInformation();
                    setInformation(getController().getClassStudentsInfo(className));
                }
                else
                    JOptionPane.showMessageDialog(null, "grade is not valid!",
                            "Warning!", JOptionPane.WARNING_MESSAGE);

            }
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "grade must be an integer!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            }

        }
    }
}
