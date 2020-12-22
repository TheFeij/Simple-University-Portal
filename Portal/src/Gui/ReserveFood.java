package Gui;

import com.Feij.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReserveFood extends StudentPage {

    private StudentFoodTable foodTable;
    private JLabel balanceLabel;
    private Controller controller;

    public ReserveFood(String username, Controller controller, String[][][] info){
        super(username);

        foodTable = new StudentFoodTable(controller,username, info);

        this.controller = controller;

        balanceLabel = new JLabel();
        updateBalance();
        balanceLabel.setBackground(Color.LIGHT_GRAY);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        balanceLabel.setBorder(border);
        balanceLabel.setOpaque(true);
        balanceLabel.setFont(new Font("serif", Font.BOLD, 20));
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        addComponent(balanceLabel, 9, 2, 6, 2);
        addComponent(foodTable, 2, 6, 20, 20);
    }

    public void updateBalance(){
        balanceLabel.setText(String.format("Current Balance: %d", controller.getStudentBalance(getUsername())));
    }


}
