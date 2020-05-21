package bookStore;

import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.Test;

import apiConfigs.ApiHeaders;
import apiConfigs.ApiUrls;
import apiVerifications.ResponseValidation;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import serverUrl.GetServerUrl;

public class CreateUser extends GetServerUrl{

	@Test
	public static void createUser() throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/JsonFiles/createuser.json");
		Response response = RestAssured.given().headers(ApiHeaders.headerConfigs()).body(file).post(ApiUrls.CREATE_USER);		
		
//		{"userID":"1c5aec31-6b79-4663-ac8c-eef3d24f6dd1","userName":"deepakbook1211","books":[]}

		String createUser = response.getBody().asString();
		ResponseValidation.validateStatusCode(response, 201);
		String userID = ResponseValidation.parseJson(createUser, "userID");
		System.out.println(userID);
		
		String generateToken = GenerateToken.generateToken();
		if (generateToken.equalsIgnoreCase("User authorized successfully")) {
			String getUserDetails = GetUserDetails.getUserDetails(userID);
			System.out.println(getUserDetails);
		}
		
		else {
			System.out.println(generateToken);
		}
	}
}
