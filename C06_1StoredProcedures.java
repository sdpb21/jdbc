import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.CallableStatement;
import	java.sql.PreparedStatement;
import	java.sql.ResultSet;
import java.sql.SQLException;
import	java.sql.Statement;

public class C06_1StoredProcedures {

	public static void main(String[] args) {
		Connection myConnection=null;
		CallableStatement myStatement=null;

		try {//"jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n"
			//get a connection to the database
			myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");

			String theDepartment="Engineering";
			int theIncreaseAmount=10000;
			//show salaries before
			System.out.println("Salaries before:");
			showSalaries(myConnection,theDepartment);
			//prepare the stored procedure call
			myStatement=myConnection.prepareCall("{call increase_salaries_for_department(?,?)}");
			//set the parameters
			myStatement.setString(1, theDepartment);
			myStatement.setDouble(2, theIncreaseAmount);
			//call stored procedure
			System.out.println("\n\nCalling stored procedure increase_salaries_for_department('"+theDepartment+"', "+theIncreaseAmount+")");
			myStatement.execute();
		}catch(Exception exc) {
			
		}
	}

	private static void showSalaries(Connection myCo,String Dep) throws SQLException {
		PreparedStatement myState=null;
		ResultSet myResultSet=null;

		try {
			//prepare statement
			myState=myCo.prepareStatement("select * from employees where department=?");
			myState.setString(1, Dep);
			//execute SQL query
			myResultSet=myState.executeQuery();
			//process result set
			while(myResultSet.next()) {
				String lastName=myResultSet.getString("last_name");
				String firstName=myResultSet.getString("first_name");
				double salary=myResultSet.getDouble("salary");
				String department=myResultSet.getString("department");
				System.out.printf("%s, %s, %s, %.2f\n",lastName,firstName,department,salary);
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			close(myState,myResultSet);
		}
	}
	private static void close(Connection connectionObject,Statement statementObject,ResultSet resultSetObject) throws SQLException {
		if(resultSetObject!=null) {
			resultSetObject.close();
		}
		if(statementObject!=null) {
			statementObject.close();
		}
		if(connectionObject!=null) {
			connectionObject.close();
		}
	}
	private static void close(Statement statementObject1,ResultSet resultSetObject1) throws SQLException {
		close(null,statementObject1,resultSetObject1);
	}

}
