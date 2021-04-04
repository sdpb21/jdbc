import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		ConexionBD objetoConexionBD=new ConexionBD();
		Scanner scan=new Scanner(System.in);
		System.out.print("Ingrese el nombre: ");
		String nombre=scan.nextLine();
		objetoConexionBD.getDatos(nombre);

	}

}
