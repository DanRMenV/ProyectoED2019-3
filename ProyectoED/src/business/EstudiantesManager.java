package business;
import data.*;

public class EstudiantesManager {
	DoubleLinkedList<Estudiante> lista_estudiantes;

	public EstudiantesManager() {
		this.lista_estudiantes =new DoubleLinkedList<Estudiante>();
	}
	
	public void addEstudiante(Estudiante e) {
		this.lista_estudiantes.PushBack(e);
	}
	
	/*public Estudiante searchEstudiante(int id){
		
	}*/
	
}
