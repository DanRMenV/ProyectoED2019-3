/*package business;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.Scanner;

import data.*;

public class EstudiantesManager {
	ListStudent lista_estudiantes;

	public EstudiantesManager() {
		this.lista_estudiantes =new ListStudent();
	}
	
	public void addEstudiante(Estudiante e) {
		this.lista_estudiantes.PushBack(e);
	}

	public void listaEstudiantes() {
		this.lista_estudiantes.DisplayList();
	}

	public Estudiante searchEstudiante(int id){
		Estudiante e= lista_estudiantes.FindStudent(id);
		return e;		
	}

	public boolean modificarEstudiante(int id) {
		return lista_estudiantes.ExistStudent(id);
	}
	
	public int NumEstud() {
		return lista_estudiantes.NumeroElementos();
	}
	
	public void AddNota(int id,double nota, String descr) {
		Estudiante e=searchEstudiante(id);
		e.list_nota.PushBack(new Nota(descr,nota));
	}
	public void AddNota(EstudianteBST student,double nota, String descr) {
		student.data.list_nota.PushBack(new Nota(descr,nota));
	}
	public void displayNotas(int id) {
		Estudiante e=searchEstudiante(id);
		e.list_nota.DisplayList();
	}
	
	public double calcProme(int id) {
		Estudiante e=searchEstudiante(id);
		e.setPromedio(e.list_nota.sumaNota()/e.list_nota.NumeroElementos());
		return e.list_nota.sumaNota()/e.list_nota.NumeroElementos();
	}
	
	public void readStudents(String fileName) {
		int i=1;
		try {
			Scanner reader = new Scanner(new File(fileName));
			while(reader.hasNextLine()) {
				String est = reader.nextLine();
				Estudiante es = createEstudiante(est,i++);
				this.lista_estudiantes.PushBack(es);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Estudiante createEstudiante(String text,int id) {
		Scanner sc = new Scanner(text);
		sc.useDelimiter(",");
		String name = sc.next();
		String surname = sc.next();		
		int curso = Integer.parseInt(sc.next());
		sc.close();
		return new Estudiante(id,name,surname,new GregorianCalendar(2000,01,01),curso);
	}

}
*/

//Temporalmente comentado por no saber lo que hace lol

