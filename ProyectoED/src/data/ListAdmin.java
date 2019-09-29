package data;



public class ListAdmin extends DoubleLinkedList<Admin> {
	
	public Admin FindByUsername(String username){
        DoubleNode<Admin> dn = null;
        DoubleNode<Admin> p = this.head;
        while(p != null){
            if(p.key.username.equals(username)){
                dn = p;
                break;
            }
            p = p.next;
        }
        return dn.key;
    }
	public Boolean ValidateUser(Admin a){
        DoubleNode<Admin> dn = null;
        DoubleNode<Admin> p = this.head;
        while(p != null){
            if(p.key.username.equals(a.username)&&p.key.password.equals(a.password)){
                dn = p;
                return true;
            }
            p = p.next;
        }
        return false;
    }
	public void DisList(){
        if(this.head == null){
            System.out.println("Lista vacia...");
        }
        DoubleNode <Admin> p = this.head;
        while(p !=  null){
            System.out.println(p.key.username.toString()+" | "+p.key.password.toString());
            p = p.next;
        }
    }
}
