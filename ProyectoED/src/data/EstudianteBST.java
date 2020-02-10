package data;

public class EstudianteBST {
    public EstudianteBST left;
    public EstudianteBST right;
    public EstudianteBST parent;
    public Estudiante data;
    int height;
    public EstudianteBST(Estudiante data) {
        this.left=null;
        this.right=null;
        this.parent=null;
        this.data = data;
    }

}
