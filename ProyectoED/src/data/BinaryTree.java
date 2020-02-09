package data;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class BinaryTree {
	protected EstudianteBST root;
	private int numEst=0;
	//Constructor que inicualiza la raiz en null
	public BinaryTree() {
		this.root = null;
	}

	public int getNumEst() {
		return numEst;
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
		/*GregorianCalendar date = new GregorianCalendar(dia,mes,year);
		Estudiante est=new Estudiante(id,name,surname,date,curso);*/
		EstudianteBST estud=new EstudianteBST(est);

		//EstudianteBST nuevo = new EstudianteBST(data,name,surname,dia,mes,year,curso);

		EstudianteBST root = Find (this.root,est.id_estudiante);
		if(this.root == null) {
			this.root = estud;
			return;
		}
		estud.parent = root;
		if(estud.data.id_estudiante > root.data.id_estudiante) {
			root.right = estud;
			return;
		}
		root.left = estud;
		numEst++;
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
		//Arreglar el leftascendant o algo as� :)
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
	/*public void addNotaCurso(EstudianteBST root, String desc) {
		EstudianteBST raiz = root;
		if(raiz == null)return ;
		if(raiz.left != null) {
			addNotaCurso(raiz.left,desc);
		}
		Estudiante temp=raiz.data;
		System.out.println("Documento de identidad: "+temp.getId_estudiante()+" Nombre: "+temp.getNombre_estudiante()+" "+temp.getApellido_estudiante()+" Edad: "+temp.getEdad()+" Promedio: "+temp.getPromedio()+" Curso: "+temp.getCurso());
		temp.list_nota.PushBack(new Nota(desc,scan.nextDouble()));
		calcProme(raiz);
		temp.list_nota.DisplayList();
		if(raiz.right != null) {
			addNotaCurso(raiz.right,desc);
		}
	}*/
	
	/*public double calcProme(EstudianteBST est) {
		est.data.setPromedio(est.data.list_materias.promedioMateria());
		return est.data.list_materias.promedioMateria();
	}*/
	
		
}
