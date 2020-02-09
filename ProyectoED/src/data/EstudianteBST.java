package data;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EstudianteBST {
    public EstudianteBST left;
    public EstudianteBST right;
    public EstudianteBST parent;
    public Estudiante data;

    public EstudianteBST(Estudiante data) {
        this.left=null;
        this.right=null;
        this.parent=null;
        this.data = data;
    }

}
