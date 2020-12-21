package Gui;

import com.Feij.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword extends JPanel {

    private final GridBagLayout layout;
    private final GridBagConstraints constraints;
    private JPasswordField newPassword;
    private JButton changePassword;
    private String type;
    private Controller controller;
    private String username;



    public ChangePassword(String type, String username){
        super();
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        setLayout(layout);

        this.username = username;
        this.type = type;

        JLabel info = new JLabel("Please Enter Your New Password");
        info.setBackground(Color.ORANGE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        info.setBorder(border);
        info.setOpaque(true);
        info.setFont(new Font("serif", Font.BOLD, 20));
        info.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel passLabel;
        passLabel = new JLabel(" New Password:");
        newPassword = new JPasswordField();
        changePassword = new JButton("Change");

        Handler handler = new Handler();
        newPassword.addActionListener(handler);
        changePassword.addActionListener(handler);

        addComponent(info,0, 0, 6, 3);
        addComponent(passLabel,0, 3, 2, 2);
        addComponent(newPassword,2, 3, 4, 2);
        addComponent(changePassword,0, 5, 6, 2);

    }

    /**
     * A method to set controller
     * @param controller controller to be set
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     *
     * @param component component to be added
     * @param row number of the row
     * @param column number of the column
     * @param width width of the component
     * @param height height of the component
     */
    public void addComponent(Component component, int column, int row, int width, int height){
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        layout.setConstraints(component, constraints);
        add(component);
    }


    private class Handler implements ActionListener{


        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String password = String.valueOf(newPassword.getPassword());
            if(type.equals("Admin")){
                controller.adminChangePassword(password);
            }
            else if(type.equals("Professor")){
                controller.professorChangePassword(username, password);
            }
            else if(type.equals("Student")){
                controller.studentChangePassword(username, password);
            }
            newPassword.setText(null);
        }
    }
}
