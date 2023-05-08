package pojolibrary;

public class EmployeePojoClass {
String ename;
String[]emailid;
int[] phno;
int eid;
SpousePojoClass spouse;
public EmployeePojoClass(String ename, String[] emailid, int[] phno, int eid, SpousePojoClass spouse) {
	super();
	this.ename = ename;
	this.emailid = emailid;
	this.phno = phno;
	this.eid = eid;
	this.spouse = spouse;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String[] getEmailid() {
	return emailid;
}
public void setEmailid(String[] emailid) {
	this.emailid = emailid;
}
public int[] getPhno() {
	return phno;
}
public void setPhno(int[] phno) {
	this.phno = phno;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public SpousePojoClass getSpouse() {
	return spouse;
}
public void setSpouse(SpousePojoClass spouse) {
	this.spouse = spouse;
}

}
