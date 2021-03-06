package data;

public class ListMaterias extends DoubleLinkedList<Materia> {

	String[] mat={"Castellano","Ingles","Matematicas","Biologia","Etica","Religion","Ed.Fisica","Filosofia","Artes","Informatica","Sociales"};
	
	public void initMaterias() {
		for(int i=0;i<mat.length;i++) {
			PushBack(new Materia(mat[i]));
		}		
	}
	
	public Materia getMateria(String materia) {
		DoubleNode<Materia> temp = this.head;	
		for(int i=0; i<mat.length; i++){
			if(temp.key.nombre.equals(materia)) {
				break;
			}else {
				temp=temp.next;
			}
		}
		return temp.key;
	}
	
	public double promedioMaterias() {
		double suma=0.0;
		DoubleNode <Materia> p = this.head;
        while(p !=  null){
            if(p.key.getPromedio()>=1.0) {
        	suma+=p.key.getPromedio();
            }
            p = p.next;
        }
		return suma/mat.length;
		
	}
	
}
