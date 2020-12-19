package com.Feij;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProfessorsClasses extends JPanel {

    private DefaultTableModel classesModel;
    private JTable classesTable;

    public ProfessorsClasses(){
        super();

        classesModel = new DefaultTableModel();
        classesTable = new JTable(classesModel);
        classesModel.addColumn("Name");
        classesModel.addColumn("Credits");
        classesModel.addColumn("Capacity");
        classesModel.addColumn("Students");
        classesModel.addColumn("Time");

        JScrollPane scrollPane = new JScrollPane(classesTable);

        add(scrollPane);
    }
}
