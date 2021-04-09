import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.Statement;
import	java.sql.PreparedStatement;
import	java.sql.ResultSet;
import java.sql.SQLException;
import	java.util.Scanner;

public class C07Transactions {

	public static void main(String[] args) throws SQLException {
		Connection connectionObject=null;
		Statement statementObject=null;
		try {
			//get a connection to database object
			connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			//turn off auto commit
			connectionObject.setAutoCommit(false);
			//show salaries before the change
			System.out.println("Salaries before statement execute:");
			showSalaries(connectionObject,"HR");
			showSalaries(connectionObject,"Engineering");
			//Transaction step 1: delete all HR employees
			statementObject=connectionObject.createStatement();
			statementObject.executeUpdate("delete from employees where department='HR'");
			//Transaction step 2: set salaries to 300000 for all in the Engineering department
			statementObject.executeUpdate("update employees set salary=300000 where department='Engineering'");
			System.out.println("\n>> Transaction steps completed\n");
			// ask the user if really wish to save
			boolean ok=askUserIfOkToSave();
			if(ok) {
				//store in database
				connectionObject.commit();
				System.out.println("\n>> Transaction commited\n");
			}else {
				//discard
				connectionObject.rollback();
				System.out.println("\n>> Transaction rolled back\n");
			}
			//show salaries after answer yes or no
			System.out.println("Salaries after answering yes or no\n");
			showSalaries(connectionObject,"HR");
			showSalaries(connectionObject,"Engineering");
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			close(connectionObject,statementObject,null);
		}
	}
	private static void showSalaries(Connection connectionObject2,String department) throws SQLException {
		PreparedStatement preparedStatementObject=null;
		ResultSet resultSetObject=null;

		System.out.println("Show salaries for department: "+department);
		try {
			//prepare statement
			preparedStatementObject=connectionObject2.prepareStatement("select * from employees where department=?");
			preparedStatementObject.setString(1, department);
			//execute sql query
			resultSetObject=preparedStatementObject.executeQuery();
			//process result set
			while(resultSetObject.next()) {
				String lastName=resultSetObject.getString("last_name");
				String firstName=resultSetObject.getString("first_name");
				double salary=resultSetObject.getDouble("salary");
				String department2=resultSetObject.getString("department");
				System.out.printf("%s, %s, %s, %.2f\n",lastName,firstName,department,salary);
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			close(preparedStatementObject,resultSetObject);
		}
	}
	private static void close(Connection connectionObject3,Statement statementObject2,ResultSet resultSetObject) throws SQLException {
		if(resultSetObject!=null) {
			resultSetObject.close();
		}
		if(statementObject2!=null) {
			statementObject2.close();
		}
		if(connectionObject3!=null) {
			connectionObject3.close();
		}
	}
	private static void close(Statement statementObject,ResultSet resultSetObject) throws SQLException {
		close(null,statementObject,resultSetObject);
	}
	private static boolean askUserIfOkToSave() {
		Scanner scannerObject=new Scanner(System.in);

		System.out.println("Is it ok to save? yes/no: ");
		String input=scannerObject.nextLine();
		scannerObject.close();
		return input.equalsIgnoreCase("yes");
	}
}
