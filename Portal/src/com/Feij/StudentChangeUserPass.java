package com.Feij;

public class StudentChangeUserPass extends StudentPage {

    private ChangePassword passwordPanel;
    private ChangeUsername usernamePanel;

    public StudentChangeUserPass(){
        super();

        passwordPanel = new ChangePassword();
        usernamePanel = new ChangeUsername();

        addComponent(usernamePanel,5, 9, 6, 9);
        addComponent(passwordPanel,13, 9, 6, 9);

    }
}
