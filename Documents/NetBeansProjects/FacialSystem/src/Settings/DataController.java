/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import General.ControlledScreen;
import General.ScreensController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DataController implements Initializable,ControlledScreen {
    @FXML
    private CheckBox restore;
    @FXML
    private Button restore_btn;
    @FXML
    private ComboBox<?> dateList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backup(ActionEvent event) {
    }

    @FXML
    private void StartRestore(ActionEvent event) {
    }

    @FXML
    private void Restore(ActionEvent event) {
    }

    @FXML
    private void SelectRestoreDate(ActionEvent event) {
    }

    @Override
    public void setScreenParent(ScreensController pane) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
