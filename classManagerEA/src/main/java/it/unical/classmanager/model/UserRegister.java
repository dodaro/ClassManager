package it.unical.classmanager.model;

public class UserRegister {
	
	String username;
	String password;	
	String role;
	String firstName;
	String lastName;
	
	public UserRegister() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = PasswordHashing.getHashAndSalt(password);
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "["+ getUsername() + " " + getPassword() + " " + getFirstName() + " " + getLastName() + " " + getRole() + "]";
	}
	
	
}
