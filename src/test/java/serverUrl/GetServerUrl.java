package serverUrl;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import utils.ReadServerUrl;

public class GetServerUrl {

	@BeforeClass
	public void getServerUrl() {
		RestAssured.baseURI = ReadServerUrl.readUrl().get("baseURL");
	}
}
