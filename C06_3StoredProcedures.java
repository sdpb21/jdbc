import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.CallableStatement;

public class C06_3StoredProcedures {

	public static void main(String[] args) {
		Connection connectionObject=null;
		CallableStatement callableStatementObject=null;

		try {
			//get a connection to database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
		}catch(Exception exc) {
			
		}
	}

}
