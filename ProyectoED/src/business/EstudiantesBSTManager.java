package business;

import data.BinaryTree;
import data.EstudianteBST;

public class EstudiantesBSTManager extends BinaryTree {
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
}
