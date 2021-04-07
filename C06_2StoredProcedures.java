import	java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import	java.sql.CallableStatement;

public class C06_2StoredProcedures {

	public static void main(String[] args) throws SQLException {
		Connection connectionObject=null;
		CallableStatement callableStatementObject=null;

		try {//"jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n"
			//get a connection to database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","K1n9-cr1m50n");
			String theDepartment="Engineering";
			//prepare the stored procedure call
			callableStatementObject=connectionObject.prepareCall("{call greet_the_department(?)}");
			//set the parameters
			callableStatementObject.registerOutParameter(1, Types.VARCHAR);
			callableStatementObject.setString(1, theDepartment);
			//call stored procedure
			System.out.println("Calling stored procedure greet_the_department('"+theDepartment+"')");
			callableStatementObject.execute();
			System.out.println("Calling stored procedure completed");
			//get the value of INOUT parameter
			String theResult=callableStatementObject.getString(1);
			System.out.println("\nThe result: "+theResult);
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			if(callableStatementObject!=null) {
				callableStatementObject.close();
			}
			if(connectionObject!=null) {
				connectionObject.close();
			}
		}
	}

}
