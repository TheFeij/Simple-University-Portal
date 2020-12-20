package com.Feij;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class represents a professor in a university
 *
 * @author Feij
 * @since 2020.12.19
 * @version 0.0
 */
public class Professor {

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
     * A method to set username
     * @param newUsername username of the professor
     */
    public void setUsername(String newUsername){
        this.username = username;
    }

    /**
     * A method to set password
     * @param newPassword password of the professor
     */
    public void setPassword(String newPassword){
        this.password = password;
    }

    /**
     * A method to add a new class
     */
    public void createClass(Class newClass){
        classes.add(newClass);
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
     * A method to give grade to a student in a specified class
     * @param studentUsername username of the student
     * @param className name of the class
     * @param grade grade of the student for that class
     * @return true if the grade set is successfull and false
     * if student doesnt exist in that class or that class
     * doesnt exist
     */
    public boolean giveGrade(String studentUsername, String className, int grade){
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
