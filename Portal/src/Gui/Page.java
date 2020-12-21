package Gui;

import com.Feij.Controller;

import javax.swing.*;
import java.awt.*;

public class Page extends JFrame {

    private final GridBagLayout layout;
    private final GridBagConstraints constraints;
    private JPanel[][] panels;
    private Controller controller;

    /**
     * A constructor to create a new main page
     */
    public Page(){
        super();
        this.setSize(new Dimension(1300, 700));
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        getContentPane().setLayout(layout);


    }


    /**
     * A method to fill JFrame with specified number of empty JPanels
     * @param columns number of columns to be added
     * @param rows number of rows to be added
     * @param background Background color of the empty panels
     */
    protected void fillPage(int columns, int rows, Color background){
        panels = new JPanel[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0 ; j  < columns ; j++){
                panels[i][j] = new JPanel();
                panels[i][j].setBackground(background);
                addComponent(panels[i][j], j, i, 1,1);
            }

        }
    }

    /**
     * A method to free an Area in the JFrame
     * @param column the column to be freed
     * @param row the row to be freed
     * @param width width of the area to be freed
     * @param height height of the area to be freed
     */
    private void freeCells(int column, int row, int width, int height){
        for(int i = row  ; i < row + height; i++)
            for(int j = column ; j < column + width; j++)
                remove(panels[i][j]);

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
        freeCells(column, row, width ,height);
        add(component);
    }

    /**
     * A method to set location relative of JFrame
     * @param component component which our Frame wants to be related to
     */
    public  void setLocation(Component component){
        setLocationRelativeTo(component);
    }


    /**
     * A method to set controller
     * @param controller controller to be set
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * A method to get controller
     * @return controller
     */
    public Controller getController() {
        return controller;
    }
}
