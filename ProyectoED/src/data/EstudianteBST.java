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

    //Es lo mismo que ya estaba en Estudiante de lista
    /*int id_estudiante;
    String nombre_estudiante;
    String apellido_estudiante;
    Calendar fecha_nacimiento;
    Integer edad;
    public ListNotas list_nota;
    int curso;
    double promedio=0;
    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    public String getApellido_estudiante() {
        return apellido_estudiante;
    }

    public void setApellido_estudiante(String apellido_estudiante) {
        this.apellido_estudiante = apellido_estudiante;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    public void setDate(int dia, int mes, int year) {
        Calendar date = new GregorianCalendar(year,mes,dia);
        this.fecha_nacimiento = date;
        calcEdad(date);
    }
    public EstudianteBST(int id_estudiante, String nombre_estudiante, String apellido_estudiante,int dia, int mes, int year, String curso) {
        super();
        this.id_estudiante = id_estudiante;
        this.nombre_estudiante = nombre_estudiante;
        this.apellido_estudiante = apellido_estudiante;
        this.fecha_nacimiento = new GregorianCalendar(year,mes, dia);
        this.curso = cursoInt(curso.trim());
        this.list_nota = new ListNotas();
        calcEdad(fecha_nacimiento);
    }

    public EstudianteBST(int id_estudiante, String nombre_estudiante, String apellido_estudiante, int dia, int mes, int year, int curso) {
        super();
        this.id_estudiante = id_estudiante;
        this.nombre_estudiante = nombre_estudiante;
        this.apellido_estudiante = apellido_estudiante;
        this.fecha_nacimiento = new GregorianCalendar(year,mes, dia);
        this.curso = curso;
        this.list_nota = new ListNotas();
        calcEdad(fecha_nacimiento);
    }

    void calcEdad(Calendar fecha_nac) {
        Calendar today = Calendar.getInstance();
        int diffYear = today.get(Calendar.YEAR) - fecha_nac.get(Calendar.YEAR);
        int diffMonth = today.get(Calendar.MONTH) - fecha_nac.get(Calendar.MONTH);
        int diffDay = today.get(Calendar.DAY_OF_MONTH) - fecha_nac.get(Calendar.DAY_OF_MONTH);
        // Si está en ese año pero todavía no los ha cumplido
        if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
            diffYear = diffYear - 1;
        }
        this.edad = diffYear;

    }
    void addNo() {
        list_nota.PushBack(new Nota("1",1));
    }

    public int cursoInt(String curso) {
        int id=0;
        switch(curso) {
            case "Primero":
                id=1;
                break;
            case "Segundo":
                id=2;
                break;
            case "Tercero":
                id=3;
                break;
            case "Cuarto":
                id=4;
                break;
            case "Quinto":
                id=5;
                break;
            case "Sexto":
                id=6;
                break;
            case "Septimo":
                id=7;
                break;
            case "Octavo":
                id=8;
                break;
            case "Noveno":
                id=9;
                break;
            case "Decimo":
                id=10;
                break;
            case "Once":
                id=11;
                break;
            default:
                id=0;
                break;
        }
        return id;
    }
    @Override
    public String toString() {
        return "id=" + id_estudiante + ", nombre=" + nombre_estudiante
                + ", apellido=" + apellido_estudiante  + ", edad="
                + edad +", curso="+curso+", promedio="+promedio;
    }*/

}
