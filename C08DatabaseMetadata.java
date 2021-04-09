import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.DatabaseMetaData;
import	java.sql.ResultSet;

public class C08DatabaseMetadata {

	public static void main(String[] args) {
		String catalog=null;
		String schemaPattern=null;
		String tableNamePattern=null;
		String columnNamePattern=null;
		String[] types=null;
		Connection connectionObject=null;
		ResultSet resultSetObject=null;

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
			//get list of tables
			System.out.println("List of tables\n--------------");
			resultSetObject=databaseMetadataObject.getTables(catalog, schemaPattern, tableNamePattern, types);
			while(resultSetObject.next()) {
				System.out.println(resultSetObject.getString("TABLE_NAME"));
			}
			//get list of columns
			System.out.println("\nList of columns\n----------------");
			resultSetObject=databaseMetadataObject.getColumns(catalog, schemaPattern, "employees", columnNamePattern);
			while(resultSetObject.next()) {
				System.out.println(resultSetObject.getString("COLUMN_NAME"));
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
