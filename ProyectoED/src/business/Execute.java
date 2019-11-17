package business;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;
import data.*;

import java.io.File;
import java.util.*;

public class Execute {
	static AdminManager lst_admin = new AdminManager();
	//static EstudiantesManager lst_stud = new EstudiantesManager();
	static CursoManager lst_curso = new CursoManager();
	static int pantalla=9;
	static String temp_user="",temp_password="";
	static long TInicio, TFin, tiempo;
	static boolean mostrar=true;
	public static void main(String[] args) {
		lst_admin.addAdminUser(new Admin("juanse","123456"));
		lst_admin.addAdminUser(new Admin("crack yo","09786"));
		lst_admin.addAdminUser(new Admin("babb","12345444"));
		lst_admin.addAdminUser(new Admin("nel","1245"));
		lst_admin.addAdminUser(new Admin("trolazo","696969"));
		for(int a=1; a<=11; a++) {
			String name;
			if(a == 1)name="Primero";
			else if(a == 2)name="Segundo";
			else if(a == 3)name="Tercero";
			else if(a == 4)name="Cuarto";
			else if(a == 5)name="Quinto";
			else if(a == 6)name="Sexto";
			else if(a == 7)name="Septimo";
			else if(a == 8)name="Octavo";
			else if(a == 9)name="Noveno";
			else if(a == 10)name="Decimo";
			else name="Undecimo";
			lst_curso.addCurso(new Curso(a,name));
		}
		/*lst_curso.FindCurso(1).students_curso.addEstudianteBST(3, "s", "r", 7, 7, 2007, 1);
		lst_curso.FindCurso(1).addNumStud();
		lst_curso.FindCurso(1).students_curso.addEstudianteBST(1, "s4", "rdfg", 7, 7, 2007, 1);
		lst_curso.FindCurso(1).addNumStud();
		lst_curso.FindCurso(1).students_curso.addEstudianteBST(5, "s3", "rdgg", 7, 7, 2007, 1);
		lst_curso.FindCurso(1).addNumStud();
		lst_curso.FindCurso(1).students_curso.addEstudianteBST(6, "s5tg", "sdfsdfr", 7, 7, 2007, 1);
		lst_curso.FindCurso(1).addNumStud();
		lst_curso.FindCurso(1).students_curso.addEstudianteBST(7, "sdf", "rdddd", 7, 7, 2007, 1);
		lst_curso.FindCurso(1).addNumStud();*/

		lst_curso.addEstudianteBST(7, "sdf", "rdddd", 7, 7, 2007, 1);
		
		TInicio = System.currentTimeMillis();
		lst_curso.readStudents("datosPrueba10000.txt");
		TFin = System.currentTimeMillis();  
		tiempo = TFin - TInicio;
		System.out.println("Tiempo de ejecuci�n en nanosegundos carga datos: " + tiempo);

		//lst_curso.students_of_curso(1);
		//Aca se imprime la informacion basica del curso
		
		//lst_curso.listaEstudiantes();
		//lst_admin.printUsers();
		
		
		//TInicio = System.currentTimeMillis(); 
		//lst_stud.readStudents("ProyectoED/datosPrueba100.txt");

		/*TFin = System.currentTimeMillis();  
		tiempo = TFin - TInicio;
		System.out.println("Tiempo de ejecuci�n en nanosegundos carga datos: " + tiempo); 
		
		TInicio = System.currentTimeMillis(); 
		//lst_stud.searchEstudianteBST(10);
		TFin = System.currentTimeMillis(); 
		tiempo = TFin - TInicio;
		System.out.println("Tiempo de ejecuci�n en mili consulta 1 dato: " + tiempo); 
		*/
		while(mostrar) {
			pantalla_inicio();
		}	
	}

  static void pantalla_inicio() {
  		Scanner scan = new Scanner(System.in);
		if(pantalla==0) {
			//lst_admin.printUsers();
			System.out.println("Bienvenido al Sistema de notas v1.0");
			System.out.println("Elija la accion que desea hacer: ");
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
		/*else if(pantalla==3) {
			System.out.println("Bienvenido: "+temp_user);
			System.out.println("Escoja la accion que desea realizar: ");
			System.out.println("1- Anadir estudiante    2- Ver lista de estudiantes   3-Modificar estudiante   4-Anadir nota estudiante   5-Historia academica estudiante");
			System.out.println("6- Para entrar el sistema en de estudiantes en BTS");
			pantalla=scan.nextInt()+3;
			clearScreen();
		}
		else if(pantalla==4) {
			System.out.println("Anadir estudiante");
			String temp_nom,temp_apel;
			int temp_id,temp_day,temp_month,temp_year,temp_curso;
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
			System.out.println("Ingrese el curso actual");
			temp_curso=scan.nextInt();
			Calendar fecha=new GregorianCalendar(temp_year,temp_month,temp_day);
			lst_stud.addEstudiante(new Estudiante(temp_id,temp_nom,temp_apel,fecha,""));
			System.out.println("Estudiante anadido ...");
			pantalla=3;
		}
		else if(pantalla==5) {
			System.out.println("Numero de estudiates registrados: "+lst_stud.NumEstud());
			TInicio = System.currentTimeMillis();
			lst_stud.listaEstudiantes();
			TFin = System.currentTimeMillis(); 
			tiempo = TFin - TInicio;
			System.out.println("Tiempo de ejecuci�n en milisegundos: " + tiempo); 
			System.out.println("Presione una ENTER para regresar al inicio");
			scan.nextLine();
			clearScreen();
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
		}else if(pantalla == 7) {
			int temp_id,temp_opc;
			double temp_nota;
			String temp_desc;
			System.out.println("Ingrese la identificacion del estudiante a anadir nota: (-999 inicio)");
			temp_id=scan.nextInt();
			if(temp_id==-999) {
				pantalla=3;
				clearScreen();
				return;
			}
			while(lst_stud.modificarEstudiante(temp_id)==false) {
				System.out.println("Estudiante no encontrado...");
				System.out.println("Ingrese la identificacion del estudiante a anadir nota: (-999 inicio)");
				scan.nextLine();
				temp_id=scan.nextInt();
				if(temp_id==-999) {
					pantalla=3;
					clearScreen();
					return;
				}
			}
			System.out.println("Estas son las notas registradas del estudiante: ");
			lst_stud.displayNotas(temp_id);
			System.out.println("Anada la descripcion de la nota: ");
			scan.nextLine();
			temp_desc=scan.nextLine();
			System.out.println("Anada la calificacion obtenida: ");
			temp_nota=scan.nextDouble();
			lst_stud.AddNota(temp_id, temp_nota, temp_desc);
			System.out.println("Calificacion anadida");
			lst_stud.calcProme(temp_id);
			System.out.println("Desea anadir mas notas?(1 - si, 0 - no)");
			temp_opc=scan.nextInt();
			while(temp_opc == 1) {
				System.out.println("Anada la descripcion de la nota: ");
				scan.nextLine();
				temp_desc=scan.nextLine();
				System.out.println("Anada la calificacion obtenida: ");
				temp_nota=scan.nextDouble();
				lst_stud.AddNota(temp_id, temp_nota, temp_desc);
				System.out.println("Calificacion anadida");
				lst_stud.calcProme(temp_id);
				System.out.println("Desea anadir mas notas?(1 - si, 0 - no)");
				temp_opc=scan.nextInt();
			}
			pantalla=3;
			clearScreen();
		}else if(pantalla == 8) {
			int temp_id;
			String nothing;
			System.out.println("Ingrese la identificacion del estudiante para ver historia academica: (-999 inicio)");
			temp_id=scan.nextInt();
			if(temp_id==-999) {
				pantalla=3;
				clearScreen();
				return;
			}
			while(lst_stud.modificarEstudiante(temp_id)==false) {
				System.out.println("Estudiante no encontrado...");
				System.out.println("Ingrese la identificacion del estudiante para ver historia academica (-999 inicio)");
				temp_id=scan.nextInt();
				if(temp_id==-999) {
					pantalla=3;
					clearScreen();
					return;
				}
			}
			System.out.println("Las notas del estudiante han sido: ");
			lst_stud.displayNotas(temp_id);
			System.out.println();
			System.out.println("Promedio:   "+lst_stud.calcProme(temp_id));
			System.out.println("Presione ENTER para volver al inicio");
			scan.nextLine();
			nothing=scan.nextLine();
			clearScreen();
			pantalla=3;
		}*/else if(pantalla == 9){
			int option;
			System.out.println("Sistema BTS");
			System.out.println("Escoja la accion que desea realizar: ");
			System.out.println("1- Anadir estudiante    2- Ver todos de estudiantes   3-Ver lista por curso   4-Modificar estudiante por curso  5-Modificar estudiante por id");
			System.out.println("6- A�adir nota curso   7- Ver promedio por cursos");
			option = scan.nextInt();
			clearScreen();
			if(option == 1) {
				System.out.println("Anadir estudiante: ");
				System.out.println("Seleccione el curso al cual va a anadir el estudiante");
				int int_curs = scan.nextInt();
				Curso temp_curso = lst_curso.FindCurso(int_curs);
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
				lst_curso.addEstudianteBST(temp_id, temp_nom, temp_apel, temp_day, temp_month,temp_year, int_curs);
				lst_curso.FindCurso(int_curs).addNumStud();
				System.out.println("Estudiante anadido ...");
				clearScreen();
			}else if(option == 2) {
				for(int a=1; a<=11; a++) {
					Curso temp_curso = lst_curso.FindCurso(a);
					EstudianteBST temp_root = lst_curso.FindCurso(a).students_curso.getRoot();
					//lst_curso.printStudentCurso(temp_root);
					lst_curso.FindCurso(a).students_curso.printStudentCurso(temp_root);
				}
			}else if(option == 3) {
				int int_curs = scan.nextInt();
				Curso temp_curso = lst_curso.FindCurso(int_curs);
				EstudianteBST temp_root =lst_curso.FindCurso(int_curs).students_curso.getRoot();
				//lst_curso.printStudentCurso(temp_root);
				lst_curso.FindCurso(int_curs).students_curso.printStudentCurso(temp_root);
			}else if(option == 4) {
				int temp_option=0;
				System.out.println("Ingrese el curso del estudiante");
				int int_curs=scan.nextInt();
				Curso temp_curso = lst_curso.FindCurso(int_curs);
				EstudianteBST temp_root = lst_curso.FindCurso(int_curs).students_curso.getRoot();
				System.out.println("Ingrese el documento del estudiante");
				int find_id = scan.nextInt();
				//EstudianteBST temp_stud=lst_curso.searchEstudianteBST(temp_root, find_id, int_curs);
				Estudiante temp_stud=lst_curso.searchEstudianteBST(temp_root, find_id, int_curs);
				if(temp_stud == null) {
					System.out.println("Estudiante no encontrado");
					return ;
				}
				System.out.println(temp_stud.toString());
				System.out.println("Seleccione el dato que desea modificar");
				System.out.println("1-Nombre, 2-Apellido, 3-Fecha de nacimiento, 4-Todos los campos, 5-Volver al inicio");
				temp_option=scan.nextInt();
				scan.nextLine();
				if(temp_option==1) {
					String temp_nom;
					System.out.println("Ingrese el nombre del estudiante: ");
					temp_nom=scan.next();
					temp_stud.setNombre_estudiante(temp_nom);
					
				}else if(temp_option==2) {
					String temp_apell;
					System.out.println("Ingrese el apellido del estudiante:");
					temp_apell=scan.next();
					temp_stud.setApellido_estudiante(temp_apell);
				}else if(temp_option==3) {
					System.out.println("Ingrese el dia");
					int temp_dia = scan.nextInt();
					System.out.println("Ingrese el mes");
					int temp_mes = scan.nextInt();
					System.out.println("Ingrese el anio");
					int temp_anio = scan.nextInt();
					temp_stud.setDate(temp_dia, temp_mes, temp_anio);
				}else if(temp_option==4) {
					String temp_nom;
					System.out.println("Ingrese el nombre del estudiante: ");
					temp_nom=scan.nextLine();
					String temp_apell;
					System.out.println("Ingrese el apellido del estudiante:");
					temp_apell=scan.nextLine();
					System.out.println("Ingrese el dia");
					int temp_dia = scan.nextInt();
					System.out.println("Ingrese el mes");
					int temp_mes = scan.nextInt();
					System.out.println("Ingrese el anio");
					int temp_anio = scan.nextInt();
					temp_stud.setNombre_estudiante(temp_nom);
					temp_stud.setApellido_estudiante(temp_apell);
					temp_stud.setDate(temp_dia, temp_mes, temp_anio);
				}else {
					clearScreen();
					pantalla=9;
				}
				System.out.println("Dato modificado...");
				System.out.println("Presione ENTER para volver al inicio");
				clearScreen();
			}
			else if(option == 5) {
				int temp_option=0;
				System.out.println("Ingrese el documento del estudiante");
				int find_id = scan.nextInt();
				Estudiante temp_est = null;
				EstudianteBST temp_root ;
				for(int a=1; a<=11; a++) {
					Curso temp_curso = lst_curso.FindCurso(a);
					temp_root = lst_curso.FindCurso(a).students_curso.getRoot();
					temp_est = lst_curso.searchEstudianteBST(temp_root, find_id,a);
					if(temp_est != null) {
						if(temp_est.getId_estudiante() == find_id)break;
					}
				}
				if(temp_est == null) {
					System.out.println("Estudiante no encontrado");
					return ;
				}
				System.out.println(temp_est.toString());
				System.out.println("Seleccione el dato que desea modificar");
				System.out.println("1-Nombre, 2-Apellido, 3-Fecha de nacimiento, 4-Todos los campos, 5-Volver al inicio");
				temp_option=scan.nextInt();
				scan.nextLine();
				if(temp_option==1) {
					String temp_nom;
					System.out.println("Ingrese el nombre del estudiante: ");
					temp_nom=scan.next();
					temp_est.setNombre_estudiante(temp_nom);
					
				}else if(temp_option==2) {
					String temp_apell;
					System.out.println("Ingrese el apellido del estudiante:");
					temp_apell=scan.next();
					temp_est.setApellido_estudiante(temp_apell);
				}else if(temp_option==3) {
					System.out.println("Ingrese el dia");
					int temp_dia = scan.nextInt();
					System.out.println("Ingrese el mes");
					int temp_mes = scan.nextInt();
					System.out.println("Ingrese el anio");
					int temp_anio = scan.nextInt();
					temp_est.setDate(temp_dia, temp_mes, temp_anio);
				}else if(temp_option==4) {
					String temp_nom;
					System.out.println("Ingrese el nombre del estudiante: ");
					temp_nom=scan.nextLine();
					String temp_apell;
					System.out.println("Ingrese el apellido del estudiante:");
					temp_apell=scan.nextLine();
					System.out.println("Ingrese el dia");
					int temp_dia = scan.nextInt();
					System.out.println("Ingrese el mes");
					int temp_mes = scan.nextInt();
					System.out.println("Ingrese el anio");
					int temp_anio = scan.nextInt();
					temp_est.setNombre_estudiante(temp_nom);
					temp_est.setApellido_estudiante(temp_apell);
					temp_est.setDate(temp_dia, temp_mes, temp_anio);
				}else {
					clearScreen();
					pantalla=9;
				}
				System.out.println("Dato modificado...");
				System.out.println("Presione ENTER para volver al inicio");
				clearScreen();
			}
			else if(option == 6) {
				System.out.println("Seleccione el curso para anadir nota");
				int int_curs = scan.nextInt();
				Curso temp_curso = lst_curso.FindCurso(int_curs);
				EstudianteBST temp_root = lst_curso.FindCurso(int_curs).students_curso.getRoot();
				System.out.println("Ingrese la decripcion de la nota: ");
				String temp_desc = scan.next();
				lst_curso.FindCurso(int_curs).students_curso.addNotaCurso(temp_root, temp_desc);
				temp_curso.setSum_total(0);
				temp_curso.sumaTotal(temp_root);
				temp_curso.calcProm();
				System.out.println("Promedio curso: "+temp_curso.getProm_curso());
				
			}else if(option == 7) {
				lst_curso.listaEstudiantes();
			}
		}else {
			mostrar=false;
		}
	}
  
	public static void clearScreen() {  
		for (int i = 0; i < 50; ++i) System.out.println();
	}
	
	
	

}