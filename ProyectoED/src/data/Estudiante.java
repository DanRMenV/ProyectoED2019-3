package data;
import business.*;
import java.util.*;

public class Estudiante {
	int id_estudiante;
	String nombre_estudiante;
	String apellido_estudiante;
	Calendar fecha_nacimiento;
	Integer edad;
	public DoubleLinkedList <Nota> list_nota;
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

	public Estudiante(int id_estudiante, String nombre_estudiante, String apellido_estudiante, Calendar fecha_nacimiento, int curso) {
		super();
		this.id_estudiante = id_estudiante;
		this.nombre_estudiante = nombre_estudiante;
		this.apellido_estudiante = apellido_estudiante;
		this.fecha_nacimiento = fecha_nacimiento;
		this.curso = curso;
		this.list_nota = new DoubleLinkedList<Nota>();
		calcEdad(fecha_nacimiento);
	}

	void calcEdad(Calendar fecha_nac) {
		Calendar now= Calendar.getInstance();
		int aAct=now.get(Calendar.YEAR);
		int aNac=fecha_nac.get(Calendar.YEAR);
		this.edad= aAct-aNac;	
	}
	void addNo() {
		list_nota.PushBack(new Nota("1",1));
	}
	@Override
	public String toString() {
		return "id=" + id_estudiante + ", nombre=" + nombre_estudiante
				+ ", apellido=" + apellido_estudiante  + ", edad="
				+ edad +", curso="+curso;
	}

}
