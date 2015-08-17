/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListGenerator;

import javafx.beans.property.SimpleStringProperty;

public class listPopulator {

    public static SimpleStringProperty Name;
    public static SimpleStringProperty Matricule;
    public static SimpleStringProperty Start_time;
    public static SimpleStringProperty End_time;
    public static SimpleStringProperty Course_Code;
    public static SimpleStringProperty status;

    public static SimpleStringProperty getStatus() {
        return status;
    }

    public static void setStatus(SimpleStringProperty status) {
        listPopulator.status = status;
    }
    
    
    public static SimpleStringProperty getName() {
        return Name;
    }

    public static void setName(SimpleStringProperty Name) {
        listPopulator.Name = Name;
    }

    public static SimpleStringProperty getMatricule() {
        return Matricule;
    }

    public static void setMatricule(SimpleStringProperty Matricule) {
        listPopulator.Matricule = Matricule;
    }

    public static SimpleStringProperty getStart_time() {
        return Start_time;
    }

    public static void setStart_time(SimpleStringProperty Start_time) {
        listPopulator.Start_time = Start_time;
    }

    public static SimpleStringProperty getEnd_time() {
        return End_time;
    }

    public static void setEnd_time(SimpleStringProperty End_time) {
        listPopulator.End_time = End_time;
    }

    public static SimpleStringProperty getCourse_Code() {
        return Course_Code;
    }

    public static void setCourse_Code(SimpleStringProperty Course_Code) {
        listPopulator.Course_Code = Course_Code;
    }

}
