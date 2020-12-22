package Gui;

import Gui.Page;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends Page {

    private JLabel usernameLabel, passwordLabel, infoLabel;
    private JButton loginButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton returnToFrontPage;
    private String type;


    public LoginPage(String type){

        super();
        this.setSize(new Dimension(370, 270));
        fillPage(13, 17, Color.LIGHT_GRAY);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        this.type = type;

        infoLabel = new JLabel("Please Enter Your Information");
        infoLabel.setBackground(Color.ORANGE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        infoLabel.setBorder(border);
        infoLabel.setOpaque(true);
        infoLabel.setFont(new Font("serif", Font.BOLD, 20));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");
        returnToFrontPage = new JButton("Return");
        returnToFrontPage.setBackground(Color.RED);

        Handler handler = new Handler();
        loginButton.addActionListener(handler);
        usernameField.addActionListener(handler);
        passwordField.addActionListener(handler);
        returnToFrontPage.addActionListener(handler);

        addComponent(returnToFrontPage, 2, 0, 1 ,1);
        addComponent(infoLabel, 2, 2, 10 ,2);
        addComponent(usernameLabel, 2, 4, 5 ,4);
        addComponent(usernameField, 7, 4, 5 ,4);
        addComponent(passwordLabel, 2, 8, 5 ,4);
        addComponent(passwordField, 7, 8, 5 ,4);
        addComponent(loginButton, 2, 12, 10 ,4);

    }


    private class Handler implements ActionListener{

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == loginButton || e.getSource() == usernameField
                    || e.getSource() == passwordField){

                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if(type.equals("Admin")){
                    if(getController().adminLoginCheck(username, password)){
                        setVisible(false);
                        AdminPage adminPage = new AdminPage(getController().getAdminUsername());
                        adminPage.setController(getController());
                        adminPage.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Login Failed", "Login Message", JOptionPane.WARNING_MESSAGE);
                        usernameField.setText(null);
                        passwordField.setText(null);
                    }
                }
                else if(type.equals("Professor")){

                    if(getController().professorLoginCheck(username, password)){
                        setVisible(false);
                        ProfessorPage professorPage = new ProfessorPage(username);
                        professorPage.setController(getController());
                        professorPage.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Login Failed", "Login Message", JOptionPane.WARNING_MESSAGE);
                        usernameField.setText(null);
                        passwordField.setText(null);
                    }



                }
                else if(type.equals("Student")){
                    if(getController().studentLoginCheck(username, password)){
                        setVisible(false);
                        StudentPage studentPage = new StudentPage(username);
                        studentPage.setController(getController());
                        studentPage.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Login Failed", "Login Message", JOptionPane.WARNING_MESSAGE);
                        usernameField.setText(null);
                        passwordField.setText(null);
                    }
                }

            }
            else if(e.getSource() == returnToFrontPage){
                setVisible(false);
                FrontPage frontPage = new FrontPage();
                frontPage.setController(getController());
                frontPage.setVisible(true);
            }
        }

    }

}
