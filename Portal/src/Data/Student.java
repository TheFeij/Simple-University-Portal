package Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a student in a university.
 *
 * @author Feij
 * @since 2020.12.19
 * @version 0.0
 */
public class Student {

    //username of the student
    private String username;
    //password of the student
    private String password;
    //total credits of a student
    private int credits;
    //balance of the student
    private int balance;
    //average grade of the student
    private int averageGrade;
    //grades of the student for each class
    private HashMap<String, Integer> grades;
    //list of student's all classes
    private ArrayList<Class> classes;
    //food table of the student
    private FoodTable foodTable;


    /**
     * A constructor to create a new Student
     * @param username username of the student
     * @param password password of the students
     */
    public Student(String username, String password){
        foodTable = new FoodTable();
        classes = new ArrayList<Class>();
        grades = new HashMap<String, Integer>();
        this.username = username;
        this.password = password;
        credits = 0;
        balance = 0;
        averageGrade = 0;
    }

    /**
     * A method to get password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * A method to get credits of the student
     * @return credits of the student
     */
    public int getCredits() {
        return credits;
    }

    /**
     * A method to get balance of the student
     * @return balance of the student
     */
    public int getBalance() {
        return balance;
    }

    /**
     * A method to get average grade of the student
     * @return average grade of the student
     */
    public int getAverageGrade() {
        return averageGrade;
    }

    /**
     * A method to set username
     * @param newUsername username of the student
     */
    public void setUsername(String newUsername){
        this.username = username;
    }

    /**
     * A method to set password
     * @param newPassword password of the student
     */
    public void setPassword(String newPassword){
        this.password = password;
    }

    /**
     * A method to get food table of the student
     * @return food table of the student
     */
    public FoodTable getFoodTable() {
        return foodTable;
    }

    /**
     * A method to add a new class
     * @param newClass the class to be added
     * @return true if class added successfully
     */
    public boolean addClass(Class newClass){
        if(addCredit(newClass.getCredits())){
            classes.add(newClass);
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * A method to increase number of credits of the student
     * @param credits credits to be added
     * @return true if credits added successfully
     */
    public boolean addCredit(int credits){
        calculateAverageGrade();
        if(averageGrade >= 17){
            if(this.credits + credits <= 24){
                this.credits += credits;
                return true;
            }
            else
                return false;
        }
        else{
            if(this.credits + credits <= 20){
                this.credits += credits;
                return true;
            }
            else
                return false;
        }
    }

    /**
     * A method to calculate average grade of student
     * @return
     */
    public void calculateAverageGrade(){
        int sum = 0;
        for(Map.Entry mapElement : grades.entrySet()){
            sum += (Integer) mapElement.getValue();
        }
        averageGrade =  sum / grades.size();
    }

    /**
     * A method to set grade of a class
     * @param grade grade to be set
     * @param className name of the class
     * @return true if grade set successfully and false if
     * class does not exist in student class list
     */
    public boolean setGrade(int grade, String className){
        if(grades.containsKey(className)){
            grades.put(className, grade);
            return true;
        }
        else
            return false;
    }

    /**
     * A method to reserve food
     * @param day day of the food
     * @param meal lunch or dinner
     * @param type first food or second food
     * @param food name of the food
     */
    public void setFood(String day, String meal, String type, String food){
        foodTable.setFood(day, meal, type, food);
    }

    /**
     * A method to increase balance
     * @param inputMoney amount of money to be added to the balance
     */
    public void increaseBalance(int inputMoney){
        balance += inputMoney;
    }

    /**
     * A method to get student username
     * @return username of the student
     */
    public String getUsername() {
        return username;
    }

    /**
     * A method to check if student has time for a new
     * class or not
     * @param classDay day of the new class
     * @param classTime time of the new class
     * @return true if the new class can be added to students schedule
     */
    public boolean checkClassTime(String classDay, int classTime){
        for(Class clss : classes){
            if(clss.getDay().equals(classDay)){
                if(clss.getTime() == classTime){
                    return false;
                }
            }
        }
        return true;
    }
}
