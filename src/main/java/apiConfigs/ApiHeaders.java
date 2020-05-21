package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class ApiHeaders {

	public static Map<String, String> headers = new HashMap<String, String>();
	public static Map<String, String> headerConfigs() {
		headers.put("Content-Type", "application/json");
		return headers;
	}
}
