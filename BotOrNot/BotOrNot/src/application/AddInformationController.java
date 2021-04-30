package application;

import java.io.IOException;
import java.util.regex.Pattern;

import com.opencsv.exceptions.CsvValidationException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	public Button another;
	public AnchorPane infoPane;
	
	private boolean start = true;
	
	private Model model = new Model();
	
	@FXML
	void menuPressed(ActionEvent event) throws IOException {
		infoPane = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(infoPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	void back2Pressed(ActionEvent event) throws IOException {
		
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Object userGame = stage.getUserData();
		String convert = userGame.toString();
		
		infoPane = FXMLLoader.load(getClass().getResource("AddView.fxml"));
		Scene scene = new Scene(infoPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.setUserData(convert);
		window.show();
	}
	
	@FXML
	void enterPressed(ActionEvent event) throws IOException, CsvValidationException {
		
		if (start) {
			start = false;
		}
	
		Alert a = new Alert(AlertType.NONE);
		
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Object userGame = stage.getUserData();
		String convert = userGame.toString();
		String[] parts = convert.split("~");
		String game = parts[1];
		String user = parts[0];
		String apex = "A";
		String fortnite = "F";
		String warzone = "W";
		
	    
	    if (game.equals(apex) && (damage.getText().isEmpty() || kills.getText().isEmpty() || placement.getText().isEmpty())) {
	    	a.setAlertType(AlertType.ERROR);
	    	a.setHeaderText("Empty Field");
	    	a.setContentText("Please fill in all text fields");
	    	a.showAndWait();
	    	damage.clear();
		    kills.clear();
		    placement.clear();
	    }
	    else if ((game.equals(fortnite) || (game.equals(warzone))) && (kills.getText().isEmpty() || placement.getText().isEmpty())) {
	    	a.setAlertType(AlertType.ERROR);
	    	a.setHeaderText("Empty Field");
		    a.setContentText("Please fill in all text fields");
		    a.showAndWait();
		    damage.clear();
			kills.clear();
			placement.clear();

	    }
	    else if (game.equals(apex)){
	    	String dmg = damage.getText().toString();
	    	String k = kills.getText().toString();
	    	String place = placement.getText().toString();
	    	if (dmg.isEmpty() || k.isEmpty() ||place.isEmpty()) {
		    	a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Empty Field");
		    	a.setContentText("Please fill in all text fields");
		    	a.showAndWait();
		    	damage.clear();
			    kills.clear();
			    placement.clear();
		    }
	    	boolean pattern1 = Pattern.matches("[0-9]{1,5}", dmg);
	    	boolean pattern2 = Pattern.matches("[0-9]{1,2}", k);
	    	boolean pattern3 = Pattern.matches("[0-9]{1,2}", place);
			if (!pattern1) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Damage Entry");
		    	a.setContentText("Please enter a number between 0 and 99999");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (!pattern2) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Kills Entry");
		    	a.setContentText("Please enter a number between 0 and 58");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (!pattern3) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Placement Entry");
		    	a.setContentText("Please enter a number between 1 and 30");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (pattern1 && pattern2 && pattern3) {
				model.addGameStatistics(apex, user, dmg, k, place);
				a.setAlertType(AlertType.CONFIRMATION);
				a.setHeaderText("Apex Legends Game Stats Have Been Input");
				a.setContentText("Click OK to view updated stats");
				a.showAndWait();
				damage.clear();
				kills.clear();
				placement.clear();
				
				start = true;
				
				infoPane = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
				Scene scene = new Scene(infoPane);
				Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.setUserData(convert);
				window.show();
			}
		    
	    }
	    else if (game.equals(fortnite)) {
	    	String k = kills.getText().toString();
	    	String place = placement.getText().toString();
	    	boolean pattern2 = Pattern.matches("[0-9]{1,2}", k);
	    	boolean pattern3 = Pattern.matches("[0-9]{1,3}", place);
			
			if (!pattern2) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Kills Entry");
		    	a.setContentText("Please enter a number between 0 and 99");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (!pattern3) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Placement Entry");
		    	a.setContentText("Please enter a number between 1 and 100");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (pattern2 && pattern3) {
				model.addGameStatistics(fortnite, user, "0", k, place);
				a.setAlertType(AlertType.CONFIRMATION);
				a.setHeaderText("Fortnite Game Stats Have Been Input");
				a.setContentText("Click OK to view updated stats");
				a.showAndWait();
				damage.clear();
				kills.clear();
				placement.clear();
				
				start = true;
				
				infoPane = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
				Scene scene = new Scene(infoPane);
				Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.setUserData(convert);
				window.show();
			}
	    	
	    }
	    else if (game.equals(warzone)) {
	    	String k = kills.getText().toString();
	    	String place = placement.getText().toString();
	    	boolean pattern2 = Pattern.matches("[0-9]{1,3}", k);
	    	boolean pattern3 = Pattern.matches("[0-9]{1,3}", place);
			
			if (!pattern2) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Kills Entry");
		    	a.setContentText("Please enter a number between 0 and 149");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (!pattern3) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Placement Entry");
		    	a.setContentText("Please enter a number between 1 and 149");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (pattern2 && pattern3) {
				model.addGameStatistics(warzone, user, "0", k, place);
				a.setAlertType(AlertType.CONFIRMATION);
				a.setHeaderText("Warzone Game Stats Have Been Input");
				a.setContentText("Click OK to view updated stats");
				a.showAndWait();
			    damage.clear();
				kills.clear();
				placement.clear();
				
				start = true;
				
				infoPane = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
				Scene scene = new Scene(infoPane);
				Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.setUserData(convert);
				window.show();
			}
	    	
	    }
		
	}
	
	@FXML 
	void anotherPressed(ActionEvent event) throws IOException, CsvValidationException{
		
		if (start) {
			start = false;
		}
	
		Alert a = new Alert(AlertType.NONE);
		
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Object userGame = stage.getUserData();
		String convert = userGame.toString();
		String[] parts = convert.split("~");
		String game = parts[1];
		String user = parts[0];
		String apex = "A";
		String fortnite = "F";
		String warzone = "W";
		
		
	    
	    if (game.equals(apex) && (damage.getText().isEmpty() || kills.getText().isEmpty() || placement.getText().isEmpty())) {
	    	a.setAlertType(AlertType.ERROR);
	    	a.setHeaderText("Empty Field");
	    	a.setContentText("Please fill in all text fields");
	    	a.showAndWait();
	    	damage.clear();
		    kills.clear();
		    placement.clear();
	    }
	    else if ((game.equals(fortnite) || (game.equals(warzone))) && (kills.getText().isEmpty() || placement.getText().isEmpty())) {
	    	a.setAlertType(AlertType.ERROR);
	    	a.setHeaderText("Empty Field");
		    a.setContentText("Please fill in all text fields");
		    a.showAndWait();
		    damage.clear();
			kills.clear();
			placement.clear();

	    }
	    else if (game.equals(apex)){
	    	String dmg = damage.getText().toString();
	    	String k = kills.getText().toString();
	    	String place = placement.getText().toString();
	    	if (dmg.isEmpty() || k.isEmpty() ||place.isEmpty()) {
		    	a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Empty Field");
		    	a.setContentText("Please fill in all text fields");
		    	a.showAndWait();
		    	damage.clear();
			    kills.clear();
			    placement.clear();
		    }
	    	boolean pattern1 = Pattern.matches("[0-9]{1,5}", dmg);
	    	boolean pattern2 = Pattern.matches("[0-9]{1,2}", k);
	    	boolean pattern3 = Pattern.matches("[0-9]{1,2}", place);
			if (!pattern1) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Damage Entry");
		    	a.setContentText("Please enter a number between 0 and 99999");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (!pattern2) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Kills Entry");
		    	a.setContentText("Please enter a number between 0 and 58");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (!pattern3) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Placement Entry");
		    	a.setContentText("Please enter a number between 1 and 30");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (pattern1 && pattern2 && pattern3) {
				model.addGameStatistics(apex, user, dmg, k, place);
				a.setAlertType(AlertType.CONFIRMATION);
				a.setHeaderText("Apex Legends Game Stats Have Been Input");
				a.setContentText("Click OK to input another game");
				a.showAndWait();
				damage.clear();
				kills.clear();
				placement.clear();
			}
		    
	    }
	    else if (game.equals(fortnite)) {
	    	String k = kills.getText().toString();
	    	String place = placement.getText().toString();
	    	boolean pattern2 = Pattern.matches("[0-9]{1,2}", k);
	    	boolean pattern3 = Pattern.matches("[0-9]{1,3}", place);
			
			if (!pattern2) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Kills Entry");
		    	a.setContentText("Please enter a number between 0 and 99");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (!pattern3) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Placement Entry");
		    	a.setContentText("Please enter a number between 1 and 100");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (pattern2 && pattern3) {
				model.addGameStatistics(fortnite, user, "0", k, place);
				a.setAlertType(AlertType.CONFIRMATION);
				a.setHeaderText("Fortnite Game Stats Have Been Input");
				a.setContentText("Click OK to input another game");
				a.showAndWait();
				damage.clear();
				kills.clear();
				placement.clear();
			}
	    	
	    }
	    else if (game.equals(warzone)) {
	    	String k = kills.getText().toString();
	    	String place = placement.getText().toString();
	    	boolean pattern2 = Pattern.matches("[0-9]{1,3}", k);
	    	boolean pattern3 = Pattern.matches("[0-9]{1,3}", place);
			
			if (!pattern2) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Kills Entry");
		    	a.setContentText("Please enter a number between 0 and 149");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (!pattern3) {
				a.setAlertType(AlertType.ERROR);
		    	a.setHeaderText("Invalid Placement Entry");
		    	a.setContentText("Please enter a number between 1 and 149");
		    	a.showAndWait();
				damage.clear();
			    kills.clear();
			    placement.clear();
			}
			if (pattern2 && pattern3) {
				model.addGameStatistics(warzone, user, "0", k, place);
				a.setAlertType(AlertType.CONFIRMATION);
				a.setHeaderText("Warzone Game Stats Have Been Input");
				a.setContentText("Click OK to input another game");
				a.showAndWait();
			    damage.clear();
				kills.clear();
				placement.clear();
			}
	    	
	    }
		start = true;
	}
}
