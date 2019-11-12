package business;

import data.Curso;
import data.EstudianteBST;
import data.ListCurso;

public class CursoManager {
    ListCurso lista_curso;

    public CursoManager() {
        this.lista_curso = new ListCurso();
    }
    public void addCurso(Curso e) {
        this.lista_curso.PushBack(e);
    }
    public void listaEstudiantes() {
        this.lista_curso.DisplayList();
    }
    public  Curso FindCurso(int id) {
        return lista_curso.FindCurso(id);
    }
    
    

}
