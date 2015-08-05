/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialsystem;

import General.ControlledScreen;
import General.ScreensController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TeacherInfoController implements Initializable,ControlledScreen {
    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private TextField st;
    @FXML
    private ComboBox<?> CC;
    @FXML
    private TextField ET;
    @FXML
    private ImageView T_img;
    @FXML
    private Label greet_txt;
    @FXML
    private Button en_cl;
    @FXML
    private Button class_lst;
    @FXML
    private TextField CN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void EndClass(ActionEvent event) {
    }

    @FXML
    private void viewList(ActionEvent event) {
    }

    @Override
    public void setScreenParent(ScreensController pane) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
