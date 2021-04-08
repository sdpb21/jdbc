import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.CallableStatement;
import	java.sql.ResultSet;

public class C06_4StoredProcedures_ReturnResultSet {

	public static void main(String[] args) {
		Connection connectionObject=null;
		CallableStatement callableStatementObject=null;
		ResultSet resultsetObject=null;

		try {
			//get a connection to database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			String department="Engineering";
			//prepare the stored procedure call
			callableStatementObject=connectionObject.prepareCall("{call get_employees_for_department(?)}");
			}catch(Exception exc) {
			
		}
	}

}
