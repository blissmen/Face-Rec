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
    static String First_Name;
    static String Qualification;
    static String Speciality;
    static String Telephone;
    static ArrayList Courses;
    static ArrayList Levels;
    
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
