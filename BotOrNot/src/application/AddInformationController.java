package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddInformationController {
	@FXML
	public TextField kills;
	public TextField damage;
	public TextField placement;
	public TextField deaths;
	public Label game;
	public Label info;
	public Button menuButton;
	public Button back2;
	public Button enter;
	public AnchorPane mainPane;
	
	@FXML
	void menuPressed(ActionEvent event) throws IOException {
		mainPane = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	void back2Pressed(ActionEvent event) throws IOException {
		mainPane = FXMLLoader.load(getClass().getResource("AddView.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	void enterPressed(ActionEvent event) throws IOException {
		mainPane = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
}
