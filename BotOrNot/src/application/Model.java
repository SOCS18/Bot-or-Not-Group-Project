package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class BotOrNotModel {
	
	static File file = new File("/Users/amberjones/CS3443/CSVmodel/src/game.csv");
	
	//@SuppressWarnings("resource")
	public void addGameStatistics(String game, String username, String damage, String kills, String placement ) throws IOException , CsvValidationException{
		
		
		FileWriter writer = new FileWriter(file, true);
		CSVWriter csvWriter = new CSVWriter(writer);
		
		String[] stats = {game, username, damage, kills, placement};
		csvWriter.writeNext(stats);		
		
		csvWriter.close();
		//writer.close();
		
		
	}


	public String[] getStatistics(String game1, String username1) throws IOException {
		String[] stats = new String[6];
        int count = 0;
        int damageSum = 0;
        int killSum = 0;
        int placementSum = 0;
        float damageAvg = 0;
        float killAvg = 0;
        float placementAvg = 0;
        
        String line = "";  
        String splitBy = ",";  
        String strDamages;
    	String strKills;
    	String strPlacement;
    	//String[] avg = new String[5];
        
        //parsing a CSV file into BufferedReader class constructor  
        BufferedReader br = new BufferedReader(new FileReader(file));  
        while ((line = br.readLine()) != null) {   //returns a Boolean value  
          
        	String[] player = line.split(splitBy); 
        	//System.out.println(player[0]);
        	
        	
        	String game2  = player[0].replaceAll("\"", "");
        	String username2 = player[1].replaceAll("\"", "");
        	strDamages = player[2].replaceAll("\"", "");
        	strKills = player[3].replaceAll("\"", "");
        	strPlacement = player[4].replaceAll("\"", "");
        	
        	int damages = Integer.parseInt(strDamages);
        	int kills = Integer.parseInt(strKills);
        	int	placement = Integer.parseInt(strPlacement);
        	
        	
        if (Objects.equals(game2, game1) && Objects.equals(username2, username1) ) {
        	count++;
        	
        	damageSum += damages;
        	killSum += kills;
        	placementSum += placement;
        	
        	damageAvg = (float)damageSum/count;
        	killAvg = (float)killSum/count;
        	placementAvg = (float)placementSum/count;
        	
        	
        }
        }
        if (count > 0) {
        
        stats[0] = game1;
        stats[1] = username1;
        stats[2] = String.valueOf(damageAvg);
        stats[3] = String.valueOf(killAvg);
        stats[4] = String.valueOf(placementAvg);
        stats[5] = String.valueOf(count);        	
	
		return stats;
        }
        else {
        	return null;
        }
	}
	public ArrayList<String[]> getAllStatistics(String game) throws IOException{
		ArrayList<String[]> averages = new ArrayList<String[]>();
		ArrayList<String> usernames = new ArrayList<String>();
		
		FileReader reader = new FileReader(file);
		String line = "";  
        String splitBy = ",";  
        
		BufferedReader br = new BufferedReader(new FileReader(file));  
        while ((line = br.readLine()) != null) {   //returns a Boolean value  
          
        	String[] player = line.split(splitBy); 
        	String user  = player[1].replaceAll("\"", "");
        	String game1  = player[0].replaceAll("\"", "");
        	if (Objects.equals(game, game1)) {
        		if ( !(usernames.contains(user))){
        			usernames.add(user);
        		}
        	}
        }	
		for (int i = 0; i < usernames.size(); i++) {
			averages.add(getStatistics(game, usernames.get(i)));
		}
        
		return averages;
	}
	
}
