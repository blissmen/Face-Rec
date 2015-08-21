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

import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SettingsController implements Initializable, ControlledScreen {

    @FXML
    private AnchorPane modanchor;
    public static ScreensController SettingsScreenController;
    public static String AdvSetScreen_ID = "AdvancedSets";
    public static String AdvSetScreen_FXM = "/Settings/advancedSets.fxml";
    public static String CameraSetScreen_ID = "CameraSets";
    public static String CameraSetScreen_FXM = "/Settings/CameraSets.fxml";
    public static String ConnectionSetScreen_ID = "ConnectionSets";
    public static String ConnectionSetScreen_FXM = "/Settings/ConnectionSets.fxml";
    public static String NotSetScreen_ID = "NotificationSets";
    public static String NotSetScreen_FXM = "/Settings/NotificationSets.fxml";
    public static String GenSetScreen_ID = "GenSets";
    public static String GenSetScreen_FXM = "/Settings/GenSets.fxml";
    public static String SysSetScreen_ID = "Data";
    public static String SysSetScreen_FXM = "/Settings/Data.fxml";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SettingsScreenController = new ScreensController(modanchor);
        SettingsScreenController.loadScreen(AdvSetScreen_ID, AdvSetScreen_FXM);
        SettingsScreenController.loadScreen(NotSetScreen_ID, NotSetScreen_FXM);
        SettingsScreenController.loadScreen(CameraSetScreen_ID, CameraSetScreen_FXM);
        SettingsScreenController.loadScreen(ConnectionSetScreen_ID, ConnectionSetScreen_FXM);
        SettingsScreenController.loadScreen(GenSetScreen_ID, GenSetScreen_FXM);
        SettingsScreenController.loadScreen(SysSetScreen_ID, SysSetScreen_FXM);

    }

    @FXML
    private void genSet(ActionEvent event) {
        SettingsScreenController.setScreen(GenSetScreen_ID);
    }

    @FXML
    private void CameSets(ActionEvent event) {
        SettingsScreenController.setScreen(CameraSetScreen_ID);
    }

   

    @FXML
    private void advancedSets(ActionEvent event) {
        SettingsScreenController.setScreen(AdvSetScreen_ID);
    }

    @FXML
    private void Notifications(ActionEvent event) {
        SettingsScreenController.setScreen(NotSetScreen_ID);
    }

    @FXML
    private void Connections(ActionEvent event) {
        SettingsScreenController.setScreen(ConnectionSetScreen_ID);
    }

    @Override
    public void setScreenParent(ScreensController pane) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void sysSets(ActionEvent event) {
        SettingsScreenController.setScreen(SysSetScreen_ID);
    }

}
