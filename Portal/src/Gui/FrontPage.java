package Gui;

import Gui.Page;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontPage extends Page {

    private JLabel portalLabel;
    private JLabel adminIcon, studentIcon, professorIcon;
    private JButton adminLogin, studentLogin, professorLogin;

    public FrontPage(){
        super();
        fillPage(40, 40, Color.CYAN);
        getContentPane().setBackground(Color.CYAN);

        portalLabel = new JLabel("University Portal");
        portalLabel.setBackground(Color.ORANGE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        portalLabel.setBorder(border);
        portalLabel.setOpaque(true);
        portalLabel.setFont(new Font("serif", Font.BOLD, 40));
        portalLabel.setHorizontalAlignment(SwingConstants.CENTER);

        adminIcon = new JLabel(new ImageIcon("./pics/1.jpg"));
        studentIcon = new JLabel(new ImageIcon("./pics/2.jpg"));
        professorIcon = new JLabel(new ImageIcon("./pics/3.jpg"));


        adminLogin = new JButton("Login As Admin");
        studentLogin = new JButton("Login As Student");
        professorLogin = new JButton("Login As Professor");

        Font buttonFont = new Font("aria", Font.BOLD, 15);
        adminLogin.setFont(buttonFont);
        studentLogin.setFont(buttonFont);
        professorLogin.setFont(buttonFont);

        Handler handler = new Handler();
        adminLogin.addActionListener(handler);
        professorLogin.addActionListener(handler);
        studentLogin.addActionListener(handler);

        addComponent(portalLabel, 4 ,9 ,30 ,5);
        addComponent(adminIcon, 4 ,14 ,10 ,10);
        addComponent(studentIcon, 14 ,14 ,10 ,10);
        addComponent(professorIcon, 24 ,14 ,10 ,10);
        addComponent(adminLogin, 5 ,24 ,8 ,5);
        addComponent(studentLogin, 15 ,24 ,8 ,5);
        addComponent(professorLogin, 25 ,24 ,8 ,5);

    }




    private class Handler implements ActionListener{

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            setVisible(false);
            LoginPage loginPage = null;

            if(e.getSource() == adminLogin)
                loginPage = new LoginPage("Admin");

            else if(e.getSource() == studentLogin)
                loginPage = new LoginPage("Student");

            else if(e.getSource() == professorLogin)
               loginPage = new LoginPage("Professor");

            loginPage.setLocationRelativeTo(null);
            loginPage.setController(getController());
            loginPage.setVisible(true);
        }
    }

}
