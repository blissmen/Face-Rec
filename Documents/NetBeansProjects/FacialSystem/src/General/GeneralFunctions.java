/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import facialsystem.TeacherInfoController;
import facialsystem.User;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyEvent;
import org.controlsfx.dialog.Dialogs;
import org.jetbrains.annotations.NotNull;

public class GeneralFunctions {

    private static DatabaseHelper database;
    private static String query;
    private static ArrayList result;
    private static Integer ClassID;

    @NotNull
    public static String toSentenceCase(@NotNull String string) {
        String[] temp;
        temp = string.toLowerCase().split("[ ]");
        String retrn = "";
        for (String next : temp) {
            retrn = retrn.concat(next.substring(0, 1).toUpperCase().
                    concat(next.substring(1))).concat(" ");
        }
        retrn = retrn.trim();
        return retrn;
    }

    public static void handleNumbers(@NotNull KeyEvent event) {
        char c = event.getCharacter().charAt(0);
        if (!((c >= '0') && (c <= '9') || (c == java.awt.event.KeyEvent.VK_TAB
                || c == java.awt.event.KeyEvent.VK_ENTER || c == java.awt.event.KeyEvent.VK_BACK_SPACE))) {
            Dialogs.create().title("Wrong Input").
                    message("You must enter only numbers here.").
                    showInformation();
            event.consume();
        }
    }

    public static void FetchData(String name) {
        try {
            database = new DatabaseHelper();
            query = "select * from lecturer where Account_Matricule='" + name + "'";
            ArrayList re = database.ExecuteQuery(query);
            User.setFirst_Name(re.get(1).toString());
            User.setLast_Name(re.get(2).toString());
            User.setMatricule(name);
            User.setQualification(re.get(3).toString());
            User.setSpeciality(re.get(4).toString());
            User.setTelephone(re.get(5).toString());
            query = "select Course_Code from lecturer_has_course where Lecturer_Account_Matricule='" + name + "'";
            ArrayList Courses = database.ExecuteQuery(query);
            User.setCourses(Courses);
        } catch (SQLException ex) {
         //   Logger.getLogger(GeneralFunctions.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Logger Not a lecturer");
        }

    }

    public static void getCourseClassID(String text) {
        query = "select ID from `class registration` where Course_Code='" + text + "'";
        try {
            ArrayList rey = database.ExecuteQuery(query);
            User.setClasID(Integer.parseInt(rey.get(0).toString()) + 1);

        } catch (Exception ex) {
            User.setClasID(1);
        }

    }
    private String Coursename;

    public String getCourseName(String text) {
        query = "select Course_Name from course where Code ='" + text + "'";
        try {
            ArrayList rey = database.ExecuteQuery(query);
            User.setCurrentCourse(rey.get(0).toString());
            Coursename = rey.get(0).toString();
            System.out.println("from DB " + rey.get(0).toString());
        } catch (Exception ex) {
            User.setCurrentCourse("Course  Does Not Exist");

        }
         return Coursename;
    }
    private String courseName;

    public void saveStuClass(String mat) {
        System.out.println(" matriculesss gotten " + mat);
        if (mat != null) {
            System.out.println(" matricule gotten " + mat);
            if (mat.length() > 6) {
                mat = mat.substring(0, (mat.length() - 6));

                query = "insert into attendancelist(Account_Matricule,Course_Code,Class_ID) values ('" + mat + ""
                        + "','" + TeacherInfoController.cl.getCOURSE() + ""
                        + "'," + User.getClasID() + ")";
                try {
                    database.Query(query);
                } catch (Exception ds) {
                         System.out.println(mat + " Already Ticked Present");
            
                }
            }
            else{
                System.out.println("Error in value gotten for matricule "+mat);
            }
        }
    }

    public static ArrayList getClasslist(String course) {

        query = " select  Student_Matricule   from student_has_course where Course_Code='" + course + "'";
        try {
            result = database.ExecuteQuery(query);
        } catch (Exception sd) {
            System.out.println("No Student registred for d course");
            Dialogs.create().message("No Student registred for this course").showInformation();
       
        }
        return result;
    }

    public static ArrayList getMatriculeOnAttndancList(String course, int clasId) {
        query = " select  Account_Matricule from attendancelist where Course_Code='" + course + "' and Class_ID=" + clasId;
        try {
            System.out.println(query);
            result = database.ExecuteQuery(query);
            System.out.println(" this are"+result.get(0));
        } catch (Exception sd) {
            System.out.println("No Student registred for d course");
           Dialogs.create().message("No Student was available for this course").showError();
        }
        return result;
    }

    public  int getClassID(String course, Date date) {
        query = " select  ID from `class registration` where course_Code='" +course +"' and Date='"+date+"'";
        try {
            result = database.ExecuteQuery(query);
            ClassID = Integer.valueOf(result.get(0).toString());
        } catch (Exception sd) {
            System.out.println("the specified Class did not hold on this Date");
            Dialogs.create().message("No Records of this Class Exist Ensure the date is correct Likewise Course Code").showError();
            
        }
        
        return ClassID;
    }
    
    public ArrayList getTimes(int ClasssId)
    {
    query= "select Start_Time,End_Time from `class registration` where ID= "+ClasssId;
        try {
            result = database.ExecuteQuery(query);
        } catch (SQLException ex) {
            System.out.println("Class doesnt Exist");
            Dialogs.create().message("No Class took place on that Date").showError();
        }
    return result;
    }
    }


