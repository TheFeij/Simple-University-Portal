package com.Feij;


import Data.Admin;
import Data.Professor;
import Data.Student;
import Gui.FrontPage;
import Gui.LoginPage;
import Gui.ProfessorPage;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        //FrontPage frontPage = new FrontPage();
        //frontPage.setVisible(true);

        //LoginPage loginPage = new LoginPage();
        //loginPage.setLocationRelativeTo(null);
        //loginPage.setVisible(true);

        //PortalPage portalPage = new PortalPage("Admin");
        //portalPage.setName("Ehsan Edalat");
        //portalPage.setVisible(true);

        //AddingUsersPage addingUsersPage = new AddingUsersPage();
        //addingUsersPage.setVisible(true);
        //addingUsersPage.setName("Ehsan Edalat");

        //AdminPage adminPage = new AdminPage();
        //adminPage.setVisible(true);

        //FoodSchedule foodSchedule = new FoodSchedule();
        //foodSchedule.setVisible(true);

        //StudentPage studentPage = new StudentPage();
        //studentPage.setVisible(true);

        //IncreaseBalance increaseBalance = new IncreaseBalance();
        //increaseBalance.setVisible(true);

        //ReserveFood reserveFood = new ReserveFood();
        //reserveFood.setVisible(true);

        //AdminLists adminLists = new AdminLists();
        //adminLists.setVisible(true);

        //ProfessorPage professorPage = new ProfessorPage();
        //professorPage.setVisible(true);

        //RemoveClass removeClass = new RemoveClass();
        //removeClass.setVisible(true);

        //AddClass addClass = new AddClass();
        //addClass.setVisible(true);

        //AdminChangeUserPass adminChangeUserPass = new AdminChangeUserPass();
        //adminChangeUserPass.setVisible(true);

        //StudentChangeUserPass studentChangeUserPass = new StudentChangeUserPass();
        //studentChangeUserPass.setVisible(true);

        //ProfessorChangeUserPass professorChangeUserPass = new ProfessorChangeUserPass();
        //professorChangeUserPass.setVisible(true);


        FrontPage frontPage = new FrontPage();
        Admin admin = new Admin();

        Professor professor = new Professor("ali", "asad");
        admin.addProfessor(professor);

        Controller controller = new Controller(frontPage, admin);
        frontPage.setController(controller);

    }
}
