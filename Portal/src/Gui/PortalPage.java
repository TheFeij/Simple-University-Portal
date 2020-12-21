package Gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PortalPage extends Page {

    private JLabel info;
    private JButton changeUsername, logOut;
    private JLabel empty1;


    public PortalPage(String privilege, String username){
        super();
        fillPage(30, 30, Color.CYAN);


        empty1 = new JLabel(username);
        empty1.setBackground(Color.ORANGE);
        empty1.setHorizontalAlignment(SwingConstants.CENTER);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        empty1.setBorder(border);
        empty1.setOpaque(true);

        info = new JLabel(privilege);
        info.setBackground(Color.ORANGE);
        info.setBorder(border);
        info.setOpaque(true);
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setVerticalAlignment(SwingConstants.CENTER);

        changeUsername = new JButton("Change User/Pass");

        logOut = new JButton("Log Out");
        logOut.setBackground(Color.RED);
        logOut.setOpaque(true);
        logOut.setBorder(border);


        addComponent(logOut, 0, 0, 1 ,1);
        addComponent(info, 1, 0, 3 ,1);
        addComponent(empty1, 25, 0, 5 ,1);
        addComponent(changeUsername, 25, 1, 5, 1);

    }

    public String getUsername(){
        return empty1.getText();
    }

    public void setUsername(String newUsername){
        empty1.setText(newUsername);
    }


    public void setName(String name){
        info.setText(name);
    }

    /**
     * A method to get changeUsername/password button
     * @return changeUsername/password button
     */
    public JButton getChangeUsername() {
        return changeUsername;
    }

    /**
     * A method to get logout button
     * @return logout button
     */
    public JButton getLogOut() {
        return logOut;
    }
}
