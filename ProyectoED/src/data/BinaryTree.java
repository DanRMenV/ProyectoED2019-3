package data;

//import java.util.GregorianCalendar;
import java.util.Scanner;

//Muchos metodos del arbol fueron modificados para garantizar que funcionara como un AVL


public class BinaryTree {
	protected EstudianteBST root;
	int numEst=0;
	//Constructor que inicualiza la raiz en null
	public BinaryTree() {
		this.root = null;
	}

	public int getNumEst() {
		return numEst;
	}
	public EstudianteBST Find(int data) {
		return Find(this.root, data);
	}
	public EstudianteBST Find(EstudianteBST root, int data) {
		if (root == null || root.data.id_estudiante == data) {
			return root;	
		}else if(root.data.id_estudiante > data) {
			if(root.left != null) {
				return Find(root.left, data);	
			}
			return root;
			
		}else {
			if(root.right != null) {
				return Find(root.right, data);
			}
			return root;
		}
	}
	public void insert(Estudiante est) {
		EstudianteBST Nuevo=new EstudianteBST(est); //estud
		EstudianteBST N = Find (this.root,est.id_estudiante);//root
		if(N == null) {
			this.root = Nuevo;
			numEst++;
			return;
		}else if(Nuevo.data.id_estudiante > N.data.id_estudiante) {
			N.right = Nuevo;
			Nuevo.parent = N;
			numEst++;
		}else if(Nuevo.data.id_estudiante < N.data.id_estudiante) {
			N.left = Nuevo;
			Nuevo.parent = N;
			numEst++;
		}else {
			return;
		}
	}
	
	public void inOrder() {
		EstudianteBST raiz = root;
		if(raiz == null)return ;
		if(raiz.left != null) {
			inOrder(raiz.left);
		}
		System.out.println(" "+raiz.data.id_estudiante+" ");
		if(raiz.right != null) {
			inOrder(raiz.right);
		}
	}

	public void inOrder(EstudianteBST root) {
		EstudianteBST raiz = root;
		if(raiz == null)return ;
		if(raiz.left != null) {
			inOrder(raiz.left);
		}
		System.out.println(" "+raiz.data.id_estudiante+" ");
		if(raiz.right != null) {
			inOrder(raiz.right);
		}
	}
	public EstudianteBST getRoot() {
		return root;
	}
	public EstudianteBST Next(EstudianteBST N) {
		if(N.right != null)return LeftDescendant(N.right);
		return RightAncestor(N);
	}
	public EstudianteBST LeftDescendant (EstudianteBST N) {
		if(N.left == null)return N;
		return LeftDescendant(N.left);
	}
	public EstudianteBST RightAncestor(EstudianteBST N) {
		if(N.data.id_estudiante < N.parent.data.id_estudiante)return N.parent;
		return RightAncestor(N.parent);
	}
	public void printNext (EstudianteBST N) {
		if(Next(N) != null) {
			System.out.println(Next(N).data.id_estudiante);
			return;
		}
		System.out.println("No hay siguiente");
	}
	public void RangeSearch(int x, int y, EstudianteBST R) {
		int men, may;
		if(x > y) {
			men = y;
			may = x;
		}else {
			men = x;
			may = y;
		}
		EstudianteBST iterator = Find(R,men);
		while (iterator.data.id_estudiante <= may) {
			if(iterator.data.id_estudiante >= men)System.out.println(iterator.data.id_estudiante);
			iterator = Next(iterator);
		}
	}
	public void printStudentCurso() {
		printStudentCurso(this.root);
	}
	public void printStudentCurso (EstudianteBST root) {
		EstudianteBST raiz = root;
		if(raiz == null)return ;
		if(raiz.left != null) {
			printStudentCurso(raiz.left);
		}
		Estudiante temp=raiz.data;
		System.out.println("Documento de identidad: "+temp.getId_estudiante()+" Nombre: "+temp.getNombre_estudiante()+" "+temp.getApellido_estudiante()+" Edad: "+temp.getEdad()+" Promedio: "+temp.getPromedio()+" Curso: "+temp.getCurso());
		if(raiz.right != null) {
			printStudentCurso(raiz.right);
		}
	}

	Scanner scan = new Scanner(System.in);

	//Metodos AVL----
	public void inOrderHeight() {
		EstudianteBST raiz = this.root;
		if(raiz == null)return ;
		if(raiz.left != null) {
			inOrderHeight(raiz.left);
		}
		System.out.println("Nodo: "+raiz.data+" Height: "+raiz.height);
		if(raiz.right != null) {
			inOrderHeight(raiz.right);
		}
	}
	public void inOrderHeight(EstudianteBST root) {
		EstudianteBST raiz = root;
		if(raiz == null)return ;
		if(raiz.left != null) {
			inOrderHeight(raiz.left);
		}
		System.out.println("Nodo: "+raiz.data+" Height: "+raiz.height);
		if(raiz.right != null) {
			inOrderHeight(raiz.right);
		}
	}
	public void AVLinsert(Estudiante data) {
		insert(data);
		EstudianteBST N = Find(root,data.id_estudiante);
		Rebalance(N);
	}
	
	public void Rebalance (EstudianteBST N) {
		EstudianteBST P = N.parent;
		int left_height = 0, right_height = 0, temp_bal=0;
		if(N.right != null) right_height = N.right.height;
		if(N.left != null) left_height = N.left.height;
		temp_bal = Math.abs(left_height - right_height);
		//Se garantiza que la altura sea 0 en caso de no existir nodo izquierdo o derecho
		
		
		if(temp_bal >1) {
			if(left_height > right_height) {
				EstudianteBST X = N.left;
				if(X.left == null) {
					//System.out.println("LeftRight");
					LeftRight(N);
				}else if(X.right == null) {
					//System.out.println("LeftLeft");
					LeftLeft(N);
				}else if(X.left.height > X.right.height) {
					//System.out.println("LeftLeft");
					LeftLeft(N);
				}else {
					//System.out.println("LeftRight");
					LeftRight(N);
				}
			}else {
				EstudianteBST X = N.right;
				if(X.right == null) {
					//System.out.println("RightLeft");
					RightLeft(N);
				}else if(X.left == null) {
					//System.out.println("RightRight");
					RightRight(N);
				}else if(X.right.height > X.left.height) {
					//System.out.println("RightRight");
					RightRight(N);
				}else {
					//System.out.println("RightLeft");
					RightLeft(N);
				}
			}
		}
		adjustHeight(N);
		if(P != null)Rebalance(P);
		
	}
	
	public void adjustHeight(EstudianteBST N) {
		int left_height = 0, right_height = 0;
		if(N.right != null) right_height = N.right.height;
		if(N.left != null) left_height = N.left.height;
		N.height = 1 + Math.max(right_height,left_height);
	}
	
	public void RightRight(EstudianteBST N) {
		EstudianteBST X = N.right;
		if(N.parent == null) {
			X.parent = null;
			root = X;
		}else {
			X.parent = N.parent;
			if(N.parent.right == N) {
				N.parent.right = X;
			}else {
				N.parent.left = X;
			}
			
		}
		if(X.left != null) {
			X.left.parent = N;
			N.right = X.left;
		}else {
			N.right = null;
		}
		X.left = N;
		N.parent = X;
		adjustHeight(N);
		//adjustHeight(X);
	}
	
	public void LeftLeft(EstudianteBST N) {
		EstudianteBST X = N.left;
		if(N.parent == null) {
			X.parent = null;
			root = X;
		}else {
			X.parent = N.parent;
			if(N.parent.left == N) {
				N.parent.left = X;
			}else {
				N.parent.right = X;
			}
		}
		if(X.right != null) {
			X.right.parent = N;
			N.left = X.right;
		}else {
			N.left = null;
		}
		X.right = N;
		N.parent = X;
		adjustHeight(N);
		//adjustHeight(X);
	}
	public void LeftRight(EstudianteBST N) {
		//Convertirlo a LeftLeft
		EstudianteBST X = N.left;
		N.left = X.right;
		X.right.parent = N;
		
		if(X.right.left != null) {
			X.right.left.parent = X;
			X.right = X.right.left;
		}else {
			X.right = null;
		}
		N.left.left = X;
		X.parent = N.left;
		adjustHeight(N);
		adjustHeight(X);
	}
	public void RightLeft(EstudianteBST N) {
		//Convertirlo a RightRight
		EstudianteBST X = N.right;
		N.right = X.left;
		X.left.parent = N;
		
		if(X.left.right != null) {
			X.left.right.parent = X;
			X.left = X.left.right;
		}else {
			X.left = null;
		}
		N.right.right = X;
		X.parent = N.right;
		adjustHeight(N);
		adjustHeight(X);
	}
		
		
}
