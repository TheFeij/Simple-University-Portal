package com.Feij;

public class AdminChangeUserPass extends AdminPage {

    private ChangePassword passwordPanel;
    private ChangeUsername usernamePanel;

    public AdminChangeUserPass(){
        super();

        passwordPanel = new ChangePassword();
        usernamePanel = new ChangeUsername();

        addComponent(usernamePanel,5, 9, 6, 9);
        addComponent(passwordPanel,13, 9, 6, 9);

    }
}
