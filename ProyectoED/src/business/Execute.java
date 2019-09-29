package business;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;

import data.*;

public class Execute {

	public static void main(String[] args) {
		EstudiantesManager em=new EstudiantesManager();
		Scanner sc=new Scanner(System.in);
		System.out.println("Ingrese id");
		String id=sc.nextLine();
		int numId=Integer.parseInt(id);
		System.out.println("Ingrese nombre");
		String name=sc.nextLine();
		System.out.println("Ingrese Apellido");
		String last=sc.nextLine();
		System.out.println("Ingrese dia de nacimiento");
		String dia=sc.nextLine();
		int numDia=Integer.parseInt(dia);
		System.out.println("Ingrese mes de nacimiento");
		String mes=sc.nextLine();
		int numMes=Integer.parseInt(mes);
		System.out.println("Ingrese a�o de nacimiento");
		String a�o=sc.nextLine();
		int numA�o=Integer.parseInt(a�o);
		Calendar fecha=new GregorianCalendar(numA�o,numMes,numDia);
		em.addEstudiante(new Estudiante(numId,name,last,fecha));
		em.addEstudiante(new Estudiante(numId,name+"2",last,fecha));
		
		sc.close();
		//em.lista_estudiantes.DisplayList();		
	}

}
