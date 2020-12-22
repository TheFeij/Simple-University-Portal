package Data;

import java.io.Serializable;
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
public class Student implements Serializable {

    //username of the student
    private String username;
    //password of the student
    private String password;
    //total credits of a student
    private int credits;
    //balance of the student
    private int balance;
    //average grade of the student
    private Integer averageGrade;
    //grades of the student for each class
    private HashMap<Class, Integer> grades;
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
        grades = new HashMap<Class, Integer>();
        this.username = username;
        this.password = password;
        credits = 0;
        balance = 0;
        averageGrade = -1;
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
        this.username = newUsername;
    }

    /**
     * A method to set password
     * @param newPassword password of the student
     */
    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    /**
     * A method to get food table of the student
     * @return food table of the student
     */
    public FoodTable getFoodTable() {
        return foodTable;
    }

    /**
     * A method to increase number of credits of the student
     * @param credits credits to be added
     */
    public void addCredit(int credits){
        this.credits += credits;
    }

    /**
     * A method to decrease student's credits by specified amount
     * @param credits
     */
    private void decreaseCredits(int credits){
        this.credits -= credits;
    }

    /**
     * A method to calculate average grade of student
     * @return
     */
    public void calculateAverageGrade(){
        int sum = 0;
        int markedCredits = 0;
        for(Map.Entry mapElement : grades.entrySet()){
            Integer grade = (Integer) mapElement.getValue();
            if(grade != -1){
                Class clss = (Class)mapElement.getKey();
                markedCredits += clss.getCredits();
                sum += (clss.getCredits()) * grade;
            }
        }
        if(markedCredits == 0){
            averageGrade = -1;
        }
        else
            averageGrade = (sum / markedCredits);
    }

    /**
     * A method to set grade of a class
     * @param grade grade to be set
     * @param className name of the class
     */
    public void setGrade(int grade, String className){
        grades.put(getClass(className), grade);
    }


    /**
     * A method to reserve food
     * @param day day of the food
     * @param meal lunch or dinner
     * @param type first food or second food
     * @param food name of the food
     * @return true if food is set and false
     * if the food cannot be set
     */
    public boolean setFood(int day, int meal, int type, String food){
        return foodTable.setStudentFood(day, meal,food,type);
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
    public boolean checkClassTime(String classDay, String classTime){
        for(Class clss : classes){
            if(clss.getDay().equals(classDay)){
                if(clss.getTime().equals(classTime)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * A method to get a class
     * @param className name of the class
     * @return if it exists returns the class if not
     * returns null
     */
    public Class getClass(String className){
        for(Class clss  : classes){
            if(clss.getName().equals(className))
                return clss;
        }
        return null;
    }

    /**
     * A method to remove a class from students schedule
     * @param tempClass class to be removed
     */
    public void removeClass(Class tempClass){
        classes.remove(tempClass);
        decreaseCredits(tempClass.getCredits());
    }

    /**
     * A method to check if student can have class or not
     * @param classCredits credits of the class we want to add
     * @return true if student can have the class
     */
    public boolean canAddClass(int classCredits){
        calculateAverageGrade();
        if(averageGrade < 17){
            return this.credits + classCredits <= 20;
        }
        else{
            return this.credits + classCredits <= 24;
        }
    }

    /**
     * A method to add a class
     * @param newClass class to be added
     */
    public void addClass(Class newClass){
        classes.add(newClass);
        grades.put(newClass, -1);
    }

    /**
     * A methof to check if student has the mentioned class or not
     * @param className nam eof the class to be checked
     * @return true if student has the mentioned class
     */
    public boolean hasClass(String className){
        for(Class clss : classes){
            if(clss.getName().equals(className))
                return true;
        }
        return false;
    }

    public int getClassGrade(String className){
        return grades.get(className);
    }
}
