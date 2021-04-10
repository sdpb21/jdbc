import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.InputStream;
import java.io.FileOutputStream;

public class C10ReadBLOB {

	public static void main(String[] args) {
		Connection connectionObject=null;
		Statement statementObject=null;
		ResultSet resultSetObject=null;
		InputStream input=null;
		FileOutputStream output=null;

		try {
			//get a connection to database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			//execute statement
			statementObject=connectionObject.createStatement();
			String sql="select resume from employees where email='john.doe@foo.com'";
			resultSetObject=statementObject.executeQuery(sql);
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
