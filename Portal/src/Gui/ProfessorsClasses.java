package Gui;

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

    /**
     * A method to add a new row to classes table
     * @param info information to be added
     */
    public void addClassInfo(String[] info){
        classesModel.insertRow(classesModel.getRowCount(), info);
    }

    /**
     * A method to set information of the classes
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
}
