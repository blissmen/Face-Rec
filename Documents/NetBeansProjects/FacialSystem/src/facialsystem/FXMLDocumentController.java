/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialsystem;

import General.DatabaseHelper;
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
public class FXMLDocumentController implements Initializable {
    DatabaseHelper database;
    @FXML
    private Label label;
    @FXML
    private AnchorPane Tab;
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
    private String lect_id;
    private String Start_time;
    private String End_time;
    private String Course_id;
    private String Course_Name;
    private String query;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database = new DatabaseHelper();
    }

    @FXML
    private void EndClass(ActionEvent event) {
        Calendar cal = Calendar.getInstance(Locale.getDefault());
        Date dt = new Date(cal.getTime().getTime());
        System.out.println(dt.toString());
        //System.out.println(cal.getTime().toString());
        lect_id= id.getText();
        Start_time=st.getText();
        End_time=ET.getText();
        Course_id= CC.getSelectionModel().getSelectedItem().toString();
        Course_Name = CN.getText();
        saveClass(lect_id,dt.toString()+" "+Start_time,dt.toString()+" "+End_time,Course_id,Course_Name);
        
        
        
    }

    @FXML
    private void viewList(ActionEvent event) {
    }

    private void saveClass(String lect_id, String Start_time, String End_time, String Course_id, String Course_Name) {
       query="insert into `Class registration`(Lecturer_ID,Start_Time,End_Time,Course_ID,Course_Name) values ('"+lect_id+"','"+Start_time+"','"+End_time+"','"+Course_id+"','"+Course_Name+"')";
       database.Query(query);
    }
    
}
