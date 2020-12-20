package com.Feij;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FoodSchedule extends AdminPage {

    private FoodTableGui foodTable;

    public FoodSchedule(){
        super();
        foodTable = new FoodTableGui();

        addComponent(foodTable, 2, 4, 20, 20);

    }

}
