package com.Feij;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FoodSchedule extends AdminPage {

    private FoodTable foodTable;

    public FoodSchedule(){
        super();
        foodTable = new FoodTable();

        addComponent(foodTable, 2, 4, 20, 20);

    }

}
