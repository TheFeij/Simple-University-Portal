package Gui;

public class FoodSchedule extends AdminPage {

    private FoodTableGui foodTable;

    public FoodSchedule(String username){
        super(username);
        foodTable = new FoodTableGui();

        addComponent(foodTable, 2, 4, 20, 20);

    }

}
