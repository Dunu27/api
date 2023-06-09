package utility.externalFileUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.mysql.cj.jdbc.Driver;
/**
 * This class contains all the reusable methods for jdbc operations
 * @author dunu2
 *
 */
public class JdbcUtility {
	Driver dbDriver=null;
	Connection con=null;
	Statement statement;
	ResultSet result;

	/**
	 * This constructor will register driver and create statement for jdbc operations
	 */
	public JdbcUtility() {
		registerDriverAndCreateStatement();
	}
	/**
	 * This method will register the driver and will initialize the statement object
	 */
	public void registerDriverAndCreateStatement() {
		try {
			dbDriver = new Driver();
			DriverManager.registerDriver(dbDriver);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			statement = con.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * This generic method fetch the String data and integer data  using query 
	 * @param query
	 * @param strColumn
	 * @param intColumn
	 */
	public void getData(String query,Set<String>strColumn,Set<String>intColumn) {
		try {
			result = statement.executeQuery(query);
			while(result.next()) {
				for(String key:strColumn) {
					System.out.print(result.getString(key)+"  ");
				}
				for(String key:intColumn) {
					System.out.println(result.getInt(key));
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Set<String> getData(String query,String key) {

		try {
			Set<String>s=new HashSet<String>();	
			result = statement.executeQuery(query);
			while(result.next()) {
				s.add(result.getString(key));
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Set<Integer> getData(String query,int index) {

		try {
			Set<Integer>s=new HashSet<Integer>();	
			result = statement.executeQuery(query);
			while(result.next()) {
				s.add(result.getInt(index));
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * This generic method will delete the record
	 * @param query
	 */
	public void deleteData(String query) {
		try {
			int result = statement.executeUpdate(query);
			if(result==1) {
				System.out.println("row deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
	/**
	 * This generic method will update the record 
	 * @param query
	 */
	public void updateData(String query) {
		int result;
		try {
			result = statement.executeUpdate(query);
			if(result==1)
				System.out.println("Row updated");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * This method will close the coonection
	 */
	public void closeDatabase() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
