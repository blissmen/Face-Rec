/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialsystem;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class User {
    static String Matricule;
    static String CurrentCourse;
    static int ClasID;
     static String First_Name;
    static String Qualification;
    static String Speciality;
    static String Telephone;
    static ArrayList Courses = new ArrayList();
    static ArrayList Levels;
    public static int getClasID() {
        return ClasID;
    }

    public static void setClasID(int ClasID) {
        User.ClasID = ClasID;
        TeacherInfoController.cl.setID(ClasID);
    }
    public static String getCurrentCourse() {
        return CurrentCourse;
    }

    public static void setCurrentCourse(String CurrentCourse) {
        
        User.CurrentCourse = CurrentCourse;
    }

    public static void setID(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    public User() {
    }
    static String Last_Name;

    public static String getMatricule() {
        return Matricule;
    }

    public static void setMatricule(String Matricule) {
        User.Matricule = Matricule;
    }

    public static String getFirst_Name() {
        return First_Name;
    }

    public static void setFirst_Name(String First_Name) {
        User.First_Name = First_Name;
    }

    public static String getLast_Name() {
        return Last_Name;
    }

    public static void setLast_Name(String Last_Name) {
        User.Last_Name = Last_Name;
    }

    public static String getQualification() {
        return Qualification;
    }

    public static void setQualification(String Qualification) {
        User.Qualification = Qualification;
    }

    public static String getSpeciality() {
        return Speciality;
    }

    public static void setSpeciality(String Speciality) {
        User.Speciality = Speciality;
    }

    public static String getTelephone() {
        return Telephone;
    }

    public static void setTelephone(String Telephone) {
        User.Telephone = Telephone;
    }

    public static ArrayList getCourses() {
        return Courses;
    }

    public static void setCourses(ArrayList Courses) {
        User.Courses = Courses;
    }

    public static ArrayList getLevels() {
        return Levels;
    }

    public static void setLevels(ArrayList Levels) {
        User.Levels = Levels;
    }
  
    
}
