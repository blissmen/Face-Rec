/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListGenerator;

import javafx.beans.property.StringProperty;

public class listPopulator {

    public StringProperty Name;
    public StringProperty Matricule;
    public StringProperty Start_time;
    public StringProperty End_time;
    public StringProperty Course_Code;
    public StringProperty status;

    public listPopulator() {

    }

    public StringProperty getName() {
        return Name;
    }

    public void setName(StringProperty Name) {
        this.Name = Name;
    }

    public StringProperty getMatricule() {
        return Matricule;
    }

    public void setMatricule(StringProperty Matricule) {
        this.Matricule = Matricule;
    }

    public StringProperty getStart_time() {
        return Start_time;
    }

    public void setStart_time(StringProperty Start_time) {
        this.Start_time = Start_time;
    }

    public StringProperty getEnd_time() {
        return End_time;
    }

    public void setEnd_time(StringProperty End_time) {
        this.End_time = End_time;
    }

    public StringProperty getCourse_Code() {
        return Course_Code;
    }

    public void setCourse_Code(StringProperty Course_Code) {
        this.Course_Code = Course_Code;
    }

    public StringProperty getStatus() {
        return status;
    }

    public void setStatus(StringProperty status) {
        this.status = status;
    }

}
