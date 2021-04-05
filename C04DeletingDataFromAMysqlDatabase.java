import	java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import	java.sql.Statement;

public class C04DeletingDataFromAMysqlDatabase {

	public static void main(String[] args) throws SQLException {
		Connection myConnection=null;
		Statement myStatement=null;

		try {//jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n
			//1- get a connection to database
			myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			//2. create a statement
			myStatement=myConnection.createStatement();
			//3. execute SQL query
			String sql="delete from employees where last_name='Brown'";
			int rowsAffected=myStatement.executeUpdate(sql);

			System.out.println("Rows affected: "+rowsAffected);
			System.out.println("Delete completed.");
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			if(myStatement!=null) {
				myStatement.close();
			}
			if(myConnection!=null) {
				myConnection.close();
			}
		}
	}

}
