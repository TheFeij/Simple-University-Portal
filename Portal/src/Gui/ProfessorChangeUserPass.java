package Gui;

import com.Feij.Controller;

public class ProfessorChangeUserPass extends ProfessorPage {

    private ChangePassword passwordPanel;
    private ChangeUsername usernamePanel;

    public ProfessorChangeUserPass(Controller controller, String username){
        super(username);

        passwordPanel = new ChangePassword("Professor", username);
        passwordPanel.setController(controller);
        usernamePanel = new ChangeUsername("Professor", username, this);
        usernamePanel.setController(controller);

        addComponent(usernamePanel,5, 9, 6, 9);
        addComponent(passwordPanel,13, 9, 6, 9);

    }
}
