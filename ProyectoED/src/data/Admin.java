package data;

public class Admin {
	String username;
	String password;
	Admin next;
	Admin prev;
	public Admin(String username, String userpassword) {
		super();
		this.username = username;
		this.password = userpassword;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
