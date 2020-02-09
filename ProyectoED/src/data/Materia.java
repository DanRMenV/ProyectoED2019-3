package data;

public class Materia {
	String nombre;
	double promedio;
	ListNotas list_nota;
	
	public Materia(String materia){
		this.nombre=materia;
		this.promedio=0.0;
		this.list_nota = new ListNotas();
		this.list_nota.initNotas();	
	}
	
	public void updatePromedio() {
		this.promedio= list_nota.promedio();
	}
	
	public double getPromedio() {
		return this.promedio;
	}

	public ListNotas getList() {
		return list_nota;
	}

	public void setList_nota(ListNotas list_nota) {
		this.list_nota = list_nota;
	}
	
	
	
	
}
