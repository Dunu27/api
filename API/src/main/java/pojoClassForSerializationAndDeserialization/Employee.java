package pojoClassForSerializationAndDeserialization;

public class Employee {
	String ename;
	String emailid;
	int phno;
	int eid;
	public Employee(String ename, String emailid, int phno, int eid) {
		super();
		this.ename = ename;
		this.emailid = emailid;
		this.phno = phno;
		this.eid = eid;
	}
	public Employee() {
		
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
}
