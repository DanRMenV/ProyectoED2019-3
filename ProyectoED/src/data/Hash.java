package data;

public class Hash {
	long n = 0; //Number of elements
	long m = 0; //Cardinality of the function
	double Lf = 0; //Load factor defined as n/m
	//Important values for calculate de Hfunction
	long p = 1000000007;//long prime, this number can be higher or lower
	long a = (long)(Math.random() * (((p-1) - 1) + 1)) + 1;
	long b = (long)(Math.random() * (((p-1) - 1)));
	Admin[] table;
	
	public Hash(int m) {
		table = new Admin[m];
		this.m = m;
		a = 34;
		b = 2;
		/* In the initial case the cardinality 
		of the function will be defined by the user,
		if n is equal to m, m will grown by
	    a multiply factor*/
	}
	//Function that return the value of the hash function
	public int HFunction(long key) {
		//System.out.println((a*(key) + b));
		int result = (int)(((a*(key) + b) % p) % m);
		return result;
	}
	//Function that insert a new node
	public void Add(Admin O) {
		if(Lf >= 1.0) {
			Admin[] tableNew = new Admin[2*(int)m];
			//this.a = (long)(Math.random() * (((p-1) - 1) + 1)) + 1;
			//this.b = (long)(Math.random() * (((p-1) - 1)));
			int mr = (int) m;
			for(int x = 0 ; x < mr ; x++) {
				while(table[x] != null) {
					Admin Current = table[x];
					table[x] = table[x].next;
					Current.next = null;
					//In this part is extracted the first element of the hash table and added again in the new table
					//Insertion part for the first element of the hash table
					int pos2 = HFunction(Current.id);
					// Is the same logic that in a normal add
					if(tableNew[pos2] == null) {
						tableNew[pos2] = Current;
					}else {
						Admin iter = tableNew[pos2];
						while(iter.next != null) {
							if(iter.id == Current.id) {
								System.out.println("Usuario administrativo repetido");
								return;
							}
							iter = iter.next;
						}
						iter.next = Current;
					}
				}
			}
			table = tableNew;
			m *= 2;
			Lf = n/m;
			Add(O);
		}else {
			int position = HFunction(O.id);
			if(table[position] == null) {
				table[position] = O;
				n++;
			}else {
				//This part is similar to the implementation of a linkedList
				Admin iter = table[position];
				if(iter.id == O.id) {
					System.out.println("Dato repetido");
					return;
				}
				while(iter.next != null) {
					if(iter.id == O.id) {
						System.out.println("Dato repetido");
						return;
					}
					iter = iter.next;
				}
				iter.next = O;
				n++;
			}
		}
		Lf = (float)(n)/m;
	}
	//Function that returns the Node if is search by an id
	public Admin Find(long data) {
		int position = HFunction(data);
		if(table[position] == null) {
			return new Admin(-1,"UserNull","UserNull");
		}else {
			Admin iter = table[position];
			while(iter.id != data && iter.next != null) {
				iter = iter.next;
			}
			if(iter.id == data)return iter;
			return new Admin(-1,"UserNull","UserNull");
		}
	}
	//Graphic view of the structure of the Hash Table
	public void PrintHash() {
		for(int a=0; a<m; a++) {
			System.out.print(a+":  ");
			if(table[a] != null) {
				Admin iter = table[a];
				System.out.print(iter.id+"  -  ");
				while(iter.next != null) {
					iter = iter.next;
					System.out.print(iter.id+"  -  ");
				}
			}
			System.out.println();
		}
	}
	//Metodo que valida el usuario ...
	public boolean ValidateUser(Admin O) {
		int position = HFunction(O.id);
		System.out.println("Position: "+position);
		if(table[position] != null) {
			Admin iter = table[position];
			while(iter != null) {
				if(iter.id == O.id && iter.password.equals(O.password)) {
					return true;
				}
				iter = iter.next;
			}
		}
		return false;
	} 
}