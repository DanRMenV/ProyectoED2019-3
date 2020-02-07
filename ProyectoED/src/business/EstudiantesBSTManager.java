package business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.Scanner;

import data.*;

public class EstudiantesBSTManager{
	/*BinaryTree ListStudentBST;

	public EstudiantesBSTManager() {
		this.ListStudentBST =new BinaryTree();
	}

	public void addEstudianteBST(int id, String name, String surname, int dia, int mes, int year, int curso) {
		GregorianCalendar date = new GregorianCalendar(dia,mes,year);
		Estudiante nuevo=new Estudiante(id,name,surname,date,curso);

		this.ListStudentBST.insert(nuevo);
	}

	public EstudianteBST searchEstudianteBST(EstudianteBST root, int data){
		EstudianteBST e= ListStudentBST.Find(root, data);
		return e;
	}

	public EstudianteBST getRoot() {
		return ListStudentBST.getRoot();
	}


	public void displayNotas(EstudianteBST root, int data) {
		EstudianteBST e= ListStudentBST.Find(root, data);
		e.list_nota.DisplayList();
	}



	public void readStudents(String fileName) {
		int i=1;
		try {
			Scanner reader = new Scanner(new File(fileName));
			while(reader.hasNextLine()) {
				String name = reader.next();
				String surname = reader.next();
				int curso = reader.nextInt();
				int dia = (int) (Math.random() * 31) + 1;
				int mes = (int) (Math.random() * 12) + 1;
				int ano = (int) (Math.random() * 2018) + 2000;
				this.ListStudentBST.insert(i++,name,surname,dia,mes,ano,curso);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void AddNota(EstudianteBST student,double nota, String descr) {
		student.data.list_nota.PushBack(new Nota(descr,nota));
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
	*/
}
