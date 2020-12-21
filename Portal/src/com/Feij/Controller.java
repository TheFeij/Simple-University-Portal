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
     * @param frontPage front page of the portal
     * @param admin admin of the portal
     */
    public Controller(FrontPage frontPage, Admin admin){
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
            professor.setUsername(newUsername);
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
            studentsInfo[students.indexOf(student)][2] = String.valueOf(student.getAverageGrade());
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
        String[][] classesInfo = new String[classes.size()][6];

        for(Class clss : classes){
            classesInfo[classes.indexOf(clss)][0] = clss.getName();
            classesInfo[classes.indexOf(clss)][1] = String.valueOf(clss.getCredits());
            classesInfo[classes.indexOf(clss)][2] = clss.getProfessor();
            classesInfo[classes.indexOf(clss)][3] = String.valueOf(clss.getCapacity());
            classesInfo[classes.indexOf(clss)][4] = String.valueOf(clss.getNumberOfStudents());
            classesInfo[classes.indexOf(clss)][5] = clss.getTimeOfClass();
        }

        return classesInfo;
    }


    /**
     * A method to get username of admin
     * @return username of admin
     */
    public String getAdminUsername(){
        return admin.getUsername();
    }

}
