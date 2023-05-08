package practice;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class P {
	public static void main(String[] args) {
		Cookie c = new Cookie.Builder(DEFAULT_BODY_ROOT_PATH, DEFAULT_SESSION_ID_VALUE).build();
		given().cookie(c);
		String email = "lindsay.ferguson@reqres.in";
		Response r = when().get("https://reqres.in/api/users?page=2");
		List<String> list = r.jsonPath().get("data.email");
		System.out.println(list);
		boolean yes = list.contains(email);
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "kishore");

		System.out.println(yes);
		for (String string : list) {
			if (string.equals(email)) {
				System.out.println("jcsjohj");
			}

		}

	}
}
