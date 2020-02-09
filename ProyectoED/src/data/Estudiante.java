package data;
import business.*;

import java.time.Period;
import java.util.*;

public class Estudiante {
	int id_estudiante;
	String nombre_estudiante;
	String apellido_estudiante;
	Calendar fecha_nacimiento;
	Integer edad;
	//public ListNotas list_nota;
	public ListMaterias list_materias;
	
	int curso;
	double promedio=0;
	
	public int getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getNombre_estudiante() {
		return nombre_estudiante;
	}

	public void setNombre_estudiante(String nombre_estudiante) {
		this.nombre_estudiante = nombre_estudiante;
	}

	public String getApellido_estudiante() {
		return apellido_estudiante;
	}

	public void setApellido_estudiante(String apellido_estudiante) {
		this.apellido_estudiante = apellido_estudiante;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}
	
	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public void setDate(int dia, int mes, int year) {
		Calendar date = new GregorianCalendar(year,mes,dia);
		this.fecha_nacimiento = date;
		calcEdad(date);
	}
	public Estudiante(int id_estudiante, double prom) {
		super();
		this.id_estudiante = id_estudiante;
		this.promedio = prom;
	}
	public Estudiante(int id_estudiante, String nombre_estudiante, String apellido_estudiante, Calendar fecha_nacimiento, String curso) {
		super();
		this.id_estudiante = id_estudiante;
		this.nombre_estudiante = nombre_estudiante;
		this.apellido_estudiante = apellido_estudiante;
		this.fecha_nacimiento = fecha_nacimiento;
		this.curso = cursoInt(curso.trim());
		this.list_materias =new ListMaterias();
		this.list_materias.initMaterias();
		calcEdad(fecha_nacimiento);
	}

	public Estudiante(int id_estudiante, String nombre_estudiante, String apellido_estudiante, Calendar fecha_nacimiento, int curso) {
		super();
		this.id_estudiante = id_estudiante;
		this.nombre_estudiante = nombre_estudiante;
		this.apellido_estudiante = apellido_estudiante;
		this.fecha_nacimiento = fecha_nacimiento;
		this.curso = curso;
		this.list_materias =new ListMaterias();
		this.list_materias.initMaterias();
		calcEdad(fecha_nacimiento);
	}
	
	void calcEdad(Calendar fecha_nac) {
		Calendar today = Calendar.getInstance();
		int diffYear = today.get(Calendar.YEAR) - fecha_nac.get(Calendar.YEAR);
		int diffMonth = today.get(Calendar.MONTH) - fecha_nac.get(Calendar.MONTH);
		int diffDay = today.get(Calendar.DAY_OF_MONTH) - fecha_nac.get(Calendar.DAY_OF_MONTH);
		// Si est√° en ese a√±o pero todav√≠a no los ha cumplido
		if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
			diffYear = diffYear - 1;
		}
		this.edad = diffYear;

	}
	
	
	public void initMaterias() {
		String[] mat={"EspaÒol","Ingles","Matem·ticas","Biologia","Etica","Religion","Ed. Fisica","Filosofia","Artes","Informatica","Sociales"};

		for(int i=0;i<mat.length;i++) {
			list_materias.PushBack(new Materia(mat[i]));
		}		
	}
	
	void addNo() {
		//list_nota.PushBack(new Nota("1",1));
	}

	public void updatePromedio(String materia) {
		list_materias.getMateria(materia).updatePromedio();
		this.promedio=list_materias.promedioMaterias();
	}
	public int cursoInt(String curso) {
		int id=0;
		switch(curso) {
		case "Primero":
			id=1; 
			break;
		case "Segundo":
			id=2;
			break;
		case "Tercero":
			id=3;
			break;
		case "Cuarto":
			id=4;
			break;
		case "Quinto":
			id=5;
			break;
		case "Sexto":
			id=6;
			break;
		case "Septimo":
			id=7;
			break;
		case "Octavo":
			id=8;
			break;
		case "Noveno":
			id=9;
			break;
		case "Decimo":
			id=10;
			break;
		case "Once":
			id=11;
			break;
		default:
			id=0;
			break;
		}
		return id;
	}
	
	@Override
	public String toString() {
		return "id=" + id_estudiante + ", nombre=" + nombre_estudiante
				+ ", apellido=" + apellido_estudiante  + ", edad="
				+ edad +", curso="+curso+", promedio="+promedio;
	}
}
