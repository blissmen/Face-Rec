/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListGenerator;

import javafx.beans.property.SimpleStringProperty;

public class listPopulator {

    public SimpleStringProperty Name = new SimpleStringProperty();
    public SimpleStringProperty Matricule = new SimpleStringProperty();
    public SimpleStringProperty StartTime = new SimpleStringProperty();
    public SimpleStringProperty EndTime = new SimpleStringProperty();
    public SimpleStringProperty Status = new SimpleStringProperty();

    public String getName() {
        return Name.get();
    }

    public String getMatricule() {
        return Matricule.get();
    }

    public String getStartTime() {
        return StartTime.get();
    }

    public String getEndTime() {
        return EndTime.get();
    }

    public String getStatus() {
        return Status.get();
    }

}
