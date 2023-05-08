package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBase {

	public static void main(String[] args) throws SQLException {
       Driver driver=new Driver();
       DriverManager.registerDriver(driver);
       Connection c=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	Statement statement = c.createStatement();
	ResultSet result = statement.executeQuery("Select * from project");
	int count=result.getMetaData().getColumnCount();
	for(int i=1;i<=result.getMetaData().getColumnCount();i++) {
		System.out.println(result.getMetaData().getColumnName(i));
	}
	}

}
