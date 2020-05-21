package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadServerUrl {

	public static Map<String, String> serverUrl = new HashMap<String, String>();
	public static Properties properties = new Properties();
	
	public static Map<String, String> readUrl() {
		
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/ServerConfigurations/URL.properties");
			properties.load(file);
			serverUrl.put("baseURL", properties.getProperty("baseURL"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serverUrl;
	}
}
