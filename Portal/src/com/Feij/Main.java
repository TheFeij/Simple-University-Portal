package com.Feij;



public class Main {

    public static void main(String[] args) {

        FrontPage frontPage = new FrontPage();
        frontPage.setVisible(true);

        LoginPage loginPage = new LoginPage();
        loginPage.setLocationRelativeTo(frontPage);
        loginPage.setVisible(true);

        PortalPage portalPage = new PortalPage("Admin");
        portalPage.setName("Ehsan Edalat");
        portalPage.setVisible(true);

        AddingUsersPage addingUsersPage = new AddingUsersPage();
        addingUsersPage.setVisible(true);
        addingUsersPage.setName("Ehsan Edalat");

        AdminPage adminPage = new AdminPage();
        adminPage.setVisible(true);

        FoodSchedule foodSchedule = new FoodSchedule();
        foodSchedule.setVisible(true);

    }
}
