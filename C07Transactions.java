import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.Statement;
import	java.sql.PreparedStatement;
import	java.sql.ResultSet;
import java.sql.SQLException;

public class C07Transactions {

	public static void main(String[] args) {
		Connection connectionObject=null;
		Statement statementObject=null;
		try {
			//get a connection to database object
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			//turn off auto commit
			connectionObject.setAutoCommit(false);
			//show salaries before the change
			System.out.println("Salaries before statement execute:");
		}catch(Exception exc) {
		}
	}
	private static void showSalaries(Connection connectionObject2,String department) {
		PreparedStatement preparedStatementObject=null;
		ResultSet resultSetObject=null;

		System.out.println("Show salaries for department: "+department);
		try {
			//prepare statement
			preparedStatementObject=connectionObject2.prepareStatement("select * from employees where department=?");
			preparedStatementObject.setString(1, department);
			//execute sql query
			resultSetObject=preparedStatementObject.executeQuery();
			//process result set
			while(resultSetObject.next()) {
				String lastName=resultSetObject.getString("last_name");
				String firstName=resultSetObject.getString("first_name");
				double salary=resultSetObject.getDouble("salary");
				String department2=resultSetObject.getString("department");
				System.out.printf("%s, %s, %s, %.2f\n",lastName,firstName,department,salary);
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			
		}
	}
	private static void close(Connection connectionObject3,Statement statementObject2,ResultSet resultSetObject) throws SQLException {
		if(resultSetObject!=null) {
			resultSetObject.close();
		}
		if(statementObject2!=null) {
			statementObject2.close();
		}
		if(connectionObject3!=null) {
			connectionObject3.close();
		}
	}
	private static void close(Statement statementObject,ResultSet resultSetObject) throws SQLException {
		close(null,statementObject,resultSetObject);
	}
}
