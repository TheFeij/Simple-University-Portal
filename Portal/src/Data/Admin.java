package Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents an admin in university portal system
 *
 * @author Feij
 * @since 2020.12.20
 * @version 0.0
 */
public class Admin implements Serializable {

    //username of the admin
    private String username;
    //password of the admin
    private String password;
    //food table of the week
    private FoodTable foodTable;
    //list of all students in portal
    private ArrayList<Student> allStudents;
    //list of professors in portal
    private ArrayList<Professor> allProfessors;
    //list of all clsses
    private ArrayList<Class> allClasses;


    /**
     * A constructor to create a new admin
     */
    public Admin(){

        this.username ="Admin";
        this.password = "12345678";
        foodTable = new FoodTable();
        allClasses = new ArrayList<Class>();
        allStudents = new ArrayList<Student>();
        allProfessors = new ArrayList<Professor>();
    }



    /**
     * A method to set username
     * @param newUsername username of the admin
     */
    public void setUsername(String newUsername){
        this.username = newUsername;
    }

    /**
     * A method to set password
     * @param newPassword password of the admin
     */
    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    /**
     * A method to set food
     * @param day day of the food
     * @param meal lunch or dinner
     * @param food name of the food
     * @return true if food is set and false
     * if food has already been set for this day
     */
    public boolean setFood(String day, String meal, String food){
        return foodTable.setFood(day, meal, food);
    }

    /**
     * A method to get username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * A method to get password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * A method to receive food schedule of the week
     * @return food table of the week
     */
    public FoodTable getFoodTable() {
        return foodTable;
    }

    /**
     * A method to pass a week this causes the food schedule
     * to reset for new week and all students schedules will
     * reset
     */
    public void endWeek(){
        foodTable.resetTable();

        for(Student student : allStudents)
            student.getFoodTable().resetTable();
    }

    /**
     * A method to add a new student
     * @param student student to be added
     */
    public void addStudent(Student student){
        allStudents.add(student);
    }

    /**
     * A method add a new professor
     * @param professor professor to be added
     */
    public void addProfessor(Professor professor){
        allProfessors.add(professor);
    }

    /**
     * A method to get a student
     * @param studentUsername username of the student
     * @return student we want
     */
    public Student getStudent(String studentUsername){
        for(Student student : allStudents){
            if(student.getUsername().equals(studentUsername))
                return student;
        }
        return null;
    }

    /**
     * A method to get a student
     * @param professorUsername username of the professor
     * @return student we want
     */
    public Professor getProfessor(String professorUsername){
        for(Professor professor : allProfessors){
            if(professor.getUsername().equals(professorUsername))
                return professor;
        }
        return null;
    }

    /**
     * A method to get all students in portal
     * @return list of all students
     */
    public ArrayList<Student> getAllStudents() {
        return allStudents;
    }

    /**
     * A method to get all classes in university
     * @returnlist list of all classes in university
     */
    public ArrayList<Class> getAllClasses() {
        return allClasses;
    }

    /**
     * A method to get all professors in a university
     * @return list of all professors in a university
     */
    public ArrayList<Professor> getAllProfessors() {
        return allProfessors;
    }

    /**
     * A method to add a class to portal
     * @param newClass class to be added
     */
    public void addClass(Class newClass){
        allClasses.add(newClass);
    }

    /**
     * A method to get a class
     * @param className class we want to get
     * @return class and null if class does not exist
     */
    public Class getClass(String className){
        for(Class clss : allClasses){
            if(clss.getName().equals(className))
                return clss;
        }
        return null;
    }

    /**
     * A method to remove a class from portal
     * @param tempClass class to be removed
     */
    public void removeClass(Class tempClass){
        allClasses.remove(tempClass);
    }
}
