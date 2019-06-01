/**
 * Sample Skeleton for 'login.fxml' Controller Class
 */

package application;

import java.io.IOException;

import application.Controller;
import common.ChatIF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import common .*;

public class signin  {

    @FXML // fx:id="password"
    private TextField password; // Value injected by FXMLLoader

    @FXML // fx:id="email"
    private TextField email; // Value injected by FXMLLoader
    
    @FXML
    void SignIn(ActionEvent event) throws IOException {
    	 Parent pane= FXMLLoader.load(getClass().getResource("employeeHomePage.fxml"));
         Scene log=new Scene(pane);
         Stage app_Stage=(Stage)((Node)event.getSource()).getScene().getWindow();
         app_Stage.setScene(log);
         app_Stage.show();
     	String input = email.getText();   //receive input from text field
        Controller.client.handleMessageFromClientUI(input);  
        
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        Parent pane= FXMLLoader.load(getClass().getResource("Homepage.fxml"));
        Scene log=new Scene(pane);
        Stage app_Stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        app_Stage.setScene(log);
        app_Stage.show();

    }


}
