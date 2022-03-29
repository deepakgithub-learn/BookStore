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

public class GenerateToken extends GetServerUrl{

	@Test
	public static String generateToken() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/JsonFiles/createUser.json");
		Response response = RestAssured.given().headers(ApiHeaders.headerConfigs()).body(file).post(ApiUrls.GENERATE_TOKEN);
		String generateToken = response.getBody().asString();
		
		ResponseValidation.validateStatusCode(response, 200);
		String authorizationMessage = ResponseValidation.parseJson(generateToken, "result");
		
		return authorizationMessage;

		System.out.println("---Learning Branch---");

	}
}
