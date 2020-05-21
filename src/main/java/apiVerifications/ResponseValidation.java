package apiVerifications;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;

public class ResponseValidation {

	public static void validateStatusCode (Response response, int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}
	
	public static String parseJson (String response, String key) {
		JSONObject json = new JSONObject(response);
		boolean exists = json.has(key);
		
		if (!exists) {
			System.out.println("Key doesn't exists");
			Iterator<?> iterators;
			String keys;
			iterators = json.keys();
			
			while (iterators.hasNext()) {
				keys = iterators.next().toString();
				
				if (json.get(keys) instanceof JSONObject) {
					parseJson(keys, key);
				}
				
				else if (json.get(keys) instanceof JSONArray) {
					JSONArray jsonArray = json.getJSONArray(keys);
					for (int i=0; i<jsonArray.length(); i++) {
						String jsonString = jsonArray.get(i).toString();
						
						if (!exists) {
							JSONObject jsonObject = new JSONObject(jsonString);
							parseJson(jsonObject.toString(), key);
						}
					}
				}
			}
		}
		
		else {
			json.get(key);
		}
		return json.get(key).toString();
	}
}
