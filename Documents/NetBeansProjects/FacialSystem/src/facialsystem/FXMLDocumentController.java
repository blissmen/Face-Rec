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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable,ControlledScreen {
    @FXML
    private Label label;
    @FXML
    private AnchorPane Tab;
    private TextField id;
    private TextField st;
    private ComboBox<?> CC;
    private TextField ET;
    private TextField CN;
    private String lect_id;
    private String Start_time;
    private String End_time;
    private String Course_id;
    private String Course_Name;
    private String query;
    public static ScreensController mainScreen;
     public static ScreensController ListScreen;
     
    public static String Screen_ID="Ca_view";
    public static String Screen_FXML="/facialsystem/Ca_view.fxml";
    public static String Screen4_ID="listView";
    public static String Screen4_FXML="/ListGenerator/listView.fxml";
    public static String Sreen5_ID="login";
    public static String Sreen5_FXML="/facialsystem/login.fxml";
    public static String Screen2_ID ="teacherInfo";
    public static String Screen2_FXML ="/facialsystem/teacherInfo.fxml";
    public static String Screen3_ID ="settings";
    public static String Screen3_FXML ="/Settings/settings.fxml";
    @FXML
    private Button CaButton;
    @FXML
    private Button set;
    @FXML
    private Button register;
    private DatabaseHelper database;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mainScreen = new ScreensController(Tab);
        ListScreen = new ScreensController(Tab);
        //database = new DatabaseHelper();
        mainScreen.loadScreen(Screen2_ID, Screen2_FXML);
        mainScreen.loadScreen(Screen_ID, Screen_FXML);
        mainScreen.setScreen(Screen2_ID);
        mainScreen.loadScreen(Screen3_ID, Screen3_FXML);
        ListScreen.loadScreen(Screen4_ID, Screen4_FXML);
        
       
       }
    
    public static void loadListView(String Course)
            {
            ListScreen.setScreen(Screen4_ID);
            
            }
    public static void loadLogin()
            {
            mainScreen.loadScreen(Screen_ID, Sreen5_ID);
            mainScreen.setScreen(Sreen5_ID);
            }
 
   
    @FXML
    private void loadCamera(ActionEvent event) {
    mainScreen.setScreen(Screen_ID);
    
    }

    @FXML
    private void settings(ActionEvent event) {
       mainScreen.setScreen(Screen3_ID);
    }

    @FXML
    private void RegisterClass(ActionEvent event) {
        mainScreen.setScreen(Screen2_ID);
    }

    @Override
    public void setScreenParent(ScreensController pane) {
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
