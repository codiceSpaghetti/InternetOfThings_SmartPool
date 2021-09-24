package iot.unipi.it;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class ConfigurationReader {
	TreeMap<String, String> configurationMap;
	private static final File CONFIG_FILE = new File("config.txt");
	private static ConfigurationReader instance = null;
	
	public static ConfigurationReader getInstance()
    {
        if (instance == null)
            instance = new ConfigurationReader();

        return instance;
    }
	
	private ConfigurationReader(){
		configurationMap = new TreeMap<String, String>();
        
		try (BufferedReader bfr= new BufferedReader(new FileReader(CONFIG_FILE));){

	        String line;
	        while ((line = bfr.readLine()) != null) {
	            if (!line.startsWith("#") && !line.isEmpty()) {
	                String[] pair = line.trim().split("=");
	                configurationMap.put(pair[0].trim(), pair[1].trim());
	            }
	        }
		} catch (IOException  e) {
			e.printStackTrace();
		}
		
	}
	
	
	public String getDbUsername() {
		return configurationMap.get("DbUsername");
	}
	
	public String getDbPassword() {
		return configurationMap.get("DbPassword");
	}
	
	public String getDbIp() {
		return configurationMap.get("DbIp");
	}
	
	public String getDbPort() {
		return configurationMap.get("DbPort");
	}
	
	public String getDbName() {
		return configurationMap.get("DbName");
	}
	
	public int getLowerCl() {
		return Integer.parseInt(configurationMap.get("LowerCl"));
	}
	
	public int getUpperCl() {
		return Integer.parseInt(configurationMap.get("UpperCl"));
	}
	
	public int getLowerTemp() {
		return Integer.parseInt(configurationMap.get("LowerTemp"));
	}
	
	public int getUpperTemp() {
		return Integer.parseInt(configurationMap.get("UpperTemp"));
	}
	
}
