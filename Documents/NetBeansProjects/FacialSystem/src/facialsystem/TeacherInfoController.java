/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialsystem;

import General.ControlledScreen;
import General.DatabaseHelper;
import General.ScreensController;
import com.sun.glass.ui.Application;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TeacherInfoController implements Initializable, ControlledScreen {
    private static ArrayList res;

    @FXML
    private Label id;
    @FXML
    private TextField st;

    @FXML
    private TextField ET;
    @FXML
    private ImageView T_img;
    @FXML
    private Label greet_txt;
    static TeacherData teach;
    @FXML
    private Button en_cl;
    @FXML
    private Button class_lst;
    @FXML
    private Label CN;

    protected static  DatabaseHelper database;
    @FXML
    private Label nameTag;
    @FXML
    private Button start;
    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Loading ..............");  // TODO
        teach = new TeacherData();
        date.setShowWeekNumbers(true);
        database = new DatabaseHelper();
        //fullname.setText("Hello");
    }

    @FXML
    private void EndClass(ActionEvent event) {
        Class cl =new Class();
        Class.setEndTime(ET.getText());
        Class.setID(User.getClasID());
        Class.setStartTime(st.getText());
        Class.setDate(Date.valueOf(date.getValue()));
        Class.setCOURSE(User.getCurrentCourse());
        cl.SaveClass();
        Application mine =Application.GetApplication();
        mine.terminate();
       
        FXMLDocumentController.loadLogin();
        }

    @FXML
    private void viewList(ActionEvent event) {
        FXMLDocumentController.loadListView("");
    }

    @Override
    public void setScreenParent(ScreensController pane) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void populateTeacherInfo() {

        //CN.setText("Hellos");
        System.out.println(User.getFirst_Name());
        nameTag.setText(User.getFirst_Name());
        id.setText(""+Class.getID());
        CN.setText(Class.getCOURSEName());
       
          
    }

    protected  static void getCN() {
        String query = "select Course_Name from course where Course_ID='" + User.getCurrentCourse()+ "'";
        System.out.println(query);
       
        try {
             res = database.ExecuteQuery(query);
            Class.setCOURSEName(res.get(0).toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(TeacherInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void startClass(ActionEvent event) {
        en_cl.setDisable(false);
    }

    class TeacherData {

        public TeacherData() {
        }

        public void Populate() {
            populateTeacherInfo();
        }
    }
}
