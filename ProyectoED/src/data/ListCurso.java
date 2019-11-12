package data;

public class ListCurso extends DoubleLinkedList<Curso>{


    public Curso FindCurso(int id){
        DoubleNode<Curso> dn = null;
        DoubleNode<Curso> p = this.head;
        while(p != null){
            if(p.key.id_curso == id){
                dn = p;
                break;
            }
            p = p.next;
        }
        return dn.key;
    }

    public boolean ExistCurso(int id){
        DoubleNode<Curso> dn = null;
        DoubleNode<Curso> p = this.head;
        while(p != null){
            if(p.key.id_curso == id){
                dn = p;
                return true;
            }
            p = p.next;
        }
        return false;
    }

}