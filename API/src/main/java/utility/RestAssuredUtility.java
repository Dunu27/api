package utility;


import io.restassured.response.Response;

public class RestAssuredUtility {

	/**
	 * This generic method will return the string from the response 
	 * @param response
	 * @param path
	 * @return
	 */
	public String getJsonData(Response response,String path) {
	String jsonData=response.jsonPath().get(path);
	return jsonData;
	}
	
}
