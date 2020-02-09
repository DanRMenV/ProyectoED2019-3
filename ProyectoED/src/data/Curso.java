package data;

import business.EstudiantesBSTManager;

public class Curso {
	int id_curso;
	public int num_stud;
	String name;
	public double sum_total;
	double prom_curso;
	public BinaryTree students_curso;
	public HeapNota heap_curso;
  
	public Curso(int id_curso, String name) {
		super();
		this.id_curso = id_curso;
		this.name = name;
		students_curso = new BinaryTree();
		heap_curso = new HeapNota(1000);
	}
	public void addNumStud() {
		this.num_stud++;
	}

	@Override
	public String toString() {
		return "Curso  =" + name + " Numero estudiantes = "+num_stud+"  prom_curso=" + prom_curso;
	}
	public void calcProm() {
		this.prom_curso = sum_total / num_stud;		
	}
	public void sumaTotal(EstudianteBST raiz) {
		if(raiz == null)return ;
		if(raiz.left != null) {
			sumaTotal(raiz.left);
		}
		sum_total = sum_total + raiz.data.getPromedio();
		if(raiz.right != null) {
			sumaTotal(raiz.right);
		}
	}
	public double getProm_curso() {
		return prom_curso;
	}
	public void setSum_total(double sum_total) {
		this.sum_total = sum_total;
	}

	
}
