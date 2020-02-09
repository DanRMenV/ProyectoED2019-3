package data;

import java.util.concurrent.ThreadLocalRandom;

public class Nota {
	String descripcion;
	double calificacion;
	
	public Nota(String descripcion, double calificacion) {
		super();
		this.descripcion = descripcion;
		this.calificacion = calificacion;
	}
	
	
	public Nota(String descripcion) {
		super();
		this.descripcion = descripcion;
		this.calificacion = 0.0;
	}
	
	
	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return descripcion + ": " + calificacion;
	}
	
}
