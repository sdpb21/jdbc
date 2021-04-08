import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.CallableStatement;
import	java.sql.ResultSet;
import java.sql.SQLException;

public class C06_4StoredProcedures_ReturnResultSet {

	public static void main(String[] args) {
		Connection connectionObject=null;
		CallableStatement callableStatementObject=null;
		ResultSet resultSetObject=null;

		try {
			//get a connection to database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			String department="Engineering";
			//prepare the stored procedure call
			callableStatementObject=connectionObject.prepareCall("{call get_employees_for_department(?)}");
			//set the parameter
			callableStatementObject.setString(1, department);
			//call stored procedure
			callableStatementObject.execute();
			System.out.println("Finished calling stored procedure.");
			//get the result set
			resultSetObject=callableStatementObject.getResultSet();
			//display the result
		}catch(Exception exc) {
			
		}
	}
	private static void display(ResultSet resultSetObject2) throws SQLException {
		while(resultSetObject2.next()) {
			String lastName=resultSetObject2.getString("last_name");
			String firstName=resultSetObject2.getString("first_name");
			double salary=resultSetObject2.getDouble("salary");
			String department=resultSetObject2.getString("department");
			System.out.printf("%s, %s, %s, %.2f\n",lastName,firstName,department,salary);
		}
	}

}
