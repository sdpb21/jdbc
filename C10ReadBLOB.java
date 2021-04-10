import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class C10ReadBLOB {

	public static void main(String[] args) throws IOException, SQLException {
		Connection connectionObject=null;
		Statement statementObject=null;
		ResultSet resultSetObject=null;
		InputStream inputStreamObject=null;
		FileOutputStream output=null;

		try {
			//get a connection to database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			//execute statement
			statementObject=connectionObject.createStatement();
			String sql="select resume from employees where email='john.doe@foo.com'";
			resultSetObject=statementObject.executeQuery(sql);
			//set up a handle to the file
			File fileObject=new File("resume_from_db.pdf");
			output=new FileOutputStream(fileObject);

			if(resultSetObject.next()) {
				inputStreamObject=resultSetObject.getBinaryStream("resume");
				System.out.println("Reading resume from database");
				System.out.println(sql);
				byte[] buffer=new byte[1024];
				while(inputStreamObject.read(buffer)>0) {
					output.write(buffer);
				}
				System.out.println("\nSaved to file: "+fileObject.getAbsolutePath());
				System.out.println("\nCompleted successfully!");
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			if(inputStreamObject!=null) {
				inputStreamObject.close();
			}
			if(output!=null) {
				output.close();
			}
			if(resultSetObject!=null) {
				resultSetObject.close();
			}
			if(statementObject!=null) {
				statementObject.close();
			}
			if(connectionObject!=null) {
				connectionObject.close();
			}
		}
	}

}
