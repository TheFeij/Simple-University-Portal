package Gui;

import com.Feij.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorPage extends PortalPage {

    private JButton addClassButton, gradingButton, closingClassButton;

    public ProfessorPage(String username){
        super("Professor", username);

        addClassButton = new JButton("Add Class");
        gradingButton = new JButton("Give Grade");
        closingClassButton = new JButton("Close Class");

        JLabel empty2 = new JLabel();
        empty2.setBackground(Color.BLUE);
        empty2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        empty2.setOpaque(true);

        Handler handler = new Handler();
        addClassButton.addActionListener(handler);
        gradingButton.addActionListener(handler);
        closingClassButton.addActionListener(handler);
        getLogOut().addActionListener(handler);
        getChangeUsername().addActionListener(handler);

        addComponent(addClassButton, 25, 2, 5, 1);
        addComponent(gradingButton, 25, 3, 5, 1);
        addComponent(closingClassButton, 25, 4, 5, 1);
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
                page = new ProfessorChangeUserPass(getController(), getUsername());
            }
            else if(e.getSource() == addClassButton){
                page = new AddClass(getUsername());
            }
            else if(e.getSource() == gradingButton){
                /////////////////////////////////
            }
            else if(e.getSource() == closingClassButton){
                page = new RemoveClass(getUsername());
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
