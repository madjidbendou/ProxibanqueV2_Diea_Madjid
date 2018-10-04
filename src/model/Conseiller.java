package model;

public class Conseiller {
//Attributs
	private String login;
	private String password;

//Constructeurs
	public Conseiller(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

//Getters & Setters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//Méthodes
	@Override
	public String toString() {
		return "Conseiller [login=" + login + ", password=" + password + "]";
	}

}
