/**
 * Sample Skeleton for 'addMapToCity.fxml' Controller Class
 */

package application;

import javax.swing.JOptionPane;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.scene.control.TextField;

public class AddMapToCity {

    @FXML // fx:id="addMapToCity_btn"
    private Button addMapToCity_btn; // Value injected by FXMLLoader

    @FXML // fx:id="IdToNewMap"
    private TextField IdToNewMap; // Value injected by FXMLLoader

    @FXML // fx:id="descriptionToNewMap"
    private TextField descriptionToNewMap; // Value injected by FXMLLoader

    @FXML // fx:id="pathToNewMap"
    private TextField pathToNewMap; // Value injected by FXMLLoader

    @FXML // fx:id="VersionNumToNewMap"
    private TextField VersionNumToNewMap; // Value injected by FXMLLoader

    @FXML // fx:id="enterCityName"
    private TextField enterCityName; // Value injected by FXMLLoader

    @FXML
    void enterCityNameToAddMap(ActionEvent event) {

    }

    @FXML
    void enterPathToNewMap(ActionEvent event) {

    }

    @FXML
    void addMapToCity_btn(ActionEvent event) throws IOException {
    	JOptionPane.showMessageDialog(null, "Adding Map Finished Successfully");
     	Parent pane= FXMLLoader.load(getClass().getResource("employeeHomePage.fxml"));
        Scene log=new Scene(pane);
        Stage app_Stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        app_Stage.setScene(log);
        app_Stage.show();

    }

    @FXML
    void descriptionToNewMap(ActionEvent event) {

    }

    @FXML
    void VersionNumToNewMap(ActionEvent event) {

    }

    @FXML
    void IdToNewMap(ActionEvent event) {

    }

}



