// Saul Carreon sme577
// Amber Jones eyq439
// Meera Patel tar927

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController {
	@FXML
	public Button startButton;
	public AnchorPane mainPane;
	
	@FXML
	void startPressed(ActionEvent event) throws IOException {
		mainPane = FXMLLoader.load(getClass().getResource("GameSelector.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
		
	}
}
