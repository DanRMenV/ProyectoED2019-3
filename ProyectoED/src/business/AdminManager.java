package business;

import data.*;

public class AdminManager {
	ListAdmin lista_admin;
	public AdminManager() {
		this.lista_admin = new ListAdmin();
	}
	public void addAdminUser(Admin a) {
		this.lista_admin.PushBack(a);
	}
	public Boolean ValUser(Admin a){
		return this.lista_admin.ValidateUser(a);
	}
	public void printUsers() {
		this.lista_admin.DisList();
	}
}
