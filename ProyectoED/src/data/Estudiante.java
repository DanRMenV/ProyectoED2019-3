package data;

import java.util.*;

public class Estudiante {
	int id_estudiante;
	String nombre_estudiante;
	String apellido_estudiante;
	Calendar fecha_nacimiento;
	Integer edad;
	DoubleLinkedList<Year> year_list;
	
	
	
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

	public Calendar getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Calendar fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Estudiante(int id_estudiante, String nombre_estudiante, String apellido_estudiante, Calendar fecha_nacimiento) {
		super();
		this.id_estudiante = id_estudiante;
		this.nombre_estudiante = nombre_estudiante;
		this.apellido_estudiante = apellido_estudiante;
		this.fecha_nacimiento = fecha_nacimiento;
		calcEdad(fecha_nacimiento);
	}

	void calcEdad(Calendar fecha_nac) {
		Calendar now= Calendar.getInstance();
		int aAct=now.get(Calendar.YEAR);
		int aNac=fecha_nac.get(Calendar.YEAR);
		this.edad= aAct-aNac;	
	}
	
	@Override
	public String toString() {
		return "Estudiante [id_estudiante=" + id_estudiante + ", nombre_estudiante=" + nombre_estudiante
				+ ", apellido_estudiante=" + apellido_estudiante + ", fecha_nacimiento=" + fecha_nacimiento.toString() + ", edad="
				+ edad + "]";
	}

	
	
	
}