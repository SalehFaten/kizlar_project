/**
 * Sample Skeleton for 'employeeHomePage.fxml' Controller Class
 */

package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class employeeHomePage {

    @FXML // fx:id="employeeSeeMaps"
    private Button employeeSeeMaps; // Value injected by FXMLLoader

    @FXML // fx:id="createCity"
    private Button createCity; // Value injected by FXMLLoader

    @FXML // fx:id="addInterestingPlace"
    private Button addInterestingPlace; // Value injected by FXMLLoader

    @FXML // fx:id="editPath"
    private Button editPath; // Value injected by FXMLLoader

    @FXML // fx:id="editMap"
    private Button editMap; // Value injected by FXMLLoader

    @FXML // fx:id="editInterestingPlace"
    private Button editInterestingPlace; // Value injected by FXMLLoader

    @FXML // fx:id="addMapToCity"
    private Button addMapToCity; // Value injected by FXMLLoader

    @FXML // fx:id="addPath"
    private Button addPath; // Value injected by FXMLLoader

    @FXML // fx:id="outEmploeeHome"
    private Button outEmploeeHome; // Value injected by FXMLLoader

    @FXML
    void LogOut(ActionEvent event) throws IOException{

    }

    @FXML
    void addMapToCity(ActionEvent event) throws IOException{
        Parent pane= FXMLLoader.load(getClass().getResource("addMapToCity.fxml"));
        Scene log=new Scene(pane);
        Stage app_Stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        app_Stage.setScene(log);
        app_Stage.show();

    }


    @FXML
    void employeeSeeMaps(ActionEvent event) throws IOException{

    }

    @FXML
    void createCity(ActionEvent event) throws IOException{

    }

    @FXML
    void editInterestingPlace(ActionEvent event) throws IOException{

    }

    @FXML
    void addInterestingPlace(ActionEvent event) throws IOException{

    }

    @FXML
    void editPath(ActionEvent event) throws IOException{

    }

    @FXML
    void addPath(ActionEvent event) throws IOException{

    }

}
