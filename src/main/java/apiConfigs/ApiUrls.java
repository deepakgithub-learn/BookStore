package apiConfigs;

public class ApiUrls {

	// http://bookstore.toolsqa.com/swagger/index.html
	
	// Create a User Account
	public static final String CREATE_USER = "Account/v1/User";
	
	// Generate Token for the account and Authorize the User
	public static final String GENERATE_TOKEN = "Account/v1/GenerateToken";
	
	// Verify whether the User is Authorized
	public static final String AUTHORIZED_USER = "Account/v1/Authorized";
	
	// Get User Details
	public static final String GET_USER_DETAILS = "/Account/v1/User/";
	
	// List the Books
	public static final String LIST_BOOKS = "BookStore/v1/Books";
	
	// Add a New Book
	public static final String ADD_BOOK = "BookStore/v1/Books";
	
}
