package business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.Scanner;

import data.Curso;
import data.Estudiante;
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
    
    /*public void readStudents(String fileName) {
        int i=1;
        try {
            Scanner reader = new Scanner(new File(fileName));
            while(reader.hasNextLine()) {
                reader.useDelimiter(",");
                String name = reader.next();
                String surname = reader.next();
                int curso = Integer.parseInt(reader.next());
                int dia = (int) (Math.random() * 31) + 1;
                int mes = (int) (Math.random() * 12) + 1;
                int a�o = (int) (Math.random() * 2018) + 2000;

                this.lista_curso.FindCurso(curso).est_curso.addEstudianteBST(i++,name,surname,dia,mes,a�o,curso);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } */


	public void addEstudianteBST(int id, String name, String surname, int dia, int mes, int year, int curso) {
		GregorianCalendar date=new GregorianCalendar(year,mes,dia);
		Estudiante nuevo=new Estudiante(id,name,surname,date,curso);
		this.lista_curso.FindCurso(curso).students_curso.insert(nuevo);

	}

	public Estudiante searchEstudianteBST(EstudianteBST root, int id,int curso){
		//EstudianteBST e= ListStudentBST.Find(root, data);
		Estudiante e=lista_curso.FindCurso(curso).students_curso.Find(root,id).data;

		return e;
	}

	public EstudianteBST getRoot(int curso) {
		return lista_curso.FindCurso(curso).students_curso.getRoot();
	}

	public int students_of_curso(int curso){
		return lista_curso.FindCurso(curso).students_curso.getNumEst();
	}

    public void readStudents(String fileName) {
		int i=1;
		try {
			Scanner reader = new Scanner(new File(fileName));
			while(reader.hasNextLine()) {
				String est = reader.nextLine();
				createEstudiante(est);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*private void createEstudiante(String text,int id) {
		Scanner sc = new Scanner(text);
		sc.useDelimiter(",");
		String name = sc.next();
		String surname = sc.next();		
		int curso = Integer.parseInt(sc.next());
		sc.close();
		int dia = (int) (Math.random() * 31) + 1;
        int mes = (int) (Math.random() * 12) + 1;
        int ano = (int) (Math.random() * 2018) + 2000;
        addEstudianteBST(id,name,surname,dia,mes,ano,curso);
	}*/
    
    private void createEstudiante(String text) {
		Scanner sc = new Scanner(text);
		sc.useDelimiter(";");
		String name = sc.next();
		String surname = sc.next();
		int dia = sc.nextInt();
        int mes = sc.nextInt();
        int ano = sc.nextInt();
		int curso = sc.nextInt();
		int id = sc.nextInt();
		sc.close();
        addEstudianteBST(id,name,surname,dia,mes,ano,curso);
	}
    
    

}
