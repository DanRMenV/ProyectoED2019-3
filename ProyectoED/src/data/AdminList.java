package data;

public class AdminList {
	Admin head = null;
    Admin tail = null;
    //Método PushFront()
    public void PushFront(String username,String password) {
        Admin node2 = new Admin(username,password);
        if (this.head == null) {
            this.tail = node2;
            this.head = tail;
        } else {
            node2.next = head;
            node2.prev = null;
            this.head = node2;
            this.head.next.prev = head;
        }
        if (this.tail == null) {
            this.tail = this.head;
        }
    }
    //Método PushBack()
    public void PushBack(String username,String password){
        Admin node2 = new Admin(username, password);
        node2.next = null;
        node2.prev = tail;
        if(this.head == null){
            this.tail = node2;
            this.head = tail;
        }
        else{
            this.tail.next = node2;
            node2.prev = this.tail;
            this.tail = node2;
        }
    }
    //Método Popback()
    public void PopBack(){
        if(this.head == null){
            System.out.println("Error!!!. Empty List");
            return;
        }
        if(this.head == this.tail){
            this.tail = null;
            this.head = tail;
        }
        else{
            this.tail = tail.prev;
            this.tail.next = null;
        }
    }
    //Método FindByKey(Key)
    public Admin FindByKey(String username,String password){
        Admin dn = null;
        Admin p = this.head;
        while(p != null){
            if(p.username.equals(username) && p.password.equals(password)){
                dn = p;
                break;
            }
            p = p.next;
        }
        return dn;
    }
    //Método Pop(Key)
    public void Pop(String username){
        if(this.head == null)return;
        if(this.head == this.tail && this.head.username == username ){
            this.head = this.tail =null;
        }
        else if(head.username == username){
            head = head.next;
        }
        else{
            Admin anterior = head;
            Admin p =head.next;

            while (p!=tail && p.username != username){
                anterior = anterior.next;
                p=p.next;
            }
            if(p != null){
                anterior.next = p.next;
                if(p == tail){
                    tail=anterior;
                }
            }
        }
    }
    //Método isEmpty()
    public boolean isEmpty(){
        return head ==null;
    }
    //Método DisplayList()
    public void DisplayList(){
        if(this.head == null){
            System.out.println("Lista vacia...");
        }
        Admin p = this.head;
        System.out.println("Usernames");
        while(p !=  null){
            System.out.println(p.username.toString()+": "+p.password.toString());
            p = p.next;
        }
    }
}
