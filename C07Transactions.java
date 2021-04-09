import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.Statement;

public class C07Transactions {

	public static void main(String[] args) {
		Connection connectionObject=null;
		Statement statementObject=null;
		try {
			//get a connection to database object
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
		}catch(Exception exc) {
		}
	}

}
