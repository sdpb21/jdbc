import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.PreparedStatement;
import	java.sql.ResultSet;

public class C05PreparedStatements {

	public static void main(String[] args) {
		Connection myConnection=null;
		PreparedStatement myStatement=null;
		ResultSet myResultSet=null;

		try {//"jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n"
			//1. get a connection to database
			myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			//2. prepare the statement
			myStatement=myConnection.prepareStatement("select * from employees where salary > ? and department=?");
			//3. set the parameters
			myStatement.setDouble(1, 80000);
			myStatement.setString(2, "Legal");
			//4. execute SQL query
			myResultSet=myStatement.executeQuery();
			//5. display the result set
		}
	}

}
