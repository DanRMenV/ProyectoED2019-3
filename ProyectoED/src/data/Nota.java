package data;

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
		this.calificacion = -1;
	}
	
	
	public double getCalificacion() {
		return calificacion;
	}

	@Override
	public String toString() {
		return descripcion + ": " + calificacion;
	}
	
}
