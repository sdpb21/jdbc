import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class C09ResultSetMetadata {

	public static void main(String[] args) {
		Connection connectionObject=null;
		Statement statementObject=null;
		ResultSet resultSetObject=null;

		try {
			//get a connection to the database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:33067demo","root","K1n9-cr1m50n");
			//run query
			statementObject=connectionObject.createStatement();
			resultSetObject=statementObject.executeQuery("select id,last_name,first_name,salary from employees");
			//get result set metadata
			ResultSetMetaData resultSetMetaDataObject=resultSetObject.getMetaData();
			//display info
			int columnCount=resultSetMetaDataObject.getColumnCount();
			System.out.println("Column count: "+columnCount+"\n");
			for(int column=1;column<=columnCount;column++) {
				System.out.println("Column name: "+resultSetMetaDataObject.getColumnName(column));
				System.out.println("Column type name: "+resultSetMetaDataObject.getColumnTypeName(column));
				System.out.println("Is nullable: "+resultSetMetaDataObject.isNullable(column));
				System.out.println("Is auto increment: "+resultSetMetaDataObject.isAutoIncrement(column)+"\n");
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
		}
	}

}
