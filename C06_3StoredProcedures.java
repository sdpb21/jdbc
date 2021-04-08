import	java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import	java.sql.CallableStatement;

public class C06_3StoredProcedures {

	public static void main(String[] args) {
		Connection connectionObject=null;
		CallableStatement callableStatementObject=null;

		try {
			//get a connection to database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			String theDepartment="Engineering";
			//prepare the stored procedure call
			callableStatementObject=connectionObject.prepareCall("{call get_count_for_department(?,?)}");
			//set the parameters
			callableStatementObject.setString(1, theDepartment);
			callableStatementObject.registerOutParameter(2, Types.INTEGER);
			//call the stored procedure
			System.out.println("Calling stored procedure get_count_for_department('"+theDepartment+"',?)");
			callableStatementObject.execute();
			System.out.println("Calling stored procedure complete");
			//get the value for the OUT parameter
			int count=callableStatementObject.getInt(2);
			System.out.println("\nThe count: "+count);
		}catch(Exception exc) {
			
		}
	}

}
