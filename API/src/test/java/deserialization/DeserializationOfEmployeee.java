package deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.EmployeePojoClass;
import pojoClassForSerializationAndDeserialization.SpousePojoClass;


public class DeserializationOfEmployeee {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        
ObjectMapper o=new ObjectMapper();
EmployeePojoClass e=o.readValue(new File("./src/test/resources/employeespouse.json"), EmployeePojoClass.class);
System.out.println(e.getEid());
System.out.println(e.getEname());
System.out.println(e.getEmailid()[0]+" "+e.getEmailid()[1]);
System.out.println(e.getPhno()[0]+" "+e.getPhno()[1]);
SpousePojoClass spouse = e.getSpouse();
System.out.println(spouse.toString());
}

}
