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
	
}
	
}

