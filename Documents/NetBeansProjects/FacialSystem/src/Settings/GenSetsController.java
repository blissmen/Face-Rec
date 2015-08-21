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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class GenSetsController implements Initializable, ControlledScreen {
    @FXML
    private CheckBox saingav;
    @FXML
    private Hyperlink changeD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void Changepic(ActionEvent event) {
    }

    @Override
    public void setScreenParent(ScreensController pane) 
    {
    }



    @FXML
    private void Show(ActionEvent event)
    {
    }

    @FXML
    private void SaveOnExit(ActionEvent event)
    {
    }

    @FXML
    private void attendanceatEnd(ActionEvent event)
    {
    }

    @FXML
    private void attendanceatStart(ActionEvent event) {
    }

    @FXML
    private void Save(MouseEvent event) {
    }
    
}
