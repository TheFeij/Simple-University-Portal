package com.Feij;
import Data.Admin;
import Gui.*;


public class Main {

    public static void main(String[] args) {

        FrontPage frontPage = new FrontPage();
        Admin admin = new Admin();

        Controller controller = new Controller(admin, frontPage);
        frontPage.setController(controller);

    }

}
