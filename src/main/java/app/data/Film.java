package app.data;

import app.enums.Category;
import app.enums.Punctuation;

/*
 * @
 * 
 */
public class Film extends Multimedia {

	private String duration;

	public Film(String name, String year, Category category, Punctuation puntuation, String duration) {
		super(name, year, category, puntuation);
		this.duration = duration;
	}

	public Film(String name, String year, Category category, Punctuation puntuation) {
		super(name, year, category, puntuation);
	}

	public Film() {

	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Title: " + getName() + " Year: " + getYear()
				+ " Category: " + getCategory() + " Puntuation: " + getPuntuation()+" Duration: " + duration;
	}

}
