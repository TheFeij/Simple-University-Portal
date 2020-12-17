package com.Feij;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PortalPage extends Page{

    private JLabel info;
    private JButton changeUsername, changePassword, logOut;


    public PortalPage(){
        super();


        info = new JLabel("Abolfazl Moradi");
        info.setBackground(Color.ORANGE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        info.setBorder(border);
        info.setOpaque(true);
        info.setFont(new Font("serif", Font.BOLD, 20));
        info.setIcon(new ImageIcon("./pics/4.jpg"));
        info.setVerticalTextPosition(SwingConstants.BOTTOM);


        changePassword = new JButton("Change Password");
        changeUsername = new JButton("Change Username");

        logOut = new JButton("Log Out");
        logOut.setBackground(Color.RED);
        logOut.setOpaque(true);

        JPanel[][] panels = new JPanel[30][30];
        for(int i = 0 ; i < 30 ; i++) {
            for (int j = 0; j < 30; j++) {
                panels[i][j] = new JPanel();
                addComponent(panels[i][j], j, i, 1, 1);
            }
        }


        addComponent(logOut, 0, 0, 1 ,1);
        addComponent(info, 20, 0, 10 ,10);
        addComponent(changeUsername, 20, 10, 10, 5);
        addComponent(logOut, 20, 15, 10 ,5);



    }


    public void fillTable(int x, int y){
        JPanel[][] panels = new JPanel[x][y];
        for(int i = 0 ; i < x ; i++)
            for(int j = 0 ; j < y ; j++)
                addComponent(panels[i][j], j, i, 1, 1);

    }
}
