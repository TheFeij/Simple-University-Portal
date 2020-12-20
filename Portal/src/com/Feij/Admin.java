package com.Feij;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents an admin in university portal system
 *
 * @author Feij
 * @since 2020.12.20
 * @version 0.0
 */
public class Admin {

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
     * @param username username of the admin
     * @param password password of the admin
     */
    public Admin(String username, String password){

        this.username = username;
        this.password = password;
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
        this.username = username;
    }

    /**
     * A method to set password
     * @param newPassword password of the admin
     */
    public void setPassword(String newPassword){
        this.password = password;
    }

    /**
     * A method to set food
     * @param day day of the food
     * @param meal lunch or dinner
     * @param type first food or second food
     * @param food name of the food
     */
    public void setFood(String day, String meal, String type, String food){
        foodTable.setFood(day, meal, type, food);
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
}
