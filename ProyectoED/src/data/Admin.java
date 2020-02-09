package data;

public class Admin {
	long id;
	String username;
	String password;
	Admin next;
	public Admin(long id, String username, String userpassword) {
		super();
		this.id = id;
		this.username = username;
		this.password = userpassword;
	}
	//Polimorfismo usado para validación
	public Admin(long id, String userpassword) {
		super();
		this.id = id;
		this.password = userpassword;
	}
	public long getid() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
