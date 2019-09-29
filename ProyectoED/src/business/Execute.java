package business;
import data.*;
import java.util.*;
public class Execute {
	static AdminManager lst_admin = new AdminManager();
	static int pantalla=0;
	public static void main(String[] args) {
		lst_admin.addAdminUser(new Admin("juanse","123456"));
		lst_admin.addAdminUser(new Admin("crack","09786"));
		lst_admin.addAdminUser(new Admin("babb","12345444"));
		lst_admin.addAdminUser(new Admin("nel","1245"));
		lst_admin.addAdminUser(new Admin("trolazo","696969"));
		lst_admin.printUsers();
		//lst_admin.DisplayList();
		while(true) {
			pantalla_inicio();
		}
		
		
	}
	static void pantalla_inicio() {
		String temp_user,temp_password;
		Scanner scan = new Scanner(System.in);
		if(pantalla==0) {
			System.out.println("Bienvenido al Sistema de notas v1.0");
			System.out.println("Elija la acción que desea hacer: ");
			System.out.println("1-Iniciar sesión     2-Cerrar programa");
			pantalla=scan.nextInt();
			clearScreen();
		}
		else if(pantalla==1) {
			System.out.println("Ingrese el usuario y la contraseña");
			System.out.println("Usuario:");
			temp_user = scan.nextLine();
			System.out.println("Contraseña: ");
			temp_password = scan.nextLine();
			if(lst_admin.ValUser(new Admin(temp_user, temp_password))) {
				System.out.println("Acceso garantizado");
				pantalla=3;
				clearScreen();
			}else {
				clearScreen();
				System.out.println("Clave o usuario incorrecto");
			}
		}
		else if(pantalla==2) {
			return;
		}
		else if(pantalla==3) {
			System.out.println("Bienvenido: ");
			
		}
	}
	public static void clearScreen() {  
		for (int i = 0; i < 50; ++i) System.out.println();
	}

}
