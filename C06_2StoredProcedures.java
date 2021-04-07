import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.CallableStatement;

public class C06_2StoredProcedures {

	public static void main(String[] args) {
		Connection connectionObject=null;
		CallableStatement callableStatementObject=null;

		try {//"jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n"
			//get a connection to database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","K1n9-cr1m50n");
			String theDepartment="Engineering";
			//prepare the stored procedure call
			callableStatementObject=connectionObject.prepareCall("{call greet_the_department(?)}");
		}catch(Exception exc) {
			
		}
	}

}
