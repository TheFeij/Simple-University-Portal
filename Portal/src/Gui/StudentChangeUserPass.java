package Gui;

import com.Feij.Controller;

public class StudentChangeUserPass extends StudentPage {

    private ChangePassword passwordPanel;
    private ChangeUsername usernamePanel;

    public StudentChangeUserPass(Controller controller, String username){
        super(username);

        passwordPanel = new ChangePassword("Student", username);
        passwordPanel.setController(controller);
        usernamePanel = new ChangeUsername("Student", username, this);
        usernamePanel.setController(controller);

        addComponent(usernamePanel,5, 9, 6, 9);
        addComponent(passwordPanel,13, 9, 6, 9);

    }
}
