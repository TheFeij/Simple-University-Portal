package com.Feij;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminLists extends AdminPage {

    private JTabbedPane tabbedPane;
    private JTable studentsTable, professorsTable, classesTable;
    private DefaultTableModel studentsModel, professorsModel, classesModel;

    public AdminLists(){
        super();

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

}
