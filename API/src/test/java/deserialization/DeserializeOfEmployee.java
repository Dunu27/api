package deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Employee;

public class DeserializeOfEmployee {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper o=new ObjectMapper();
			Employee e=o.readValue(new File("./src/test/resources/employee.json"), Employee.class);
        System.out.println(e.getEname());
        System.out.println(e.getEid());
        System.out.println(e.getEmailid());
        System.out.println(e.getPhno());
}
}
