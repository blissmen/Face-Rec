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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    static TeacherData teach;
    @FXML
    private Button en_cl;
    @FXML
    private Button class_lst;
    @FXML
    private TextField CN;
    @FXML
    private TextField fullname;
    @FXML
    private ComboBox<?> levels;
    private DatabaseHelper database;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Loading ..............");  // TODO
        teach = new TeacherData();
        //fullname.setText("Hello");
    }   
  
    

    @FXML
    private void EndClass(ActionEvent event) {
       String query="Insert into `class registration`(Lecturer_ID,Start_Time,End_Time,Course_ID,Course_Name) values ('"+id.getText()+""
               + "','"+st.getText()+""
               + "','"+ET.getText()+""
               + "','"+CC.getSelectionModel().getSelectedItem()+""
               + "','"+CN.getText()+"')"; 
               database.Query(query);
        
    }

    @FXML
    private void viewList(ActionEvent event) {
      FXMLDocumentController.loadListView("");
    }

    @Override
    public void setScreenParent(ScreensController pane) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public  void populateTeacherInfo() {

        //CN.setText("Hellos");
        System.out.println(User.getFirst_Name());
        fullname.setText(User.getFirst_Name());
        id.setText(User.getMatricule());
        ObservableList courses = FXCollections.observableArrayList();
        courses.addAll(User.getCourses());
        CC.setItems(courses);
    }

    private void loadData(ActionEvent event) {CN.setText("Hello");
    }

    @FXML
    private void getCN(ActionEvent event) {
        String query ="select Course_Name from course where Course_ID='"+CC.getSelectionModel().getSelectedItem().toString()+"'";
        System.out.println(query);
        database = new DatabaseHelper();
        try {
            ArrayList res= database.ExecuteQuery(query);
            CN.setText(res.get(0).toString());
        } catch (SQLException ex) {
            Logger.getLogger(TeacherInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      class TeacherData
            {
                  
                public  TeacherData()
                {}
                public  void Populate()
                {
                populateTeacherInfo();
                }
            }
}
