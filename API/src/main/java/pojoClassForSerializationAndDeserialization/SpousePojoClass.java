package pojoClassForSerializationAndDeserialization;

public class SpousePojoClass {
String name;
long phno;
String emailid;
public SpousePojoClass(String name, long phno, String emailid) {
	this.name = name;
	this.phno = phno;
	this.emailid = emailid;
}
public SpousePojoClass(){
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getPhno() {
	return phno;
}
public void setPhno(long phno) {
	this.phno = phno;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
@Override
public String toString() {
	return "name="+name+" phno="+phno+" emailid="+emailid;
}



}
