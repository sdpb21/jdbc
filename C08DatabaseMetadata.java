import	java.sql.Connection;
import java.sql.DriverManager;

public class C08DatabaseMetadata {

	public static void main(String[] args) {
		Connection connectionObject=null;

		try {
			//get a connection to database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
		}catch(Exception exc) {
		}
	}

}
