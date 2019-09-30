package data;

public class ListNotas extends DoubleLinkedList<Nota>{
	public double sumaNota() {
		double suma=0.0;
		DoubleNode <Nota> p = this.head;
        while(p !=  null){
            suma+=p.key.getCalificacion();
            p = p.next;
        }
		return suma;
	}

}
