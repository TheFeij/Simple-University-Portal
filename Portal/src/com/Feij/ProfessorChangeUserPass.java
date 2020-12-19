package com.Feij;

public class ProfessorChangeUserPass extends ProfessorPage {

    private ChangePassword passwordPanel;
    private ChangeUsername usernamePanel;

    public ProfessorChangeUserPass(){
        super();

        passwordPanel = new ChangePassword();
        usernamePanel = new ChangeUsername();

        addComponent(usernamePanel,5, 9, 6, 9);
        addComponent(passwordPanel,13, 9, 6, 9);

    }
}
