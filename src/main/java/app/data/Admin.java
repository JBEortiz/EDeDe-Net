package app.data;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Person {

  
	private  String pass;
	
	private List<User> users;
	
	private List<Flim> flims;
	
	private List<Serie> series;

	public Admin(String name, String lastName, String pass, List<User> users, List<Flim> flims, List<Serie> series) {
		super(name, lastName);
		this.pass = pass;
		this.users = new ArrayList<>();
		this.flims = new ArrayList<>();
		this.series = new ArrayList<>();
	}

	public Admin(String name, String lastName) {
		super(name, lastName);
		
		this.users = new ArrayList<>();
		this.flims = new ArrayList<>();
		this.series = new ArrayList<>();
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Flim> getFlims() {
		return flims;
	}

	public void setFlims(List<Flim> flims) {
		this.flims = flims;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	@Override
	public String toString() {
		return "Admin [pass=" + pass + ", users=" + users + ", flims=" + flims + ", series=" + series + ", name=" + name
				+ ", lastName=" + lastName + "]";
	}
	

	
	
	
	
	
}
