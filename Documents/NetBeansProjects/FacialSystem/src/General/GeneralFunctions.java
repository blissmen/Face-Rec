/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import facialsystem.User;
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
            query = "select Course_Course_ID from account_has_course where Account_Matricule='" + name + "'";
            ArrayList Courses = database.ExecuteQuery(query);
            User.setCourses(Courses);
        } catch (SQLException ex) {
            Logger.getLogger(GeneralFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void getCourseClassID(String text) {
        query = "select ID from `class registration` where Course_ID='" + text + "'";
        try {
            ArrayList rey = database.ExecuteQuery(query);
            User.setClasID(Integer.parseInt(rey.get(0).toString()) + 1);

        } catch (Exception ex) {
            User.setClasID(1);
         }

    }

    public static void getCourseName(String text) {
        query = "select Course_Name from course where Course_ID='" + text + "'";
        try {
            ArrayList rey = database.ExecuteQuery(query);
            User.setCurrentCourse(rey.get(0).toString());
            System.out.println("from DB " + rey.get(0).toString());
        } catch (Exception ex) {
           User.setCurrentCourse("Course  Does Not Exist");

        }

    }

    public void saveStuClass(String mat) {
        if (mat != null) {
            mat = mat.substring(0, (mat.length() - 6));

            query = "insert into attendacelist(Account_Matricule,Course_Course_ID,`Class registration_id`) values ('" + mat + ""
                    + "','" + User.getCurrentCourse() + ""
                    + "',4)";
            database.Query(query);
        }
    }

}
