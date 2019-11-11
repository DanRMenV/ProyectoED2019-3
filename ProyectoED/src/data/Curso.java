package data;

import business.EstudiantesBSTManager;

public class Curso {
	int id_curso;
	String name;
	float prom_curso;
	public EstudiantesBSTManager est_curso;
	public Curso(int id_curso, String name) {
		super();
		this.id_curso = id_curso;
		this.name = name;
		est_curso = new EstudiantesBSTManager();
	}
	@Override
	public String toString() {
		return "Curso  =" + name + ", prom_curso=" + prom_curso;
	}
	
}
