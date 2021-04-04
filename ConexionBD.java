import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBD {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	//Constructor
	public ConexionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/salvadora","root","K1n9-cr1m50n");
			st=con.createStatement();
			/*String query="insert into cliente (CI,nombre,apellido,direccion,telefono) values (123456,'carlos','perez','san antonio',1471)";
			st.executeUpdate(query);
			System.out.println("Un nuevo usuario fue ingresado.");*/
			/*String query="update cliente set nombre='txulio' where CI=123456";
			st.executeUpdate(query);
			System.out.println("Se acaba de actualizar un usuario.");*/
			/*String query="delete from cliente where nombre='txulio'";
			st.executeUpdate(query);
			System.out.println("Un usuario fue eliminado");*/
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	//metodo
	public void getDatos(String nombreIngresado) {
		try {
			//String query="select * from producto";
			String query="select * from producto where nombre like '%"+nombreIngresado+"%'";
			rs=st.executeQuery(query);

			while(rs.next()) {
				String nombre=rs.getString("NOMBRE");
				String marca=rs.getString("MARCA");
				String color=rs.getString("COLOR");
				System.out.println("Nombre "+nombre+"\tMarca "+marca+"\tColor "+color);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
