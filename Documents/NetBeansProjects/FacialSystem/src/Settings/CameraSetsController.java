/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import General.ControlledScreen;
import General.ScreensController;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.controlsfx.dialog.Dialogs;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CameraSetsController implements Initializable, ControlledScreen {

    @FXML
    private ComboBox<?> Classifier;
    @FXML
    private TextField FrameBox;
    @FXML
    private TextField height;
    @FXML
    private TextField width;
    @FXML
    private TextField AvgF;
    private CameraSettings Setup;
    @FXML
    private TextField searchscaleFactor;
    @FXML
    private TextField MinN;
    @FXML
    private TextField imgWidth;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList classifiers = new ArrayList();
        classifiers.add("Haar Classifier");
        classifiers.add("Lbp Classifier");
        ObservableList Classifiers = FXCollections.observableArrayList();
        Classifiers.addAll(classifiers);
        Classifier.getItems().addAll(Classifiers);
        Classifier.getSelectionModel().select(1);
    }

    @Override
    public void setScreenParent(ScreensController pane) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void saveSetsData(ActionEvent event) {
      Dialogs.create().message("Most this Changes Will only take effect after a reboot of the Systems").notify();
    }

    @FXML
    private void selectCassifier(ActionEvent event) {
     String cascadefile=Classifier.getSelectionModel().getSelectedItem().toString();
     Setup = new CameraSettings();
     Setup.SelectCascadeFile(cascadefile);
    }

}
