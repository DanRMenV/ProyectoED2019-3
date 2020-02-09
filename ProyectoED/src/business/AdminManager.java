package business;

import data.*;

public class AdminManager {
	Hash hash_admin;
	public AdminManager() {
		this.hash_admin = new Hash(1000);
		//Se empieza con cardinalidad de 10000, sin embargo está cambia cuando se llena
	}
	public void addAdminUser(Admin a) {
		this.hash_admin.Add(a);
	}
	public Boolean ValUser(Admin a){
		return this.hash_admin.ValidateUser(a);
	}
	public void printUsers() {
		this.hash_admin.PrintHash();
	}
}
