package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StatisticsController {
	@FXML
    public TextField avgPlace2;
    public Label other;
    public TextField avgDmg2;
    public TextField gamesPlayed2;
    public Label avgKD;
    public Label your;
    public ListView<?> list;
    public TextField avgKD2;
    public Label gamesPlayed;
    public Button menuButton;
    public Label avgDmg;
    public Button back2;
    public Label avgPlace;
    public AnchorPane mainPane;
    public Button addInfo;
    
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
    void addInfoPressed(ActionEvent event) throws IOException {
    	mainPane = FXMLLoader.load(getClass().getResource("AddInformation.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }
}
