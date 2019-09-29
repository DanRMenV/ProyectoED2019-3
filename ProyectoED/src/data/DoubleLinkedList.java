package data;

public class DoubleLinkedList <T>{
    DoubleNode<T> head = null;
    DoubleNode<T> tail = null;
    int c_elementos=0;
    //Método PushFront()
    public void PushFront(T key) {
        DoubleNode<T> node2 = new DoubleNode(key);
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
        c_elementos++;
    }
    //Método PushBack()
    public void PushBack(T key){
        DoubleNode<T> node2 = new DoubleNode(key);
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
        c_elementos++;
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
            c_elementos--;
        }
        else{
            this.tail = tail.prev;
            this.tail.next = null;
            c_elementos--;
        }
    }
    //Método FindByKey(Key)
    public DoubleNode FindByKey(T key){
        DoubleNode<T> dn = null;
        DoubleNode<T> p = this.head;
        while(p != null){
            if(p.key == key){
                dn = p;
                break;
            }
            p = p.next;
        }
        return dn;
    }
    //Método Pop(Key)
    public void Pop(T key){
        if(this.head == null)return;
        if(this.head == this.tail && this.head.key == key){
            this.head = this.tail =null;
            c_elementos--;
        }
        else if(head.key == key){
            head = head.next;
            c_elementos--;
        }
        else{
            DoubleNode<T> anterior = head;
            DoubleNode<T> p =head.next;

            while (p!=tail && p.key != key){
                anterior = anterior.next;
                p=p.next;
            }
            if(p != null){
                anterior.next = p.next;
                if(p == tail){
                    tail=anterior;
                }
                c_elementos--;
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
        DoubleNode <T> p = this.head;
        while(p !=  null){
            System.out.println(p.key.toString());
            p = p.next;
        }
    }
    //Método AddAfter(Node, key)
    public void AddAfter(DoubleNode node, int key){
        DoubleNode<T> node2 = new DoubleNode(key);
        node2.next = node.next;
        node.next = node2;
        node2.prev = node;
        if(node2.next != null){
            node2.next.prev=node2;
        }
        if(this.tail == node){
            this.tail = node2;
        }
        c_elementos++;
    }
    //Método AddBefore(Node, Key);
    public void AddBefore(DoubleNode node, int key){
        DoubleNode<T> node2 = new DoubleNode(key);
        node2.next=node;
        node2.prev=node.prev;
        node.prev=node2;
        if(node2.prev != null){
            node2.prev.next=node2;
        }
        if(this.head == node){
            this.head=node2;
        }
        c_elementos++;
    }
    public int NumeroElementos() {
    	return c_elementos;
    }
    
    

}