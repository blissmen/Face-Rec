/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialsystem;

import General.DatabaseHelper;
import General.ScreensController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class LoginController implements Initializable {
    @FXML
    private AnchorPane login;
    private static ScreensController logScreen;
    public static String interface_ID="FXMLDocument";
    public static String interface_FXML="/facialsystem/FXMLDocument.fxml";
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button logingbtn;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DatabaseHelper database  = new DatabaseHelper();
    logScreen = new ScreensController(login);
    logScreen.loadScreen(interface_ID, interface_FXML);
    
        // TODO
    }    

    private void validateCreds(ActionEvent event) {
       logScreen.setScreen(interface_ID);
        
    }

    @FXML
    private void verifyCreds(ActionEvent event) {
    }

    @FXML
    private void verifyCreds(MouseEvent event) {
    }
    
}
