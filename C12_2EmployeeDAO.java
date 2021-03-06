import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;

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
	public List<C12_2Employee> getAllEmployees() throws Exception{
		List<C12_2Employee> listObject=new ArrayList<C12_2Employee>();
		Statement statementObject=null;
		ResultSet resultSetObject=null;
		try {
			statementObject=connectionObject.createStatement();
			resultSetObject=statementObject.executeQuery("select * from employees");
			while(resultSetObject.next()) {
				C12_2Employee tempEmployee=convertRowToEmployee(resultSetObject);
				listObject.add(tempEmployee);
			}
			return listObject;
		}finally {
			close(statementObject,resultSetObject);
		}
	}
	public List<C12_2Employee> searchEmployees(String lastName) throws Exception{
		List<C12_2Employee> listObj=new ArrayList<C12_2Employee>();
		PreparedStatement preStatObj=null;
		ResultSet reSetObj=null;

		try {
			lastName+="%";
			preStatObj=connectionObject.prepareStatement("select * from employees where last_name like ?");
			preStatObj.setString(1, lastName);
			reSetObj=preStatObj.executeQuery();
			while(reSetObj.next()) {
				C12_2Employee tempEmployee=convertRowToEmployee(reSetObj);
				listObj.add(tempEmployee);
			}// end of while
			return listObj;
		}finally {
			close(preStatObj,reSetObj);
		}// end of finally
	}//end of searchEmployees
	private C12_2Employee convertRowToEmployee(ResultSet reSetObj) throws SQLException{
		int id=reSetObj.getInt("id");
		String lastName=reSetObj.getString("last_name");
		String firstName=reSetObj.getString("first_name");
		String email=reSetObj.getString("email");
		BigDecimal salary=reSetObj.getBigDecimal("salary");
		C12_2Employee tempEmployee=new C12_2Employee(id,lastName,firstName,email,salary);
		return tempEmployee;
	}
	private static void close(Connection connObj,Statement statObj,ResultSet reSetObj) throws SQLException {
		if(reSetObj!=null) {
			reSetObj.close();
		}
		if(statObj!=null) {
			statObj.close();
		}
		if(connObj!=null) {
			connObj.close();
		}
	}
	private void close(Statement statObj,ResultSet reSetObj) throws SQLException {
		close(null,statObj,reSetObj);
	}
	public static void main(String[] args) throws Exception {
		C12_2EmployeeDAO dao=new C12_2EmployeeDAO();
		System.out.println(dao.searchEmployees("thom"));
		System.out.println(dao.getAllEmployees());
	}//end of main
}
