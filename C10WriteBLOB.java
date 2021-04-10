import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;

public class C10WriteBLOB {

	public static void main(String[] args) {
		Connection connectionObject=null;
		PreparedStatement preparedStatementObject=null;
		FileInputStream input=null;

		try {
			// get a connection object to database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			//prepare statement
			String sql="update employees set resume=? where email='john.doe@foo.com'";
			preparedStatementObject=connectionObject.prepareStatement(sql);
			//set parameter for resume file name
			File theFile=new File("sample_resume.pdf");
			input=new FileInputStream(theFile);
			preparedStatementObject.setBinaryStream(1, input);
			System.out.println("Reading input file: "+theFile.getAbsolutePath());
			//execute statement
			System.out.println("\nStoring resume in database: "+theFile);
			System.out.println(sql);
			preparedStatementObject.executeUpdate();
			System.out.println("\nCompleted successfully!");
		}catch(Exception exc) {
		}
	}

}
