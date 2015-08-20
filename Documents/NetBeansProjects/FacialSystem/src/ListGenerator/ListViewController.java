/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListGenerator;

import General.ControlledScreen;
import General.ScreensController;
import java.net.URL;
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
    private TableView<?> listTable;
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
    private TableColumn name;
    @FXML
    private TableColumn matric;
    @FXML
    private TableColumn stTime;
    @FXML
    private TableColumn etTime;
    @FXML
    private TableColumn code;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filler = FXCollections.observableArrayList();
        listPopulator populate = new listPopulator();
        name.setCellFactory(new PropertyValueFactory("Name"));
        matric.setCellFactory(new PropertyValueFactory("Matricule"));
        code.setCellFactory(new PropertyValueFactory("Course_Code"));
        etTime.setCellFactory(new PropertyValueFactory("End_time"));
        stTime.setCellFactory(new PropertyValueFactory("Start_time"));
        state.setCellFactory(new PropertyValueFactory("status"));
        
        
        populate.Course_Code.setValue("lllll");
        populate.End_time.setValue("22:00");
        populate.Matricule.setValue("FE11A166");
        populate.status.setValue("Present");
        populate.Start_time.setValue("00:00");
        populate.Name.setValue("Embeded Systems");
        filler.add(populate);
        listTable.getItems().addAll(filler);
        //listTable.getItems().addAll(filler);
        // TODO
    }

    @FXML
    private void getList(ActionEvent event) {
    }

    @Override
    public void setScreenParent(ScreensController pane) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void printList(ActionEvent event) {
    }

}
