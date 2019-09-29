package business;
import data.*;
import java.util.*;
public class Execute {

	public static void main(String[] args) {
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
