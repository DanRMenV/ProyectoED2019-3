package data;

import java.util.GregorianCalendar;

public class BinaryTree {
	protected EstudianteBST root;
	//Constructor que inicualiza la raiz en null
	public BinaryTree() {
		this.root = null;
	}

	public EstudianteBST Find(EstudianteBST root, int data) {
		if (root == null || root.id_estudiante == data) {
			return root;	
		}else if(root.id_estudiante > data) {
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
	public void insert(int data, String name, String surname, int dia, int mes, int year, int curso) {
		GregorianCalendar date = new GregorianCalendar(dia,mes,year);
		EstudianteBST nuevo = new EstudianteBST(data,name,surname,dia,mes,year,curso);
		EstudianteBST root = Find (this.root, data);
		if(this.root == null) {
			this.root = nuevo;
			return;
		}
		nuevo.parent = root;
		if(nuevo.id_estudiante > root.id_estudiante) {
			root.right = nuevo;
			return;
		}
		root.left = nuevo;
	}
	public void inOrder() {
		EstudianteBST raiz = root;
		if(raiz == null)return ;
		if(raiz.left != null) {
			inOrder(raiz.left);
		}
		System.out.println(" "+raiz.id_estudiante+" ");
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
		System.out.println(" "+raiz.id_estudiante+" ");
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
		//Arreglar el leftascendant o algo as� :)
		if(N.id_estudiante < N.parent.id_estudiante)return N.parent;
		return RightAncestor(N.parent);
	}
	public void printNext (EstudianteBST N) {
		if(Next(N) != null) {
			System.out.println(Next(N).id_estudiante);
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
		while (iterator.id_estudiante <= may) {
			if(iterator.id_estudiante >= men)System.out.println(iterator.id_estudiante);
			iterator = Next(iterator);
		}
	}
	//Metodo incompleto ....
	
	 /*	public void DeleteByData(int data) {
		BinaryNode 	N = Find(root,data);
		if(N.data != data)return;
		if(N.data > root.data) {
			if(N.right == null && N.left == null) {
				N.parent.right = null;
				N.parent = null;
			}
			else if(N.right == null) {
				N.parent.right = N.left;
				N.left.parent = N.parent;
				N.parent = null;
				N.left = null;
				N = null;
			}else {
				BinaryNode X = Next(N);
				BinaryNode father = N.parent;
				father.right = X;
				X.parent = father;
				X.left = N.left;
				N.left = null;
				X.right = N.right.right;
			}
		}else {
			if(N.right == null && N.left == null) {
				N.parent.left = null;
				N.parent = null;
			}
			else if(N.right == null) {
				if(N.parent != null) {
					N.parent.right = N.left;
					N.left.parent = N.parent;
					N.parent = null;
					N.left = null;
					N = null;
				}else {
					System.out.println(N.data);
					root = N.left;
					N.left.parent = root;
					root.parent = null;
				}
			}else {
				if(N.parent != null) {
					BinaryNode X = Next(N);
					BinaryNode father = N.parent;
					father.left = X;
					X.parent = father;
					N.right.left = N.right.left.right;
					N.right.left.parent = N.right;
					X.right = N.right;
					X.left = N.left;
					X.left.parent = X;
				}else {
					BinaryNode X = Next(N);
					X.right = N.right;
					X.left = N.left;
					X.left.parent = X;
					root = X;
					if(Next(N).right != null) {
						X.right.left = Next(N).right;
						X.right.left.parent = X.right;
					}
				}
			}
		}
		
		/*if(delete.right == null) {
			if(delete.left != null) {
				delete.parent.right = delete.left;
				delete.left.parent = delete.parent;
			}else {
				delete.parent.right = null;
			}
			delete.parent = null;
		}else {
			BinaryNode X = Next(delete);
			if(delete.parent != null) {
				delete.parent.right = X;
				X.parent = delete.parent;
			}
			if(X.right != null) {
				delete.right.left = X.right;
				X.right = delete.right;
			}
			delete = null;
		}
		
	}*/
		
}
