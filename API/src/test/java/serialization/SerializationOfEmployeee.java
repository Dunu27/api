package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.EmployeePojoClass;
import pojoClassForSerializationAndDeserialization.SpousePojoClass;

public class SerializationOfEmployeee {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		 SpousePojoClass spouse=new SpousePojoClass("Katrina", 78045678l, "katash@27gmail.com");
         String[]emailid= {"dunu27@gmail.com","dunu354@gmail.com"};
         int[]phno= {78451,98745};
         EmployeePojoClass employee=new EmployeePojoClass("Aswini", emailid, phno, 1010, spouse);
         ObjectMapper o=new ObjectMapper();
         o.writeValue(new File("./src/test/resources/employeespouse.json"),employee);

	}

}
