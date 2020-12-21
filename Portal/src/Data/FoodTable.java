package Data;

/**
 * This class represents Food schedule of the university.
 * except for fridays every day university gives food.
 * each day has lunch and dinner and each of them has to
 * types of food.
 */
public class FoodTable {

    //food table, first dimension represents days, second one represents
    //either it is lunch or dinner and the third dimension indicates name of
    //the food.
    private String[][][] table;


    /**
     * A constructor to create a new food table
     */
    public FoodTable() {
        table = new String[6][2][2];

        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 2; k++)
                    table[i][j][k] = "";
    }


    /**
     * A method to set a cell in the food table
     * @param day day of the food
     * @param meal lunch or dinner
     * @param type first food or second food
     * @param food name of the food
     */
    public void setFood(String day, String meal, String type, String food){

        int[] code = encode(day, meal, type);

        int i = code[0];
        int j = code[1];
        int k = code[2];

        table[i][j][k] = food;
    }

    /**
     * A method to encode a meal into numbers
     * @param day day of the food
     * @param meal lunch or dinner
     * @param type first food or second food
     * @return encoded meal
     */
    public int[] encode(String day, String meal, String type){
        int i = 0;
        int j = 0;
        int k = 0;

        if (day.equals("Saturday"))
            i = 0;
        else if(day.equals("Sunday"))
            i = 1;
        else if(day.equals("Monday"))
            i = 2;
        else if(day.equals("Tuesday"))
            i = 3;
        else if(day.equals("Wednesday"))
            i = 4;
        else if(day.equals("Thursday"))
            i = 5;

        if(meal.equals("Lunch"))
            j = 0;
        else if(meal.equals("Dinner"))
            j = 1;

        if(type.equals("First Food"))
            k = 0;
        else if(type.equals("Second Food"))
            k = 1;

        int[] code = new int[3];
        code[0] = i;
        code[1]  = j;
        code[2]  = k;

        return code;

    }

    /**
     * A method to check if the day is full or not
     *
     * @param day day of the food
     * @param meal lunch or dinner
     * @param type first food or second food
     * @return 0 if the day is free. 1 if the day is reserved
     * and student cannot reserve on that day and meal but admin can
     * add a new food type. -1 if none of these conditions or satisfied
     */
    public int checkDay(String day, String meal, String type){
        int[] code = encode(day, meal, type);

        int i = code[0];
        int j = code[1];
        int k = code[2];

        if(table[i][j][0].equals("") && table[i][j][1].equals(""))
            return 0;   //student can reserve food on this day
        else if(table[i][j][k].equals(""))
            return 1;   //only admin can add a food in this condition
        return -1;
    }

    /**
     * A method to get food table
     * @return food table
     */
    public String[][][] getTable() {
        return table;
    }

    /**
     * A method to reset Table status
     */
    public void resetTable(){
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 2; k++)
                    table[i][j][k] = "";
    }
}
