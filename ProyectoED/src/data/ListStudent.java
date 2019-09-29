package data;

public class ListStudent extends DoubleLinkedList<Estudiante>{
		
	
	public Estudiante FindStudent(int id){
        DoubleNode<Estudiante> dn = null;
        DoubleNode<Estudiante> p = this.head;
        while(p != null){
            if(p.key.id_estudiante == id){
                dn = p;
                break;
            }
            p = p.next;
        }
        return dn.key;
    }
	
	public boolean ExistStudent(int id){
        DoubleNode<Estudiante> dn = null;
        DoubleNode<Estudiante> p = this.head;
        while(p != null){
            if(p.key.id_estudiante == id){
                dn = p;
                return true;
            }
            p = p.next;
        }
        return false;
    }

	
}
