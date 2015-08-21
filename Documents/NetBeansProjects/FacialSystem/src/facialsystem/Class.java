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

    public static String STATUS = "ended";

    public static String getSTATUS() {
        return STATUS;
    }

    public static void setSTATUS(String STATUS) {
        Class.STATUS = STATUS;
    }
    public int ID;
    public Date date;
    public String COURSE;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCOURSE() {
        return COURSE;
    }

    public void setCOURSE(String COURSE) {
        this.COURSE = COURSE;
    }

    public String getLecturerID() {
        return LecturerID;
    }

    public void setLecturerID(String LecturerID) {
        this.LecturerID = LecturerID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String LecturerID;
    public String startTime;
    public String endTime;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date1) {
        this.date = date1;
    }

    public void SaveClass() {
        String query = "Insert into `class registration` (ID,Lecturer_ID,Start_Time,End_Time,Course_Code,Date) values ("
                + this.getID() + ""
                + ",'" + this.getLecturerID() + ""
                + "','" + this.getStartTime() + ""
                + "','" + this.getEndTime() + ""
                + "','" + this.getCOURSE() + ""
                + "','" + this.getDate() + "')";
        TeacherInfoController.database.Query(query);

    }
}
