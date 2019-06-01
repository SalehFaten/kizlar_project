/**
 * Sample Skeleton for 'connect.fxml' Controller Class
 */

package application;

import client.ChatClient;
import common.ChatIF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import client .*;
import common.ChatIF;
public class Connect  implements ChatIF{
	  static ChatClient client=null;
//		static ServerConsole Server = null;

    @FXML // fx:id="server"
    private Button server; // Value injected by FXMLLoader

    @FXML // fx:id="conclient"
    private TextField conclient; // Value injected by FXMLLoader

    @FXML
    void connectserver(ActionEvent event) {
    	ServerConsole Server = new ServerConsole(5555);

    }

    @FXML
    void connectclient(ActionEvent event) throws IOException {
    	  client = new ChatClient("doha",conclient.getText(),5555,this);
    	  Parent pane= FXMLLoader.load(getClass().getResource("Homepage.fxml"));
    	    Scene regist=new Scene(pane);
    	    Stage app_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	    app_stage.setScene(regist);
    	    app_stage.show();

    }

	@Override
	public void display(String message) {
		// TODO Auto-generated method stub
		
	}

}
