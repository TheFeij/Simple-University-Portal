package com.Feij;


import Data.Admin;
import Data.Class;
import Data.Professor;
import Data.Student;
import Gui.FrontPage;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class acts as a connection between gui classes and data.
 *
 * @author Feij
 * @since 2020.12.21
 * @version 0.0
 */
public class Controller {

    private FrontPage frontPage;
    private Admin admin;


    /**
     * A constructor to create a new Controller
     * @param admin admin
     * @param frontPage front page of the portal
     */
    public Controller(Admin admin, FrontPage frontPage){
        this.admin = admin;
        this.frontPage = frontPage;
        frontPage.setVisible(true);
    }


    /**
     * A method to check if admin login information is correct or not
     * @param username user input username
     * @param password user input password
     * @return true if information is correct
     */
    public boolean adminLoginCheck(String username, String password){
        String adminUsername = admin.getUsername();
        String adminPassword = admin.getPassword();

        return username.equals(adminUsername) && password.equals(adminPassword);
    }

    /**
     * A method to check if professor login information is correct or not
     * @param username user input username
     * @param password user input password
     * @return true if information is correct
     */
    public boolean professorLoginCheck(String username, String password){

        Professor professor = admin.getProfessor(username);
        if(professor != null){
            String  professorPassword = professor.getPassword();
            return password.equals(professorPassword);
        }
        else
            return false;

    }

    /**
     * A method to check if student login information is correct or not
     * @param username user input username
     * @param password user input password
     * @return true if information is correct
     */
    public boolean studentLoginCheck(String username, String password){

        Student student = admin.getStudent(username);
        if(student != null){
            String  studentPassword = student.getPassword();
            return password.equals(studentPassword);
        }
        else
            return false;

    }

    /**
     * A method to change admin password
     * @param password new password
     */
    public void adminChangePassword(String password){
        if(checkPassword(password)){
            admin.setPassword(password);
            JOptionPane.showMessageDialog(null, "Password changed successfully!",
                    "Message!", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Password should be at least 8 characters",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * A method to change professor password
     * @param password new password
     */
    public void professorChangePassword(String username, String password){
        Professor professor = admin.getProfessor(username);
        if(checkPassword(password)){
            professor.setPassword(password);
            JOptionPane.showMessageDialog(null, "Password changed successfully!",
                    "Message!", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Password should be at least 8 characters",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * A method to change student password
     * @param password new password
     */
    public void studentChangePassword(String username, String password){
        Student student = admin.getStudent(username);
        if(checkPassword(password)){
            student.setPassword(password);
            JOptionPane.showMessageDialog(null, "Password changed successfully!",
                    "Message!", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Password should be at least 8 characters",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * A method to change admin username
     * @param username new username
     * @return true if username changed successfully
     */
    public boolean adminChangeUsername(String username){
        if(checkUsername(username)){
            admin.setUsername(username);
            JOptionPane.showMessageDialog(null, "Username changed successfully!",
                    "Message!", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Username should be at least 5 characters",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    /**
     * A method to change professor username
     * @param newUsername new username
     * @param oldUsername old username
     * @return true if username changed successfully
     */
    public boolean professorChangeUsername(String newUsername, String oldUsername){
        Professor professor = admin.getProfessor(oldUsername);
        if(checkUsername(newUsername)){
            professor.changeUsername(newUsername);
            JOptionPane.showMessageDialog(null, "Username changed successfully!",
                    "Message!", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid Inputs",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    /**
     * A method to change student username
     * @param newUsername new username
     * @param oldUsername old username
     * @return true if username changed successfully
     */
    public boolean studentChangeUsername(String newUsername, String oldUsername){
        Student student = admin.getStudent(oldUsername);
        if(checkUsername(newUsername)){
            student.setUsername(newUsername);
            JOptionPane.showMessageDialog(null, "Username changed successfully!",
                    "Message!", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Username should be at least 5 characters",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }


    /**
     * A method to check if username is valid or not
     * @param username username
     * @return true if username is valid
     */
    public boolean checkUsername(String username){
        return username.length() >= 5;
    }

    /**
     *
     * A method to check if password is valid or not
     * @param password password
     * @return true if password id valid or not
     */
    public boolean checkPassword(String password){
        return password.length() >= 8;
    }

    /**
     * A method to add a student
     * @param username username of the student
     * @param password password of the student
     */
    public void addStudent(String username, String password){
        if(checkUsername(username) && checkPassword(password)){
            if(admin.getStudent(username) == null){
                Student student = new Student(username, password);
                admin.addStudent(student);
                JOptionPane.showMessageDialog(null, "Student added successfully!",
                        "Message!", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "Username already exists!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Username or Password is not valid",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * A method to increase student balance
     * @param username username of the student
     * @param money money to be added
     */
    public void increseBalance(String username, int money){
        Student student = admin.getStudent(username);
        student.increaseBalance(money);
    }

    /**
     * A method to get balance eof a student
     * @param username username of the students
     * @return balance of the student
     */
    public int getBalance(String username){
        Student student = admin.getStudent(username);
        return student.getBalance();
    }

    /**
     * A method to add a professor
     * @param username username of the professor
     * @param password password of the professor
     */
    public void addProfessor(String username, String password){
        if(checkUsername(username) && checkPassword(password)){
            if(admin.getProfessor(username) == null){
                Professor professor = new Professor(username, password);
                admin.addProfessor(professor);
                JOptionPane.showMessageDialog(null, "Professor added successfully!",
                        "Message!", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "Username already exists!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Username or Password is not valid",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * A method to get information of the students in portal
     * @return information of the students
     */
    public String[][] getStudentsInfo(){
        ArrayList<Student> students = admin.getAllStudents();
        String[][] studentsInfo = new String[students.size()][5];

        for(Student student : students){
            studentsInfo[students.indexOf(student)][0] = student.getUsername();
            studentsInfo[students.indexOf(student)][1] = student.getPassword();
            int averageGrade = student.getAverageGrade();
            if(averageGrade == -1)
                studentsInfo[students.indexOf(student)][2] = "UnMarked";
            else
                studentsInfo[students.indexOf(student)][2] = String.valueOf(averageGrade);
            studentsInfo[students.indexOf(student)][3] = String.valueOf(student.getCredits());
            studentsInfo[students.indexOf(student)][4] = String.valueOf(student.getBalance());
        }

        return studentsInfo;
    }

    /**
     * A method to get information of the professors in portal
     * @return information of the professors
     */
    public String[][] getProfessorsInfo(){
        ArrayList<Professor> professors = admin.getAllProfessors();
        String[][] professorsInfo = new String[professors.size()][3];

        for(Professor professor : professors){
            professorsInfo[professors.indexOf(professor)][0] = professor.getUsername();
            professorsInfo[professors.indexOf(professor)][1] = professor.getPassword();
            professorsInfo[professors.indexOf(professor)][2] = String.valueOf(professor.getCredits());
        }

        return professorsInfo;
    }

    /**
     * A method to get information of the classes in portal
     * @return information of the classes
     */
    public String[][] getClassesInfo(){
        ArrayList<Class> classes = admin.getAllClasses();
        String[][] classesInfo = new String[classes.size()][7];

        for(Class clss : classes){
            classesInfo[classes.indexOf(clss)][0] = clss.getName();
            classesInfo[classes.indexOf(clss)][1] = String.valueOf(clss.getCredits());
            classesInfo[classes.indexOf(clss)][2] = clss.getProfessor();
            classesInfo[classes.indexOf(clss)][3] = String.valueOf(clss.getCapacity());
            classesInfo[classes.indexOf(clss)][4] = String.valueOf(clss.getNumberOfStudents());
            classesInfo[classes.indexOf(clss)][5] = clss.getDay();
            classesInfo[classes.indexOf(clss)][6] = clss.getTime();
        }

        return classesInfo;
    }

    /**
     * A method to get information of professors classes
     * @param username username of the professor
     * @return information of professors classes
     */
    public String[][] getProfessorClassesInfo(String username){
        Professor professor = admin.getProfessor(username);
        return professor.getClassesInfo();
    }


    /**
     * A method to get username of admin
     * @return username of admin
     */
    public String getAdminUsername(){
        return admin.getUsername();
    }

    public void addClass(String professorUsername, String name, int credits, int capacity,
                         String time, String day){
        if(name.startsWith(" ")  || capacity < 15 || capacity > 80){
            JOptionPane.showMessageDialog(null, "Invalid Inputs!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(admin.getClass(name) == null){
            Professor professor = admin.getProfessor(professorUsername);
            if(professor.checkClassTime(day, time)){
                Class newClass = new Class(name, professorUsername, time, day, capacity, credits);
                admin.addClass(newClass);
                professor.addClass(newClass);
                JOptionPane.showMessageDialog(null, "Class added!",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Professor already has a class on that time",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Class names already exists!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * A method to close a class from professors schedule
     * @param professorUsername username of the professor
     * @param className name of the class to be removed
     */
    public void removeAClass(String professorUsername, String className){
        Professor professor = admin.getProfessor(professorUsername);
        Class tempClass = professor.getClass(className);
        if(tempClass != null){
            admin.removeClass(tempClass);
            professor.removeClass(tempClass);
            tempClass.closeClass();
            JOptionPane.showMessageDialog(null, "Class removed!",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Class name does not exist in professor's schedule",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }


    /**
     * A method to add a student to a class
     * @param studentUsername student username
     * @param className name of the class to be added
     */
    public void addStudentToClass(String studentUsername, String className){
        Class tempClass = admin.getClass(className);
        Student student = admin.getStudent(studentUsername);

        if(tempClass != null){
            if(student.hasClass(tempClass.getName())){
                JOptionPane.showMessageDialog(null, "You already have this class!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            }
            if(tempClass.hasSpace()){
                if(student.canAddClass(tempClass.getCredits())){
                    if(student.checkClassTime(tempClass.getDay(), tempClass.getTime())){
                        tempClass.addStudent(student);
                        student.addClass(tempClass);
                        JOptionPane.showMessageDialog(null, "Class added!",
                                "Warning!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "You dont have time for this class!",
                                "Warning!", JOptionPane.WARNING_MESSAGE);

                }
                else{
                    JOptionPane.showMessageDialog(null, "You cannot have more credits!",
                            "Warning!", JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Class is full!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Class does not exist!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * A method to check if the mentioned class exists or not
     * @param className name of the class
     * @return true if class exists
     */
    public boolean classExists(String className){
        return admin.getClass(className) != null;
    }

    /**
     * A method to check if the mentioned student exists or not
     * @param username username of the student
     * @return true if class exists
     */
    public boolean studentExists(String username){
        return admin.getStudent(username) != null;
    }


    /**
     * A method to get information of the students in  a class
     * @param className name of the class
     * @return information of the students in the class
     */
    public String[][] getClassStudentsInfo(String className){
        Class tempClass = admin.getClass(className);
        ArrayList<Student> students = tempClass.getStudents();
        String[][] info = new String[students.size()][2];

        for(Student student : students){
            info[students.indexOf(student)][0] = student.getUsername();
            int grade = student.getClassGrade(className);
            if(grade == -1)
                info[students.indexOf(student)][1] = "UnMarked";
            else
                info[students.indexOf(student)][1] = String.valueOf(grade);
        }
        return info;
    }

    /**
     * A method to give student grade
     * @param className name of the class
     * @param studentUsername username of the student
     * @param grade grade of the student
     */
    public void giveGrade(String className, String studentUsername, int grade){
        Class tempClass = admin.getClass(className);
        if(tempClass.studentExists(studentUsername)){
            Student student = admin.getStudent(studentUsername);
            student.setGrade(grade, className);
            student.calculateAverageGrade();
        }
        else
            JOptionPane.showMessageDialog(null, "student does not exists in class!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);

    }

    /**
     * A method to set a food in weekly food table
     */
    public void setAdminFoodTable(String food, String day, String meal){
        if(admin.setFood(day, meal, food)){
            JOptionPane.showMessageDialog(null, "food added to the table!",
                    "Warning!", JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "food schedule for this day has already been set",
                    "Warning!", JOptionPane.WARNING_MESSAGE);

    }

    /**
     * A method to get food table of admin
     * @return food table of admin
     */
    public String[][][] getAdminFoodTable(){
        return admin.getFoodTable().getTable();
    }

    /**
     * A method to reserve food for a student
     * @param username username of the student
     * @param food food to be reserved
     * @param day day of the food
     * @param meal lunch or dinner
     * @param type first food or last food
     * @return true if reservation was successful
     */
    public boolean studentReserveFood(String username, String food, int day, int meal, int type){
        Student student = admin.getStudent(username);
        String foodName = food.substring(0, food.indexOf("-"));
        int price = Integer.parseInt(food.substring(food.indexOf("-") + 1));
        if(student.getBalance() < price){
            JOptionPane.showMessageDialog(null, "Not enough money!",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(student.setFood(day, meal, type, foodName)){
            student.increaseBalance(-1 * price);
            JOptionPane.showMessageDialog(null, "Food reserved!",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        else
            return false;
    }


    /**
     * A method to get food table of the student
     * @param username username of the student
     * @return student food table information
     */
    public String[][][] getStudentFoodTable(String username){
        return admin.getStudent(username).getFoodTable().getTable();
    }

    /**
     * A method to get Balance of a student
     * @param username username of the student
     * @return balance of the student account
     */
    public int getStudentBalance(String username){
        return admin.getStudent(username).getBalance();
    }

}
