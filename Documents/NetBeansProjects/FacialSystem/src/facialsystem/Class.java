/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialsystem;

/**
 *
 * @author USER
 */
public class Class {
   static String ID;
   static String COURSE;
   static String COURSEName;
   static String startTime;
   static String endTime;

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
    public static String getID() {
        return ID;
    }

    public static void setID(String IDT) {
        ID = IDT;
    }

    public static String getCOURSE() {
        return COURSE;
    }

    public static  void setCOURSE(String COURSET) {
        COURSE = COURSET;
    }
}
