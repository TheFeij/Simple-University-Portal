package Gui;


import Gui.PortalPage;
import com.Feij.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends PortalPage {

    private JButton addUserButton, foodScheduleButton, usersListButton;


    public AdminPage(String username){
        super("Admin", username);

        addUserButton = new JButton("Add User");
        foodScheduleButton = new JButton("Food Schedule");
        usersListButton = new JButton("Users List");

        JLabel empty2 = new JLabel();
        empty2.setBackground(Color.BLUE);
        empty2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        empty2.setOpaque(true);

        Handler handler = new Handler();
        getChangeUsername().addActionListener(handler);
        getLogOut().addActionListener(handler);
        addUserButton.addActionListener(handler);
        foodScheduleButton.addActionListener(handler);
        usersListButton.addActionListener(handler);

        addComponent(addUserButton, 25, 2, 5, 1);
        addComponent(foodScheduleButton, 25, 3, 5, 1);
        addComponent(usersListButton, 25, 4, 5, 1);
        addComponent(empty2, 25, 5, 5, 25);
    }



    private class Handler implements ActionListener{


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
                page = new AdminChangeUserPass(getController(), getUsername());
            }
            else if(e.getSource() == addUserButton){
                page = new AddingUsersPage(getUsername());
            }
            else if(e.getSource() == foodScheduleButton){
                page = new FoodSchedule(getUsername());
            }
            else if(e.getSource() == usersListButton){
                page = new AdminLists(getUsername());
                AdminLists adminLists = (AdminLists) page;
                Controller controller = getController();
                adminLists.setInformation(controller.getStudentsInfo(), controller.getProfessorsInfo(),
                        controller.getClassesInfo());
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
