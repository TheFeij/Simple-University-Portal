package Gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ReserveFood extends StudentPage {

    private FoodTableGui foodTable;
    private JLabel balance;

    public ReserveFood(String username){
        super(username);

        foodTable = new FoodTableGui();

        JLabel balance = new JLabel(String.format("Current Balance: %sR", "1500000"));
        balance.setBackground(Color.LIGHT_GRAY);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        balance.setBorder(border);
        balance.setOpaque(true);
        balance.setFont(new Font("serif", Font.BOLD, 20));
        balance.setHorizontalAlignment(SwingConstants.CENTER);



        addComponent(balance, 9, 2, 6, 2);
        addComponent(foodTable, 2, 6, 20, 20);
    }

}
