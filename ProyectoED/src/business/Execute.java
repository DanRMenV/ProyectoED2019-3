package business;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;

import data.*;

import java.util.*;
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
		System.out.println("Ingrese dia nac");
		String dia=sc.nextLine();
		int numDia=Integer.parseInt(dia);
		System.out.println("Ingrese mes nac");
		String mes=sc.nextLine();
		int numMes=Integer.parseInt(mes);
		System.out.println("Ingrese año nac");
		String año=sc.nextLine();
		int numAño=Integer.parseInt(año);
		Calendar fecha=new GregorianCalendar(numAño,numMes,numDia);
		em.addEstudiante(new Estudiante(numId,name,last,fecha));
		em.addEstudiante(new Estudiante(numId+1,name+"2",last,fecha));
		
		
		
		//em.lista_estudiantes.DisplayList();		
		System.out.println("Escriba id a buscar");
		String search=sc.nextLine();
		int idABuscar=Integer.parseInt(search);
				
		System.out.println(em.searchEstudiante(idABuscar).getNombre_estudiante());
		
		
		
		sc.close();

		Scanner scan = new Scanner(System.in);
		AdminList lst_admin = new AdminList();
		lst_admin.PushBack("juanse","123456");
		lst_admin.PushBack("eltrolazo","123456");
		lst_admin.PushBack("dmendivelso","123456");
		lst_admin.PushBack("k","123456");
		lst_admin.PushBack("admin","123456");
		lst_admin.DisplayList();
		String temp_user,temp_password;
		temp_user = scan.nextLine();
		temp_password = scan.nextLine();
		Admin temp_admin=lst_admin.FindByKey(temp_user, temp_password);
		if(temp_admin.getUsername()!=null) {
			System.out.println("Acceso garantizado");
		}else {
			System.out.println("Clave o usuario incorrecto");
		}
	}

}
