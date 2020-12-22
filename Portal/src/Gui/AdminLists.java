package Gui;

import Gui.AdminPage;
import com.Feij.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AdminLists extends AdminPage {

    private JTabbedPane tabbedPane;
    private JTable studentsTable, professorsTable, classesTable;
    private DefaultTableModel studentsModel, professorsModel, classesModel;

    public AdminLists(String username){
        super(username);

        studentsModel = new DefaultTableModel();
        studentsTable = new JTable(studentsModel);
        studentsModel.addColumn("Username");
        studentsModel.addColumn("Password");
        studentsModel.addColumn("Grade");
        studentsModel.addColumn("Total Credits");
        studentsModel.addColumn("Balance");

        professorsModel = new DefaultTableModel();
        professorsTable = new JTable(professorsModel);
        professorsModel.addColumn("Username");
        professorsModel.addColumn("Password");
        professorsModel.addColumn("Total Credits");

        classesModel = new DefaultTableModel();
        classesTable = new JTable(classesModel);
        classesModel.addColumn("Name");
        classesModel.addColumn("Credits");
        classesModel.addColumn("Professor");
        classesModel.addColumn("Capacity");
        classesModel.addColumn("Students");
        classesModel.addColumn("Day");
        classesModel.addColumn("Time");

        JScrollPane studentsScroll, professorsScroll, classesScroll;

        studentsScroll = new JScrollPane(studentsTable);
        professorsScroll = new JScrollPane(professorsTable);
        classesScroll = new JScrollPane(classesTable);


        tabbedPane = new JTabbedPane();
        tabbedPane.add("Students", studentsScroll);
        tabbedPane.add("Professors", professorsScroll);
        tabbedPane.add("Classes", classesScroll);
        tabbedPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));

        addComponent(tabbedPane, 4,5, 17, 17);

    }


    /**
     * A method to add a new row to students table
     * @param info information to be added
     */
    public void addStudentInfo(String[] info){
        studentsModel.insertRow(studentsModel.getRowCount(), info);
    }

    /**
     * A method to add a new row to professors table
     * @param info information to be added
     */
    public void addProfessorInfo(String[] info){
        professorsModel.insertRow(professorsModel.getRowCount(), info);
    }

    /**
     * A method to add a new row to classes table
     * @param info information to be added
     */
    public void addClassInfo(String[] info){
        classesModel.insertRow(classesModel.getRowCount(), info);
    }

    /**
     * A method to set information of the table
     * @param studentsInfo information of students
     * @param professorsInfo information of professors
     * @param classesInfo information of classes
     */
    public void setInformation(String[][] studentsInfo, String[][] professorsInfo,

                               String[][] classesInfo){

        for(String[] info : studentsInfo){
            addStudentInfo(info);
        }

        for(String[] info : professorsInfo){
            addProfessorInfo(info);
        }

        for(String[] info : classesInfo){
            addClassInfo(info);
        }
    }

}
