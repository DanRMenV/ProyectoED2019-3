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
		double random = ThreadLocalRandom.current().nextDouble(1.0, 5.0);
		String te = String.valueOf(random).substring(0, 3);
		double r = Double.parseDouble(te);
		this.calificacion = r;
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
