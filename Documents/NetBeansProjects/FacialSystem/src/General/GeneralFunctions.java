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

/**
 * @author Harvey
 */
public class GeneralFunctions {
    private static DatabaseHelper database;
    private static String query;

    @NotNull
    public static String toSentenceCase(@NotNull String string) {
        //return a string that starts with an uppercase letter: sentence case that is.
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
             query ="select * from lecturer where Account_Matricule='"+name+"'";
            ArrayList re = database.ExecuteQuery(query);
            User.setFirst_Name(re.get(1).toString());
            User.setLast_Name(re.get(2).toString());
            User.setMatricule(name);
            User.setQualification(re.get(3).toString());
            User.setSpeciality(re.get(4).toString());
            User.setTelephone(re.get(5).toString());
            query="select Course_Course_ID from account_has_course where Account_Matricule='"+name+"'";
            ArrayList Courses = database.ExecuteQuery(query);
            User.setCourses(Courses);
        } catch (SQLException ex) {
            Logger.getLogger(GeneralFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
    }

    
}
