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
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ConnectionSetsController implements Initializable,ControlledScreen {
    @FXML
    private TextField mobileHost;
    @FXML
    private TextField newHost;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @Override
    public void setScreenParent(ScreensController pane) {
   }

    @FXML
    private void UseMobile(ActionEvent event) {
        mobileHost.setDisable(false);
        mobileHost.setTooltip(new Tooltip("Enter The Ip address of the phone"));
    }

    @FXML
    private void Submit(ActionEvent event) {
    }
    
}
