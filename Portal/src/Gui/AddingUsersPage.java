package Gui;

import Gui.AdminPage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddingUsersPage extends AdminPage {

    private JLabel studentIcon, professorIcon;
    private JLabel studentLabel, professorLabel;
    private JTextField studentUsername, professorUsername;
    private JPasswordField studentPassword, professorPassword;
    private JLabel studentUsernameLabel, professorUsernameLabel;
    private JLabel studentPasswordLabel, professorPasswordLabel;
    private JButton studentAddButton, professorAddButton;

    public AddingUsersPage(String username){
        super(username);

        studentIcon = new JLabel(new ImageIcon("./pics/2.jpg"));
        studentIcon.setBackground(Color.white);
        studentIcon.setOpaque(true);
        professorIcon = new JLabel(new ImageIcon("./pics/3.jpg"));
        professorIcon.setBackground(Color.white);
        professorIcon.setOpaque(true);

        studentLabel = new JLabel("Add A Student");
        studentLabel.setBackground(Color.ORANGE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        studentLabel.setBorder(border);
        studentLabel.setOpaque(true);
        studentLabel.setFont(new Font("serif", Font.BOLD, 20));
        studentLabel.setHorizontalAlignment(SwingConstants.CENTER);

        professorLabel = new JLabel("Add A Professor");
        professorLabel.setBackground(Color.ORANGE);
        professorLabel.setBorder(border);
        professorLabel.setOpaque(true);
        professorLabel.setFont(new Font("serif", Font.BOLD, 20));
        professorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        studentUsername = new JTextField();
        studentPassword = new JPasswordField();

        professorUsername = new JTextField();
        professorPassword = new JPasswordField();

        studentUsernameLabel = new JLabel(" Username: ");
        studentUsernameLabel.setBackground(Color.orange);
        studentUsernameLabel.setOpaque(true);

        studentPasswordLabel = new JLabel(" Password: ");
        studentPasswordLabel.setBackground(Color.orange);
        studentPasswordLabel.setOpaque(true);

        professorPasswordLabel = new JLabel(" Password: ");
        professorPasswordLabel.setBackground(Color.orange);
        professorPasswordLabel.setOpaque(true);

        professorUsernameLabel = new JLabel(" Username: ");
        professorUsernameLabel.setBackground(Color.orange);
        professorUsernameLabel.setOpaque(true);

        studentAddButton = new JButton("Add");
        professorAddButton = new JButton("Add");

        Handler handler = new Handler();

        studentUsername.addActionListener(handler);
        studentPassword.addActionListener(handler);
        studentAddButton.addActionListener(handler);

        professorUsername.addActionListener(handler);
        professorPassword.addActionListener(handler);
        professorAddButton.addActionListener(handler);


        addComponent(studentLabel, 2 ,2, 5 ,2);
        addComponent(studentIcon, 2 ,4, 5 ,17);
        addComponent(studentUsernameLabel, 2 ,21, 2 ,2);
        addComponent(studentUsername, 4 ,21, 3 ,2);
        addComponent(studentPasswordLabel, 2 ,23, 2 ,2);
        addComponent(studentPassword, 4 ,23, 3 ,2);
        addComponent(studentAddButton, 2 ,25, 5 ,2);

        addComponent(professorLabel, 15 ,2, 5 ,2);
        addComponent(professorIcon, 15 ,4, 5 ,17);
        addComponent(professorUsernameLabel, 15 ,21, 2 ,2);
        addComponent(professorUsername, 17 ,21, 3 ,2);
        addComponent(professorPasswordLabel, 15 ,23, 2 ,2);
        addComponent(professorPassword, 17 ,23, 3 ,2);
        addComponent(professorAddButton, 15 ,25, 5 ,2);

    }



    private class Handler implements ActionListener{

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == studentAddButton || e.getSource() == studentUsername || e.getSource() == studentPassword){
                String username = studentUsername.getText();
                String password = String.valueOf(studentPassword.getPassword());
                getController().addStudent(username, password);
            }
            else if(e.getSource() == professorAddButton || e.getSource() == professorUsername || e.getSource() == professorPassword){
                String username = studentUsername.getText();
                String password = String.valueOf(studentPassword.getPassword());
                getController().addProfessor(username, password);
            }
        }
    }
}
