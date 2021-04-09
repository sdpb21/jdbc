import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.DatabaseMetaData;

public class C08DatabaseMetadata {

	public static void main(String[] args) {
		Connection connectionObject=null;

		try {
			//get a connection to database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			//get metadata
			DatabaseMetaData databaseMetadataObject=connectionObject.getMetaData();
			//display information about database
			System.out.println("Product name: "+databaseMetadataObject.getDatabaseProductName());
			System.out.println("Product version: "+databaseMetadataObject.getDatabaseProductVersion());
			System.out.printf("\n");
			//display information about JDBC driver
			System.out.println("JDBC driver name: "+databaseMetadataObject.getDriverName());
			System.out.println("JDBC driver version: "+databaseMetadataObject.getDriverVersion());
		}catch(Exception exc) {
		}
	}

}
