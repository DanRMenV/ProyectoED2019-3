package business;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;

import data.*;

import java.util.*;
public class Execute {
	static AdminManager lst_admin = new AdminManager();
	static EstudiantesManager lst_stud = new EstudiantesManager();
	static int pantalla=0;
	static String temp_user="",temp_password="";
	public static void main(String[] args) {
		lst_admin.addAdminUser(new Admin("juanse","123456"));
		lst_admin.addAdminUser(new Admin("crack yo","09786"));
		lst_admin.addAdminUser(new Admin("babb","12345444"));
		lst_admin.addAdminUser(new Admin("nel","1245"));
		lst_admin.addAdminUser(new Admin("trolazo","696969"));
		//lst_admin.printUsers();
		//lst_admin.DisplayList();
		while(true) {
			pantalla_inicio();
		}	
	}

  
  static void pantalla_inicio() {
		EstudiantesManager em=new EstudiantesManager();
		
		/*System.out.println("Escriba id a buscar");
		String search=sc.nextLine();
		int idABuscar=Integer.parseInt(search);
				
		System.out.println(em.searchEstudiante(idABuscar).getNombre_estudiante());*/

		Scanner scan = new Scanner(System.in);
		if(pantalla==0) {
			//lst_admin.printUsers();
			System.out.println("Bienvenido al Sistema de notas v1.0");
			System.out.println("Elija la accionn que desea hacer: ");
			System.out.println("1-Iniciar sesion     2-Cerrar programa");
			pantalla=scan.nextInt();
		}
		else if(pantalla==1) {
			System.out.println("Ingrese el usuario y la contrasena");
			System.out.println("Usuario:");
			temp_user = scan.nextLine();
			System.out.println("Contrasena: ");
			temp_password = scan.nextLine();
			if(lst_admin.ValUser(new Admin(temp_user, temp_password))) {
				clearScreen();
				System.out.println("Acceso garantizado");
				pantalla=3;
				
			}else {
				clearScreen();
				System.out.println("Clave o usuario incorrecto");
			}
		}
		else if(pantalla==2) {
			return;
		}
		else if(pantalla==3) {
			System.out.println("Bienvenido: "+temp_user);
			System.out.println("Escoja la accipn que desea realizar: ");
			System.out.println("1- Anadir estudiante    2- Ver lista de estudiantes   3-Modificar estudiante");
			pantalla=scan.nextInt()+3;
			clearScreen();
		}
		else if(pantalla==4) {
			System.out.println("Anadir estudiante");
			String temp_nom,temp_apel;
			int temp_id,temp_day,temp_month,temp_year;
			System.out.println("Ingrese el documento de identidad: ");
			temp_id=scan.nextInt();
			scan.nextLine();
			System.out.println("Ingrese el nombre del estudiante: ");
			temp_nom=scan.nextLine();
			System.out.println("Ingrese el apellido del estudiante:");
			temp_apel=scan.nextLine();
			System.out.println("Ingrese el dia de nacimiento");
			temp_day=scan.nextInt();
			System.out.println("Ingrese el mes de nacimiento");
			temp_month=scan.nextInt();
			System.out.println("Ingrese el anio de nacimiento");
			temp_year=scan.nextInt();
			System.out.println(temp_nom+" "+temp_apel);
			Calendar fecha=new GregorianCalendar(temp_year,temp_month,temp_day);
			lst_stud.addEstudiante(new Estudiante(temp_id,temp_nom,temp_apel,fecha));
			System.out.println("Estudiante anadido ...");
			pantalla=3;
		}
		else if(pantalla==5) {
			lst_stud.listaEstudiantes();
			System.out.println("Presione una ENTER para regresar al inicio");
			scan.nextLine();
			pantalla=3;
		}
		else if(pantalla==6) {
			String nothing;
			int find_id;
			System.out.println("Ingrese el documento del estudiante a modificar");
			find_id=scan.nextInt();
			if(lst_stud.modificarEstudiante(find_id)==true) {
				int temp_option=0;
				Estudiante temp_stud=lst_stud.searchEstudiante(find_id);
				System.out.println("Seleccione el dato que desea modificar");
				System.out.println("1-Id, 2-Nombre, 3-Apellido, 4-Todos los campos, 5-Volver al inicio");
				temp_option=scan.nextInt();
				scan.nextLine();
				if(temp_option==1) {
					int temp_id;
					System.out.println("Ingrese el documento de identidad: ");
					temp_id=scan.nextInt();
					temp_stud.setId_estudiante(temp_id);
					
				}else if(temp_option==2) {
					String temp_nom;
					System.out.println("Ingrese el nombre del estudiante: ");
					temp_nom=scan.next();
					temp_stud.setNombre_estudiante(temp_nom);
				}else if(temp_option==3) {
					String temp_apell;
					System.out.println("Ingrese el apellido del estudiante:");
					temp_apell=scan.next();
					temp_stud.setApellido_estudiante(temp_apell);
				}else if(temp_option==4) {
					int temp_id;
					System.out.println("Ingrese el documento de identidad: ");
					temp_id=scan.nextInt();
					scan.nextLine();
					String temp_nom;
					System.out.println("Ingrese el nombre del estudiante: ");
					temp_nom=scan.nextLine();
					String temp_apell;
					System.out.println("Ingrese el apellido del estudiante:");
					temp_apell=scan.nextLine();
					temp_stud.setId_estudiante(temp_id);
					temp_stud.setNombre_estudiante(temp_nom);
					temp_stud.setApellido_estudiante(temp_apell);
				}else {
					clearScreen();
					pantalla=3;
				}
				System.out.println("Dato modificado...");
				System.out.println("Presione ENTER para volver al inicio");
				nothing=scan.nextLine();
				clearScreen();
				pantalla=3;
			}else {
				System.out.println("El estudiante buscado no esta en la lista...");
				System.out.println("Presione ENTER para volver al inicio");
				nothing=scan.nextLine();
				clearScreen();
				pantalla=3;
			}
		}
	}
	public static void clearScreen() {  
		for (int i = 0; i < 50; ++i) System.out.println();
	}

}
