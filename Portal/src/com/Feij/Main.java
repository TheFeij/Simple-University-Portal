package com.Feij;



public class Main {

    public static void main(String[] args) {

        FrontPage frontPage = new FrontPage();
        frontPage.setVisible(true);

        LoginPage loginPage = new LoginPage();
        loginPage.setLocationRelativeTo(frontPage);
        loginPage.setVisible(true);

        PortalPage portalPage = new PortalPage();
        portalPage.setVisible(true);
    }
}
