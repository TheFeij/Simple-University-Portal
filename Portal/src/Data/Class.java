package Data;

import Data.Student;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a class in  university. it has a name, a professor,
 *  a list of students, a capacity, time, and a number of credits
 *
 * @author Feij
 * @since 2020.12.19
 * @version 0.0
 */
public class Class implements Serializable {

    //name of the class
    private String name;
    //name of the professor
    private String professor;
    //the time class is being held
    private String time;
    //the day class is being held
    private String day;
    //number of credits this class has
    private int credits;
    //capacity of the class
    private int capacity;
    //list of all students in the class
    private ArrayList<Student> students;


    /**
     * A constructor to create a new class
     * @param name name of the class
     * @param professor professor of the class
     * @param time time of the class
     * @param day day of the class
     * @param capacity capacity of the class
     * @param credits number of the credits this class has
     */
    public Class(String name, String professor, String time,String day, int capacity, int credits){

        students = new ArrayList<Student>();
        this.name = name;
        this.professor = professor;
        this.time = time;
        this.day = day;
        this.capacity = capacity;
        this.credits = credits;

    }

    /**
     * A method to get name of the class
     * @return name of the class
     */
    public String getName() {
        return name;
    }

    /**
     * A method to set professor name
     * @param professor name of the professor
     */
    public void setProfessor(String professor) {
        this.professor = professor;
    }


    /**
     * A method to get day of the class
     * @return day of the class
     */
    public String getDay() {
        return day;
    }


    /**
     * A method to get name of the professor
     * @return name of the professor
     */
    public String getProfessor() {
        return professor;
    }

    /**
     * A method to get number of students in the class
     * @return number of students in the class
     */
    public int getNumberOfStudents(){
        return students.size();
    }

    /**
     * A method to get time of the class
     * @return time of the class
     */
    public String getTime() {
        return time;
    }

    /**
     * A method to get capacity of a class
     * @return capacity of the class
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * A method to get number of the credits of the class
     * @return number of the credits of the class
     */
    public int getCredits() {
        return credits;
    }

    /**
     * A method to get list of all students in the class
     * @return list of all students in the class
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * A method to get a student of the class
     * @param username username of the student
     * @return if exists returns student if not
     * returns null
     */
    public Student getStudent(String username){
        for(Student student : students){
            if(student.getUsername().equals(username))
                return student;
        }
        return null;
    }

    /**
     * A method to close the class
     */
    public void closeClass(){
        for(Student student : students){
            student.removeClass(this);
        }
    }

    /**
     * A method to check if class has space to add a student or not
     * @return true if class has space to add a student
     */
    public boolean hasSpace(){
        return students.size() < capacity;
    }

    /**
     * A method to add a student to class
     * @param student student to be added
     */
    public void addStudent(Student student){
        students.add(student);
    }

    /**
     * A method to check if student exist in class or not
     * @param username username of the student
     * @return true if student exists in class
     */
    public boolean studentExists(String username){
        for(Student student : students){
            if(student.getUsername().equals(username))
                return true;
        }
        return false;
    }

}
