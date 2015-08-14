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
import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private static ScreensController mainScreen;
    public static String Screen_ID="Ca_view";
    public static String Screen_FXML="/facialsystem/Ca_view.fxml";
    public static String Screen4_ID="listView";
    public static String Screen4_FXML="/facialsystem/listView.fxml";
    public static String Screen2_ID ="teacherInfo";
    public static String Screen2_FXML ="/facialsystem/teacherInfo.fxml";
    public static String Screen3_ID ="settings";
    public static String Screen3_FXML ="/facialsystem/settings.fxml";
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
        database = new DatabaseHelper();
        mainScreen.loadScreen(Screen2_ID, Screen2_FXML);
        mainScreen.loadScreen(Screen_ID, Screen_FXML);
        mainScreen.setScreen(Screen2_ID);
        mainScreen.loadScreen(Screen3_ID, Screen3_FXML);
        mainScreen.loadScreen(Screen4_ID, Screen4_FXML);
       }
    public static void loadListView(String Course)
            {
            mainScreen.setScreen(Screen4_ID);
            
            }
    private void EndClass(ActionEvent event) {
        Calendar cal = Calendar.getInstance(Locale.getDefault());
        Date dt = new Date(cal.getTime().getTime());
        System.out.println(dt.toString());
        //System.out.println(cal.getTime().toString());
        Class.setID( id.getText());
        Class.setStartTime(st.getText());
        Class.setCOURSEName(CN.getText());
        Class.setEndTime(ET.getText());
        Class.setCOURSE(CC.getSelectionModel().getSelectedItem().toString());
        saveClass();
        id.setText("");
        st.setText("");
        ET.setText("");
        CC.getSelectionModel().clearSelection();
        CN.setText("");
        
        
    }


    private void saveClass() {
       Class.setCOURSE(Course_id);
       Class.setID(lect_id);
        
        
        query="insert into `Class registration`(Lecturer_ID,Start_Time,End_Time,Course_ID,Course_Name) values ('"+Class.getID()+"','"+Class.getStartTime()+"','"+Class.getEndTime()+"','"+Class.getCOURSE()+"','"+Class.getCOURSEName()+"')";
       database.Query(query);
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
