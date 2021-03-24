package app.data;

import app.enums.Category;
import app.enums.Punctuation;

public class Flim extends Multimedia{
	
	private String duration;

	public Flim(String name, String year, Category category, Punctuation puntuation, String duration) {
		super(name, year, category, puntuation);
		this.duration = duration;
	}

	public Flim(String name, String year, Category category, Punctuation puntuation) {
		super(name, year, category, puntuation);
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Flim [duration=" + duration + ", getName()=" + getName() + ", getYear()=" + getYear()
				+ ", getCategory()=" + getCategory() + ", getPuntuation()=" + getPuntuation();
	}

	

	
	
	
}
