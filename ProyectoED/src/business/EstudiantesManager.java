package business;
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
	public void displayNotas(int id) {
		Estudiante e=searchEstudiante(id);
		e.list_nota.DisplayList();
	}
	public double calcProme(int id) {
		Estudiante e=searchEstudiante(id);
		e.setPromedio(e.list_nota.sumaNota()/e.list_nota.NumeroElementos());
		return e.list_nota.sumaNota()/e.list_nota.NumeroElementos();
	}
}


