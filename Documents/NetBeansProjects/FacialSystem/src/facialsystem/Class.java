/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialsystem;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Class {
   static int ID;
   static Date date;
   static String COURSE;
   static String COURSEName;
   static String startTime;
   static String endTime;
   
    public static Date getDate() {
        return date;
    }

    public static void setDate(Date date) {
        Class.date = date;
    }
   

    public static String getCOURSEName() {
        return COURSEName;
    }

    public static void setCOURSEName(String COURSEName) {
        Class.COURSEName = COURSEName;
    }

    public static String getStartTime() {
        return startTime;
    }

    public static void setStartTime(String startTime) {
        Class.startTime = startTime;
    }

    public static String getEndTime() {
        return endTime;
    }

    public static void setEndTime(String endTime) {
        Class.endTime = endTime;
    }
    public static int getID() {
        return ID;
    }

    public static void setID(int IDT) {
        ID = IDT;
    }

    public static String getCOURSE() {
        return COURSE;
    }

    public static  void setCOURSE(String COURSET) {
        COURSE = COURSET;
    }
    public void SaveClass()
    {
    String query = "Insert into `class registration`(ID,Lecturer_ID,Start_Time,End_Time,Course_ID,Course_Name,ClassDate) values ("
                + ID + ""
                + ",'" + User.getMatricule() + ""
                + "','" +startTime+ ""
                + "','" +endTime+ ""
                + "','" + COURSE + ""
                + "','" + COURSEName + ""
                + "','" + date + "')"
            ;
 TeacherInfoController.database.Query(query);
        
    }
}
