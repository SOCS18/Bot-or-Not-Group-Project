package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
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
    public TextArea list;
    public TextField avgKD2;
    public Label gamesPlayed;
    public Button menuButton;
    public Label avgDmg;
    public Button back2;
    public Label avgPlace;
    public AnchorPane statPane;
    public Button addInfo;
    public Button statsDisplay;
    public TextField gameName;
    
    private boolean start = true;
	
	private Model model = new Model();
    
    @FXML
    void menuPressed(ActionEvent event) throws IOException {
    	statPane = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(statPane);
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

    	
    	statPane = FXMLLoader.load(getClass().getResource("AddView.fxml"));
		Scene scene = new Scene(statPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.setUserData(convert);
		window.show();
    }
    
    @FXML
    void addInfoPressed(ActionEvent event) throws IOException {
    	
    	Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Object userGame = stage.getUserData();
		String convert = userGame.toString();
    	
    	statPane = FXMLLoader.load(getClass().getResource("AddInformation.fxml"));
		Scene scene = new Scene(statPane);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.setUserData(convert);
		window.show();
    }
    
    @FXML
    void statsPressed(ActionEvent event) throws IOException {
    	
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
		
		if (game.equals(apex)) {
			gameName.setText("APEX LEGENDS");
			String[] userStats = model.getStatistics(apex, user);
			gamesPlayed2.setText(userStats[5]);
			avgDmg2.setText(userStats[2]);
			avgKD2.setText(userStats[3]);
			avgPlace2.setText(userStats[4]);
			ArrayList<String[]> averages = model.getAllStatistics(apex);

	        String[] avg = new String[averages.size()];
	        String everything = "Username\t# of Games\tAvg Damage\t\tAvg Kills\t\tAvg Placement\t\n";
	        for (int i = 0; i < averages.size(); i++) {
	        	avg = averages.get(i);
	            everything = everything + avg[1] + "\t\t" + avg[5]+ "\t\t\t"+ avg[2] + "\t\t\t"+ avg[3]+ "\t\t\t"+ avg[4]+ "\n";
	        }
	        list.setText(everything);
			
		}
		if (game.equals(fortnite)) {
			gameName.setText("FORTNITE");
			String[] userStats = model.getStatistics(fortnite, user);
			gamesPlayed2.setText(userStats[5]);
			avgDmg2.setText("N/A");
			avgKD2.setText(userStats[3]);
			avgPlace2.setText(userStats[4]);
			ArrayList<String[]> otherUsers = new ArrayList<String[]>();
			otherUsers = model.getAllStatistics(fortnite);
			ArrayList<String[]> averages = model.getAllStatistics(fortnite);

	        String[] avg = new String[averages.size()];
	        String everything = "Username\t# of Games\tAvg Damage\t\tAvg Kills\t\tAvg Placement\t\n";
	        for (int i = 0; i < averages.size(); i++) {
	        	avg = averages.get(i);
	            everything = everything + avg[1] + "\t\t\t\t" + avg[5]+ "\t\t"+ avg[2] + "\t\t\t\t"+ avg[3]+ "\t\t\t"+ avg[4]+ "\n";
	        }
	        list.setText(everything);
			
		}
		if (game.equals(warzone)) {
			gameName.setText("WARZONE");
			String[] userStats = model.getStatistics(warzone, user);
			gamesPlayed2.setText(userStats[5]);
			avgDmg2.setText("N/A");
			avgKD2.setText(userStats[3]);
			avgPlace2.setText(userStats[4]);
			ArrayList<String[]> otherUsers = new ArrayList<String[]>();
			otherUsers = model.getAllStatistics(warzone);
			ArrayList<String[]> averages = model.getAllStatistics(warzone);

	        String[] avg = new String[averages.size()];
	        String everything = "Username\t# of Games\tAvg Damage\t\tAvg Kills\t\tAvg Placement\t\n";
	        for (int i = 0; i < averages.size(); i++) {
	        	avg = averages.get(i);
	            everything = everything + avg[1] + "\t\t\t" + avg[5]+ "\t\t"+ avg[2] + "\t\t\t\t"+ avg[3]+ "\t\t\t"+ avg[4]+ "\n";
	        }
	        list.setText(everything);
	
		}
		
    }
}
