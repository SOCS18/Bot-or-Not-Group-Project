// Saul Carreon sme577
// Amber Jones eyq439
// Meera Patel tar927

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController {
	@FXML
	public Button startButton;
	public AnchorPane mainPane;
	public TextField userName;
	
	private boolean start = true;
	
	@FXML
	void startPressed(ActionEvent event) throws IOException {
		
		if (start) {
			start = false;
		}
	
		Alert a = new Alert(AlertType.NONE);
		String user = "";
		
		if (userName.getText().isEmpty()) {
			a.setAlertType(AlertType.ERROR);
	    	a.setHeaderText("Empty Field");
	    	a.setContentText("Please fill in all text fields");
	    	a.showAndWait();
	    	userName.clear();
		}
		else {
			user = userName.getText().toString();
			
			start = true;
			
			mainPane = FXMLLoader.load(getClass().getResource("GameSelector.fxml"));
			Scene scene = new Scene(mainPane);
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.setUserData(user);
			window.show();
		}
		
	}
}
