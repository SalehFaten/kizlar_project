/**
 * Sample Skeleton for 'Control.fxml' Controller Class
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import client .*;
import common.ChatIF;
import application.Main;
public  class Controller implements ChatIF {

	  static ChatClient client=null;
//	ServerConsole server=null;
//	private AnchorPane rootPane;
    @FXML // fx:id="search"
    private TextField search; // Value injected by FXMLLoader

    @FXML // fx:id="Citylist"
    private MenuButton Citylist; // Value injected by FXMLLoader

    @FXML // fx:id="login"
    private Button login; // Value injected by FXMLLoader

    @FXML // fx:id="register"
    private Button register; // Value injected by FXMLLoader

    @FXML
    private TextField host;

    @FXML
    void log(ActionEvent event) throws IOException {
        Parent pane= FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene log=new Scene(pane);
        Stage app_Stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        app_Stage.setScene(log);
        app_Stage.show();
    }
    
    @FXML
    void Search(ActionEvent event) {
    	String input = search.getText();   //receive input from text field
//         System.out.println(input);
       client.handleMessageFromClientUI(input);  

    }

    @FXML
    void regist(ActionEvent event) throws IOException {
    Parent pane= FXMLLoader.load(getClass().getResource("regist.fxml"));
    Scene regist=new Scene(pane);
    Stage app_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    app_stage.setScene(regist);
    app_stage.show();
    
    }

    @FXML
    void Cityname(ActionEvent event) { 
    	    	
    	
    }
    @FXML
    void host(ActionEvent event) throws IOException {
    	System.out.println(host.getText());
       client = new ChatClient("doha",host.getText(),5555,this);
    	
    }

	@Override
	public void display(String message) {
    	System.out.println(message);

	}


}
