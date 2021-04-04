import	java.sql.Connection;
import java.sql.DriverManager;
import	java.sql.Statement;

public class C02InsertDataIntoMysqlDatabase {

	public static void main(String[] args) {
		Connection myConnection=null;
		Statement myStatement=null;

		try {
			//1. get a connection to database
			myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","K1n9-cr1m50n");
			//2. create a statement
			myStatement=myConnection.createStatement();
			//3. execute SQL query
			String sql="insert into employees (last_name,first_name,email)"
					  +" values ('Brown','David','david.brown@foo.com')";
			myStatement.executeUpdate(sql);

			System.out.println("Insert complete.");
		}
	}

}
/*create database if not exists demo;

use demo;
 
drop table if exists employees;
 
CREATE TABLE `employees` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`last_name` varchar(64) DEFAULT NULL,
`first_name` varchar(64) DEFAULT NULL,
`email` varchar(64) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
 
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`) VALUES (1,'Doe','John','john.doe@foo.com');
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`) VALUES (2,'Public','Mary','mary.public@foo.com');
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`) VALUES (3,'Queue','Susan','susan.queue@foo.com');*/