package Gui;

import Gui.AdminPage;
import Gui.ChangePassword;
import Gui.ChangeUsername;
import com.Feij.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminChangeUserPass extends AdminPage {

    private ChangePassword passwordPanel;
    private ChangeUsername usernamePanel;

    public AdminChangeUserPass(Controller controller, String username){
        super(username);

        passwordPanel = new ChangePassword("Admin", username);
        passwordPanel.setController(controller);
        usernamePanel = new ChangeUsername("Admin", username, this);
        usernamePanel.setController(controller);

        addComponent(usernamePanel,5, 9, 6, 9);
        addComponent(passwordPanel,13, 9, 6, 9);

    }

}
