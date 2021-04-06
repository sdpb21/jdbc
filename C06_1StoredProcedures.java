import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.CallableStatement;

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
		}
	}

	private static void showSalaries(Connection myCo,String Dep) {
		
	}

}
