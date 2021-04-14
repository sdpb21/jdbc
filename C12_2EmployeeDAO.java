import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;

public class C12_2EmployeeDAO {
	private Connection connectionObject;

	//constructor
	public C12_2EmployeeDAO() throws Exception{
		//get database properties
		Properties propertiesObject=new Properties();
		propertiesObject.load(new FileInputStream("demo.properties"));
		String user=propertiesObject.getProperty("user");
		String password=propertiesObject.getProperty("password");
		String dburl=propertiesObject.getProperty("dburl");
		//connect to the database
		connectionObject=DriverManager.getConnection(dburl, user, password);
		System.out.println("database connection successful to: "+dburl);
	}
}
