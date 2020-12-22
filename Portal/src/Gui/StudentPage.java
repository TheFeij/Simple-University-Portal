package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentPage extends PortalPage {

    private JButton increaseBalance, reserveFood, chooseClasses;

    public StudentPage(String username){
        super("Student", username);


        increaseBalance = new JButton("Increase Balance");
        reserveFood = new JButton("Reserve Food");
        chooseClasses = new JButton("ChooseClasses");

        JLabel empty2 = new JLabel();
        empty2.setBackground(Color.BLUE);
        empty2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        empty2.setOpaque(true);

        Handler handler = new Handler();
        getChangeUsername().addActionListener(handler);
        getLogOut().addActionListener(handler);
        increaseBalance.addActionListener(handler);
        reserveFood.addActionListener(handler);
        chooseClasses.addActionListener(handler);

        addComponent(increaseBalance, 25, 2, 5, 1);
        addComponent(reserveFood, 25, 3, 5, 1);
        addComponent(chooseClasses, 25, 4, 5, 1);
        addComponent(empty2, 25, 5, 5, 25);

    }


    private class Handler implements ActionListener {


        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton changeUserPass = getChangeUsername();
            JButton logout = getLogOut();
            Page page = null;

            if(e.getSource() == changeUserPass){
                page = new StudentChangeUserPass(getController(), getUsername());
            }
            else if(e.getSource() == increaseBalance){
                page = new IncreaseBalance(getUsername());
                IncreaseBalance increaseBalance = (IncreaseBalance)page;
                increaseBalance.setBalance(getController().getBalance(getUsername()));
            }
            else if(e.getSource() == reserveFood){
                page = new ReserveFood(getUsername(), getController(), getController().getAdminFoodTable());
            }
            else if(e.getSource() == chooseClasses){
                page = new ChooseClass(getUsername());
                ChooseClass chooseClass = (ChooseClass) page;
                chooseClass.setInformation(getController().getClassesInfo());
            }
            else if(e.getSource() == logout){
                page = new FrontPage();

            }
            changePage(page);
        }

        /**
         * A method to set preparations for changing a page
         * @param page page to become visible
         */
        private void changePage(Page page){
            page.setController(getController());
            page.setLocationRelativeTo(null);
            setVisible(false);
            page.setVisible(true);
        }
    }
}
