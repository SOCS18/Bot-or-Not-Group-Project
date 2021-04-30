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

public class GameSelectorController {
	@FXML
	public Button fortniteButton;
	public Button warzoneButton;
	public Button apexButton;
	public Button menuButton;
	public AnchorPane mainPane;
	
	@FXML
	void warzonePressed(ActionEvent event) throws IOException {
		
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Object user = stage.getUserData();
		String userString = user.toString();
		
		String userGame = userString + "~W";
		
		mainPane = FXMLLoader.load(getClass().getResource("AddView.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.setUserData(userGame);
		window.show();
	}
	
	@FXML
	void fortnitePressed(ActionEvent event) throws IOException {
		
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Object user = stage.getUserData();
		String userString = user.toString();
		
		String userGame = userString + "~F";
		
		mainPane = FXMLLoader.load(getClass().getResource("AddView.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.setUserData(userGame);
		window.show();
	}
	
	@FXML
	void apexPressed(ActionEvent event) throws IOException {
		
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Object user = stage.getUserData();
		String userString = user.toString();
		
		String userGame = userString + "~A";
		
		mainPane = FXMLLoader.load(getClass().getResource("AddView.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.setUserData(userGame);
		window.show();
	}
	
	@FXML
	void menuPressed(ActionEvent event) throws IOException {
		mainPane = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
}
