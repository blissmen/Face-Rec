/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialsystem;

import General.ControlledScreen;
import General.DatabaseHelper;
import General.ScreensController;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class LoginController implements Initializable,ControlledScreen {
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
    private DatabaseHelper database;
    @FXML
    private Label status;
    @FXML
    private TextField InitcourseCode;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         database  = new DatabaseHelper();
    logScreen = new ScreensController(login);
    logScreen.loadScreen(interface_ID, interface_FXML);
//     logScreen.loadScreen(Sreen5_ID, Sreen5_FXML);
    
        // TODO
    }    
    
    @FXML
    private void verifyCreds(MouseEvent event) {
        
    String name = username.getText().trim().replace("'", "\'");
    String pass  = password.getText();
    String query ="select * from Account where Matricule= '"+name+"' and password='"+pass+"'";
        try {
            ArrayList res = database.ExecuteQuery(query);
            if(res.size()<2)
                status.setVisible(true);
            else
            {
               General.GeneralFunctions.FetchData(name);
               logScreen.setScreen(interface_ID);
               General.GeneralFunctions.getCourseClassID(InitcourseCode.getText());
               General.GeneralFunctions.getCourseName(InitcourseCode.getText());
               TeacherInfoController.teach.Populate();
               User.setCurrentCourse(InitcourseCode.getText());
               
               
               
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setScreenParent(ScreensController pane) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
