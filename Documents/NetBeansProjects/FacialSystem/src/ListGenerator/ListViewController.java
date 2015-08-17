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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Caleb
 */
public class ListViewController implements Initializable,ControlledScreen {
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listPopulator populate= new listPopulator();
        listTable.setItems(null);
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
