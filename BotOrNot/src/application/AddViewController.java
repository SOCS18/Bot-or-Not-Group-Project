package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddViewController {
	@FXML
	public Button add;
	public Button view;
	public Button menuButton;
	public Button back1;
	public AnchorPane mainPane;
	
	@FXML
	void addPressed(ActionEvent event) throws IOException {
		
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Object user = stage.getUserData();
		String userString = user.toString();
		
		mainPane = FXMLLoader.load(getClass().getResource("AddInformation.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.setUserData(userString);
		window.show();
	}
	
	@FXML
	void viewPressed(ActionEvent event) throws IOException {
		
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Object user = stage.getUserData();
		String userString = user.toString();
		
		mainPane = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.setUserData(userString);
		window.show();
	}
	
	@FXML
	void back1Pressed(ActionEvent event) throws IOException {
		mainPane = FXMLLoader.load(getClass().getResource("GameSelector.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		
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
