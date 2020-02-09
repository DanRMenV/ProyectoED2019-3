package data;

public class ListNotas extends DoubleLinkedList<Nota>{
	
	public double sumaNota() {
		double suma=0.0;
		DoubleNode <Nota> p = this.head;
        while(p !=  null){ 
        double temp=p.key.getCalificacion();      
            if(temp>=0.0) {         	
        	suma+=temp;
           }  
            p = p.next;
        }
		return suma;
	}
	
	public double promedio() {
		double suma=0.0;
		int notas=0;
		DoubleNode <Nota> p = this.head;
        while(p !=  null){
            if(p.key.getCalificacion()>=1.0) {
        	suma+=p.key.getCalificacion();
        	notas++;
            }
            p = p.next;
        }
		return suma/notas;
		
	}
	
	public void initNotas() {
		for(int i=0;i<10;i++) {
			PushBack(new Nota(Integer.toString(i)));
		}		
	}

	public double GetNota(int NumNota){
		DoubleNode<Nota> temp = this.head;
		for(int i=0; i<NumNota; i++){
			temp = temp.next;
		}
		return temp.getKey().getCalificacion();
	}

	public void SetNota(int NumNota, double cal){
		DoubleNode<Nota> temp = this.head;
		for(int i=0; i<NumNota; i++){
			temp = temp.next;
		}
		temp.getKey().setCalificacion(cal);
		
	}


}