package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.http.Cookie;
import pojoClassForSerializationAndDeserialization.Employee;

public class SerializationOfEmployee {
public static void main(String[] args) {
	Employee emp=new Employee("Aswini","dunu27@gmail.com", 78945,001);
	ObjectMapper o=new ObjectMapper();
	try {
		o.writeValue(new File("./src/test/resources/employee.json"), emp);
	} catch (JsonGenerationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
