import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.Statement;

public class C03UpdatingDataInAMysqlDatabase {

	public static void main(String[] args) {
		Connection myConnection=null;
		Statement myStatement=null;

		try {
			//1. get a connection to the database
			myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
		}
	}

}
