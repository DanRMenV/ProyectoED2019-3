package data;

public class HeapNota {
	int size = 0;
	int maxSize = 0;
	public Estudiante[] Heap;
	
	public HeapNota(int maxSize) {
		Heap = new Estudiante[maxSize+1];
		this.maxSize = maxSize;
		Estudiante nuevo = new Estudiante(-1, Double.MAX_VALUE);
		Heap[0] = nuevo; //Max value posible
	}
	//Funciones de posicion para el arreglo
	private int Parent(int position) {
		return position/2;
	}
	private int LeftChild(int position) {
		return 2*position;
	}
	private int RightChild(int position) {
		return 2*position+1;
	}
	//Funciones importantes ^v^
	public void SiftUp(int position) {
		while ( position > 1 && Heap[Parent(position)].promedio < Heap[position].promedio) {
			//System.out.println("Parent: "+Heap[Parent(position)]+" Current: "+Heap[position]);
			//Swap H[Parent(i)] and H[i]
			Estudiante temp = Heap[Parent(position)];
			Heap[Parent(position)] = Heap[position];
			Heap[position] = temp;
			position = Parent(position);
		}
	}
	public void SiftDown(int position) {
		int maxIndex = position;
		int l = LeftChild(position);
		if( l <= size && Heap[l].promedio > Heap[maxIndex].promedio) {
			maxIndex = l;
		}
		int r = RightChild(position);
		if( r <= size && Heap[r].promedio > Heap[maxIndex].promedio) {
			maxIndex = r;
		}
		if( position != maxIndex) {
			//Swap H[maxIndex] and H[i]
			Estudiante temp = Heap[maxIndex];
			Heap[maxIndex] = Heap[position];
			Heap[position] = temp;
			SiftDown(maxIndex);
		}
	}
	public void Insert(Estudiante p) {
		if(size == maxSize) {
			//Crecer el arreglo
			Estudiante temp[] = new Estudiante[2 * maxSize + 1];
			for(int a=0; a < maxSize; a++) {
				temp[a] = Heap[a];
			}
			Heap = temp;
			maxSize = 2 * maxSize;
			//System.out.println("Capacidad alcanzada");
		}
		size++;
		Heap[size] = p;
		SiftUp(size);
	}
	public Estudiante ExtractMax() {
		Estudiante result = Heap[1];
		if(size == 0) {
			
		}else if(size == 1) {
			Heap[1] = null;
			size = 0;
		}else {
			Heap[1] = Heap[size];
			Heap[size] = null;
			size--;
			SiftDown(1);
		}
		return result;
	}
	public Estudiante GetMax() {
		return Heap[1];
	}
	public void Remove(int position) {
		Estudiante nuevo = new Estudiante(-1, Double.MAX_VALUE);
		Heap[position] = nuevo;
		SiftUp(position);
		ExtractMax();
	}
	
	public void ChangePriority(int position) {	
		double value = Heap[position].getPromedio();
		double parent= Heap[Parent(position)].getPromedio();
		
		if(value > parent) SiftUp(position);
		else SiftDown(position);
	}
	
	
	//Metodo extra para el funcionamiento del programa
	public void printEst() {
		for(int a=1; a<maxSize; a++) {
			if(Heap[a] == null)return;
			System.out.println("Id: "+Heap[a].id_estudiante+"    Prom: "+Heap[a].promedio+"   Pos: "+a);
		}
	}
	public int posFind(int id_estudiante) {
		for(int a=1; a<maxSize; a++) {
			if(Heap[a] != null) {
				if(Heap[a].id_estudiante == id_estudiante)return a;
			}
		}
		return 0;
	}
	
	public Estudiante getEstudiante(int id) {
		int position = posFind(id);
		return Heap[position];		
	}
	
	public void mejProm() {
		Estudiante m1 = ExtractMax();
		Estudiante m2 = ExtractMax();
		Estudiante m3 = ExtractMax();
		Estudiante m4 = ExtractMax();
		Estudiante m5 = ExtractMax();
		if(m1 != null) System.out.println("1: Id: "+m1.id_estudiante+" Promedio: "+m1.promedio);
		if(m2 != null) System.out.println("2: Id: "+m2.id_estudiante+" Promedio: "+m2.promedio);
		if(m3 != null) System.out.println("3: Id: "+m3.id_estudiante+" Promedio: "+m3.promedio);
		if(m4 != null) System.out.println("4: Id: "+m4.id_estudiante+" Promedio: "+m4.promedio);
		if(m5 != null) System.out.println("5: Id: "+m5.id_estudiante+" Promedio: "+m5.promedio);
		if(m1 != null)Insert(m1);	
		if(m2 != null)Insert(m2);
		if(m3 != null)Insert(m3);
		if(m4 != null)Insert(m4);
		if(m5 != null)Insert(m5);
	}
	public void modProm(int id_estudiante) {
		int position = posFind(id_estudiante);
		//double prom= Heap[position].getPromedio();	
		if(position == 0) {
			System.out.println("Estudiante no encontrado");
		}else {
			ChangePriority(position);
		}
	}
}
