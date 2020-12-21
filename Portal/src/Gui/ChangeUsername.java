package Gui;

import com.Feij.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeUsername extends JPanel {

    private final GridBagLayout layout;
    private final GridBagConstraints constraints;
    private JTextField newUsername;
    private JButton changeUsername;
    private String type;
    private Controller controller;
    private String username;
    private PortalPage portalPage;

    public ChangeUsername(String type, String username, PortalPage portalPage){
        super();
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        setLayout(layout);

        this.username = username;
        this.type = type;
        this.portalPage = portalPage;

        JLabel info = new JLabel("Please Enter Your New Username");
        info.setBackground(Color.ORANGE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        info.setBorder(border);
        info.setOpaque(true);
        info.setFont(new Font("serif", Font.BOLD, 20));
        info.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel userLabel;
        userLabel = new JLabel(" New Username:");
        newUsername = new JTextField();
        changeUsername = new JButton("Change");

        Handler handler = new Handler();

        newUsername.addActionListener(handler);
        changeUsername.addActionListener(handler);

        addComponent(info,0, 0, 6, 3);
        addComponent(userLabel,0, 3, 2, 2);
        addComponent(newUsername,2, 3, 4, 2);
        addComponent(changeUsername,0, 5, 6, 2);

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

    private class Handler implements ActionListener {


        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String newusername = newUsername.getText();
            Page page = null;
            if(type.equals("Admin")){
                if(controller.adminChangeUsername(newusername))
                    page = new AdminChangeUserPass(controller, newusername);
            }
            else if(type.equals("Professor")){
                if(controller.professorChangeUsername(newusername, username)){
                    page = new ProfessorChangeUserPass(controller, newusername);
                }
            }
            else if(type.equals("Student")){
                if(controller.studentChangeUsername(newusername, username)){
                    page = new StudentChangeUserPass(controller,newusername);
                }
            }
            changePage(page);
        }

        public void changePage(Page page){
            page.setLocationRelativeTo(null);
            page.setController(controller);
            portalPage.setVisible(false);
            page.setVisible(true);
        }
    }
}
