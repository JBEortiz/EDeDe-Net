package app.data;

import java.time.LocalDate;

public class User extends Person{
	
	private LocalDate date;

	public User(String name, String lastName, LocalDate date) {
		super(name, lastName);
		this.date = date;
	}

	public User(String name, String lastName) {
		super(name, lastName);
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [date=" + date + ", name=" + name + ", lastName=" + lastName + "]";
	}

	
	
	

}
