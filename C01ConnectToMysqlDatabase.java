import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.Statement;
import	java.sql.ResultSet;
import java.sql.SQLException;

public class C01ConnectToMysqlDatabase {

	public static void main(String[] args) throws SQLException {
		Connection myConnection=null;
		Statement myStatement=null;
		ResultSet myResultSet=null;

		try {
			//1. get a connection to database
			myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			//2. create a statement
			myStatement=myConnection.createStatement();
			//3. execute sql query
			myResultSet=myStatement.executeQuery("select * from employees");
			//4. process the result set
			while(myResultSet.next()) {
				System.out.println(myResultSet.getString("last_name")+", "+myResultSet.getString("first_name"));
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			if(myResultSet!=null) {
				myResultSet.close();
			}
			if(myStatement!=null) {
				myStatement.close();
			}
			if(myConnection!=null) {
				myConnection.close();
			}
		}
	}

}
