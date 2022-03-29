package bookStore;

import java.io.IOException;

import org.testng.annotations.Test;

import apiConfigs.ApiHeaders;
import apiConfigs.ApiUrls;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import serverUrl.GetServerUrl;

public class GetUserDetails extends GetServerUrl{

	@Test
	public static String getUserDetails(String userID) throws IOException {
		
		String userAPI = ApiUrls.GET_USER_DETAILS;
		String userDetailsAPI = userAPI + userID;
		
		System.out.println("-------User Details API------");
		System.out.println(userDetailsAPI);
		Response response = RestAssured.given().headers(ApiHeaders.headerConfigs()).when().get(userDetailsAPI);
		String getUserDetails = response.getBody().asString();

		System.out.println ("This is a test comment");
		System.out.println(getUserDetails);
		return getUserDetails;
	}
}
