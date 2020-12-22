package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is a subclass of AdminPage and it is UI of the food schedule of admin
 *
 * @author Feij
 * @since 2020.12.20
 * @version 1
 */
public class FoodSchedule extends AdminPage {

    private FoodTableGui foodTable;
    private JComboBox dayBox, mealBox;
    private JTextField priceField, nameField;
    private JButton setFood;

    public FoodSchedule(String username){
        super(username);

        foodTable = new FoodTableGui();

        String[] days = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","friday"};
        dayBox = new JComboBox(days);

        String[] meals = {"Lunch", "Dinner"};
        mealBox = new JComboBox(meals);

        priceField = new JTextField(" Price...");
        nameField = new JTextField("Food name...");
        setFood = new JButton("Set");

        Handler handler = new Handler();
        nameField.addActionListener(handler);
        priceField.addActionListener(handler);
        setFood.addActionListener(handler);

        addComponent(dayBox, 2, 3, 3, 1);
        addComponent(mealBox, 6, 3, 3, 1);
        addComponent(nameField, 10, 3, 3, 1);
        addComponent(priceField, 14, 3, 3, 1);
        addComponent(setFood, 18, 3, 4, 1);
        addComponent(foodTable, 2, 5, 20, 20);

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
                String day = (String) dayBox.getSelectedItem();
                String meal = (String) mealBox.getSelectedItem();
                String food = nameField.getText();
                if(food.startsWith(" ") || food.equals("")){
                    JOptionPane.showMessageDialog(null, "invalid input!",
                            "Warning!", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int price = Integer.parseInt(priceField.getText());
                food = food + "-" + price;
                getController().setAdminFoodTable(food, day, meal);
                foodTable.updateTable(getController().getAdminFoodTable());
            }
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "price should be an integer",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            }


        }
    }

}
