/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListGenerator;

import General.ControlledScreen;
import General.GeneralFunctions;
import General.ScreensController;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Caleb
 */
public class ListViewController implements Initializable, ControlledScreen {

    @FXML
    private TableView listTable;
    @FXML
    private TextField courseCode;
    @FXML
    private Button submitBtn;
    @FXML
    private DatePicker date;
    @FXML
    private Button print;
    ObservableList filler;
    @FXML
    private TableColumn state;

    @FXML
    private TableColumn matric;
    @FXML
    private TableColumn stTime;
    @FXML
    private TableColumn etTime;
    @FXML
    private TableColumn code;
    General.GeneralFunctions function;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filler = FXCollections.observableArrayList();
        function = new GeneralFunctions();
        matric.setCellValueFactory(new PropertyValueFactory("Matricule"));
        code.setCellValueFactory(new PropertyValueFactory("Course_Code"));
        etTime.setCellValueFactory(new PropertyValueFactory("EndTime"));
        stTime.setCellValueFactory(new PropertyValueFactory("StartTime"));
        state.setCellValueFactory(new PropertyValueFactory("Status"));
        code.setCellValueFactory(new PropertyValueFactory("Name"));

        listTable.getItems().addAll(filler);
     
    }

    @FXML
    private void getList(ActionEvent event) {
        Date dateofClass = Date.valueOf(date.getValue());
        String cCode = this.courseCode.getText();
        int Class;
        filler.clear();
        Class = function.getClassID(cCode, dateofClass);
        ArrayList matricules = GeneralFunctions.getMatriculeOnAttndancList(cCode, Class);
        ArrayList registerdMatricules = GeneralFunctions.getClasslist(cCode);
        String Cours = function.getCourseName(cCode);
        ArrayList Times = function.getTimes(Class);
        String status;
        listTable.setItems(filler);
        for (int i = 0; i < registerdMatricules.size(); i++) {
            listPopulator list = new listPopulator();
            if (matricules.contains(registerdMatricules.get(i))) {
                status = "present";
            } else {
                status = "absent";
            }

            System.out.println(i + "i" + registerdMatricules.get(i));
            list.EndTime.set(Times.get(1).toString());
            list.Matricule.set(registerdMatricules.get(i).toString());
            list.StartTime.set(Times.get(0).toString());
            list.Status.set(status);
            list.Name.set(Cours);
            filler.add(list);
        }

        listTable.setItems(filler);
    }

    @Override
    public void setScreenParent(ScreensController pane) {

    }

    @FXML
    private void printList(ActionEvent event) {
    }

}
