package data;

import java.util.*;

public class Estudiante {
	int id_estudiante;
	String nombre_estudiante;
	String apellido_estudiante;
	Calendar fecha_nacimiento;
	Integer edad;
	DoubleLinkedList<Year> year_list;
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
				+ ", apellido_estudiante=" + apellido_estudiante + ", fecha_nacimiento=" + fecha_nacimiento.get(Calendar.DAY_OF_MONTH) + ", edad="
				+ edad + "]";
	}

	
	
	
}