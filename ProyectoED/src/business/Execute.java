package business;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;
import data.*;

import java.io.File;
import java.util.*;

public class Execute {
	static AdminManager hash_admin = new AdminManager();
	static HeapNota heap_prueba  = new HeapNota(100);
	
	
	
	static CursoManager lst_curso = new CursoManager();
	static int pantalla=9;
	static long temp_id;
	static String temp_password="";
	static long TInicio, TFin, tiempo;
	static boolean mostrar=true;
	static BinaryTree gen_stud = new BinaryTree();
	
	
	public static void main(String[] args) {
	
		heap_prueba.Insert(new Estudiante(1,4.1));
		heap_prueba.Insert(new Estudiante(2,1.0));
		heap_prueba.Insert(new Estudiante(3,3.9));
		heap_prueba.Insert(new Estudiante(4,4.8));
		heap_prueba.Insert(new Estudiante(5,1.5));
		heap_prueba.Insert(new Estudiante(6,2.8));
		
		hash_admin.addAdminUser(new Admin(1000274,"Juanse","123456"));
		hash_admin.addAdminUser(new Admin(1000123,"Mendivirus","654321"));
		hash_admin.addAdminUser(new Admin(1000654,"JuanP","123456"));
		hash_admin.addAdminUser(new Admin(696969,"nel","123456"));
		hash_admin.addAdminUser(new Admin(1,"Admin",""));

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
		//Los parametros de la funcion son: (id,nombre,apellido,dia,mes,anio,curso
		//Estudiantes de ejemplo de 1
		lst_curso.addEstudianteBST(1000, "juan", "pepe", 7, 7, 2007, 1);
		lst_curso.addEstudianteBST(1001, "andrie", "kws", 7, 5, 2007, 1);
		lst_curso.addEstudianteBST(1002, "steven", "cruck", 12, 5, 2007, 1);
		lst_curso.addEstudianteBST(1003, "san", "perez", 1, 2, 2008, 1);
		lst_curso.addEstudianteBST(1004, "amer", "nose", 7, 9, 2007, 1);
		lst_curso.addEstudianteBST(1005, "alex", "curz", 11, 5, 2007, 1);
		//Estudiantes de ejemplo de 2
		//Estudiantes de ejemplo de 3
		//Estudiantes de ejemplo de 4
		//Estudiantes de ejemplo de 5
		//Estudiantes de ejemplo de 6
		//Estudiantes de ejemplo de 7
		//Estudiantes de ejemplo de 8
		//Estudiantes de ejemplo de 9
		//Estudiantes de ejemplo de 10
		//Estudiantes de ejemplo de 11
		TInicio = System.currentTimeMillis();
		//lst_curso.readStudents("datos10000.txt");
		TFin = System.currentTimeMillis();  
		tiempo = TFin - TInicio;
		System.out.println("Tiempo de ejecuci�n en nanosegundos carga datos: " + tiempo);
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
			System.out.println("Ingrese el numero de identificación y la contrasena");
			System.out.println("Identificacion:");
			temp_id = scan.nextLong();
			scan.nextLine();
			System.out.println("Contrasena: ");
			temp_password = scan.nextLine();
			//System.out.println(temp_id+"----"+temp_password);
			if(hash_admin.ValUser(new Admin(temp_id, temp_password))==true) {
				clearScreen();
				System.out.println("Acceso garantizado");
				pantalla=9;
				
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
			int option = 0;
			
			
			
			System.out.println("Sistema BTS");
			System.out.println("Escoja la accion que desea realizar: ");
			System.out.println("1- Anadir estudiante    2- Ver todos de estudiantes   3-Ver lista por curso   4- ̶M̶o̶d̶i̶f̶i̶c̶a̶r̶ ̶e̶s̶t̶u̶d̶i̶a̶n̶t̶e̶ ̶p̶o̶r̶ ̶c̶u̶r̶s̶o̶  5-Modificar estudiante por id");
			System.out.println("6- A�adir nota curso   7- Ver promedio por cursos  8- ̶T̶e̶s̶t̶H̶e̶a̶p̶   9-Ver mejores promedios por curso   10- Mostrar estudiantes heap");
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
				System.out.println("Estudiante anadido ...");
				clearScreen();
			}else if(option == 2) {
				lst_curso.arbol_col.printStudentCurso();;
				
			}else if(option == 3) {
				
				System.out.println("Ingrese el curso a mostrar: ");
				int int_curs = scan.nextInt();
				Curso temp_curso = lst_curso.FindCurso(int_curs);
				temp_curso.students_curso.printStudentCurso();
				
			}else if(option == 4) {
				option = 0;
			} if(option == 5) {
				int temp_option=0;
				System.out.println("Ingrese el documento del estudiante");
				int find_id = scan.nextInt();
				Estudiante temp_est = null;
				EstudianteBST temp_root ;
				temp_est = lst_curso.arbol_col.Find(find_id).data;
				if(temp_est == null) {
					System.out.println("Estudiante no encontrado");
					return ;
				}
				if(temp_est.getId_estudiante() != find_id) {
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
			}else if(option == 6) {
				System.out.println("Seleccione el curso para anadir nota");
				int int_curs = scan.nextInt();
				Curso temp_curso = lst_curso.FindCurso(int_curs);
				EstudianteBST temp_root = lst_curso.FindCurso(int_curs).students_curso.getRoot();
				System.out.println("Ingrese la decripcion de la nota: ");
				String temp_desc = scan.next();
				//lst_curso.FindCurso(int_curs).students_curso.addNotaCurso(temp_root, temp_desc);
				temp_curso.setSum_total(0);
				temp_curso.sumaTotal(temp_root);
				temp_curso.calcProm();
				System.out.println("Promedio curso: "+temp_curso.getProm_curso());
				
			}else if(option == 7) {
				lst_curso.listaEstudiantes();
			}else if(option == 8) {
				int heapTest = 0;
				System.out.println(" ");
				System.out.println("HeapStudent Test");
				System.out.println("1- anadir estudiante   2- Buscar estudiante    3-Ver 5 mejores promedios    4- modificar promedio estudiante   5-Mostrar estudiantes guardados ");
				heapTest = scan.nextInt();
				if(heapTest == 1) {
					double temProm = 0.0;
					int tempId;
					System.out.println("Ingrese el documento del estudiante");
					tempId = scan.nextInt();
					System.out.println("Ingrese el promedio del estudiante");
					temProm = scan.nextDouble();
					Estudiante nuevo = new Estudiante(tempId,temProm);
					heap_prueba.Insert(nuevo);
				}
				if(heapTest == 2) {
					int tempId;
					System.out.println("Ingrese el documento del estudiante");
					tempId = scan.nextInt();
					System.out.println(heap_prueba.posFind(tempId));
				}
				if(heapTest == 3) {
					heap_prueba.mejProm();
				}
				if(heapTest == 4) {
					int tempId;
					double tempProm;
					System.out.println("Inserte el documento: ");
					tempId = scan.nextInt();
					System.out.println("Inserte el promedio: ");
					tempProm = scan.nextDouble();
					heap_prueba.modProm(tempId, tempProm);
				}
				if(heapTest == 5) {
					heap_prueba.printEst();
				}
				
			}else if(option == 9) {
				int temp_cur;
				System.out.println("Ingrese el curso a mostrar");
				temp_cur = scan.nextInt();
				Curso temp_curso = lst_curso.FindCurso(temp_cur);
				temp_curso.heap_curso.mejProm();
			}else if(option == 10) {
				int temp_cur;
				System.out.println("Ingrese el curso a mostrar");
				temp_cur = scan.nextInt();
				Curso temp_curso = lst_curso.FindCurso(temp_cur);
				temp_curso.heap_curso.printEst();
			}
		}else {
			mostrar=false;
		}
	}
  
	public static void clearScreen() {  
		for (int i = 0; i < 50; ++i) System.out.println();
	}
	
	
	

}