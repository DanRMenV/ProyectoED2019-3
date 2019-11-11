package business;

import java.util.Scanner;

import data.BinaryTree;
import data.Estudiante;
import data.EstudianteBST;
import data.Nota;

public class EstudiantesBSTManager extends BinaryTree {
	Scanner scan = new Scanner(System.in);
	public void printStudentCurso (EstudianteBST root) {
		EstudianteBST raiz = root;
		if(raiz == null)return ;
		if(raiz.left != null) {
			printStudentCurso(raiz.left);
		}
		System.out.println("Documento de identidad: "+raiz.getId_estudiante()+" Nombre: "+raiz.getNombre_estudiante()+" "+raiz.getApellido_estudiante()+" Edad: "+raiz.getEdad()+" Promedio: "+raiz.getPromedio()+" Curso: "+raiz.getCurso());
		if(raiz.right != null) {
			printStudentCurso(raiz.right);
		}
	}
	public void addNotaCurso(EstudianteBST root, String desc) {
		EstudianteBST raiz = root;
		if(raiz == null)return ;
		if(raiz.left != null) {
			addNotaCurso(raiz.left,desc);
		}
		System.out.println("Documento de identidad: "+raiz.getId_estudiante()+" Nombre: "+raiz.getNombre_estudiante()+" "+raiz.getApellido_estudiante()+" Edad: "+raiz.getEdad()+" Promedio: "+raiz.getPromedio()+" Curso: "+raiz.getCurso());
		raiz.list_nota.PushBack(new Nota(desc,scan.nextDouble()));
		calcProme(raiz);
		raiz.list_nota.DisplayList();
		if(raiz.right != null) {
			addNotaCurso(raiz.right,desc);
		}
	}
	public double calcProme(EstudianteBST est) {
		est.setPromedio(est.list_nota.sumaNota()/est.list_nota.NumeroElementos());
		return est.list_nota.sumaNota()/est.list_nota.NumeroElementos();
	}
}
