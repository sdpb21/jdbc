import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.FileReader;
import java.io.File;

public class C11_1WriteCLOB {

	public static void main(String[] args) {
		Connection connectionObject=null;
		PreparedStatement preparedStatementObject=null;
		FileReader inputFileReaderObject=null;

		try {
			//get a connection to database
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			//prepare Statement
			String sql="update employees set resume=? where email='john.doe@foo.com'";
			preparedStatementObject=connectionObject.prepareStatement(sql);
			//set parameter for document file name
			File fileObject=new File("sample_resume.txt");
			inputFileReaderObject=new FileReader(fileObject);
			preparedStatementObject.setCharacterStream(1, inputFileReaderObject);
			System.out.println("Reading input file: "+fileObject.getAbsolutePath());
			//execute statement
			System.out.println("\nStoring document in database: "+fileObject);
			System.out.println(sql);
			preparedStatementObject.executeUpdate();
			System.out.println("\nCompleted successfully!");
		}catch(Exception exc) {
		}
	}

}
