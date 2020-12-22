package Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * this class represents a professor in a university
 *
 * @author Feij
 * @since 2020.12.19
 * @version 0.0
 */
public class Professor implements Serializable {

    //username of the professor
    private String username;
    //password of the professor
    private String password;
    //total credits of professor
    private int credits;
    //list of professor's all classes
    private ArrayList<Class> classes;

    /**
     * A constructor t create a new professor
     * @param username username of the professor
     * @param password password of the professor
     */
    public Professor(String username, String  password){
        this.username = username;
        this.password = password;
        credits = 0;
        classes = new ArrayList<Class>();

    }


    /**
     * A method to get password of the professor
     * @return passsword of the professor
     */
    public String getPassword() {
        return password;
    }

    /**
     * A method to set username
     * @param newUsername username of the professor
     */
    public void changeUsername(String newUsername){
        this.username = newUsername;
        for(Class clss : classes)
            clss.setProfessor(newUsername);
    }

    /**
     * A method to set password
     * @param newPassword password of the professor
     */
    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    /**
     * A method to add a new class
     */
    public void createClass(Class newClass){
        classes.add(newClass);
    }

    /**
     * A method to get username
     * @return username
     */
    public String getUsername(){
        return username;
    }

    /**
     * A method to get total credits of the professor
     * @return credits ogf the professor
     */
    public int getCredits() {
        return credits;
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
     * A method to remove a class from professor's schedule
     * @param tempClass class to be removed
     */
    public void removeClass(Class tempClass){
        classes.remove(tempClass);
        increaseCredit(-1 * tempClass.getCredits());
    }

    /**
     * A method to give grade to a student in a specified class
     * @param studentUsername username of the student
     * @param className name of the class
     * @param grade grade of the student for that class
     * @return true if the grade set is successfull and false
     * if student doesnt exist in that class or that class
     * doesnt exist
     */
    public boolean giveGrade(String studentUsername, String className, int  grade){
        Class clss = getClass(className);
        if(clss != null){
            Student student = clss.getStudent(studentUsername);
            if(student != null){
                student.setGrade(grade, className);
                return true;
            }
            else
                return false;
        }
        else
            return false;

    }

    /**
     * A method to check if professor has time for a new
     * class or not
     * @param classDay day of the new class
     * @param classTime time of the new class
     * @return true if the new class can be added to professor schedule
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
     * A method to increase total credits of a professor
     * @param credits amount of credits to be added
     */
    public void increaseCredit(int credits){
        this.credits += credits;
    }

    /**
     * A method to add a class to portal
     * @param newClass class to be added
     */
    public void addClass(Class newClass){
        classes.add(newClass);
        increaseCredit(newClass.getCredits());
    }

    /**
     * A method to get information of the classes of the professor
     * @return information of the classes
     */
    public String[][] getClassesInfo(){
        String[][] classesInfo = new String[classes.size()][5];

        for(Class clss : classes){
            classesInfo[classes.indexOf(clss)][0] = clss.getName();
            classesInfo[classes.indexOf(clss)][1] = String.valueOf(clss.getCredits());
            classesInfo[classes.indexOf(clss)][2] = String.valueOf(clss.getCapacity());
            classesInfo[classes.indexOf(clss)][3] = String.valueOf(clss.getNumberOfStudents());
            classesInfo[classes.indexOf(clss)][4] = clss.getTime();
        }

        return classesInfo;
    }
}
