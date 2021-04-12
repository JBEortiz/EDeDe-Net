package app.data;

import app.enums.Category;
import app.enums.Punctuation;

/*
 * Movie entity this class only has the attributes
 * 
 */
public class Film extends Multimedia {

	private String duration;
 
	/*
	 * Builder with all parameters
	 */
	public Film(String name, String year, Category category, Punctuation puntuation, String duration) {
		super(name, year, category, puntuation);
		this.duration = duration;
	}

	/*
	 * builder only with 
	 * the attributes of the erence
	 */
	public Film(String name, String year, Category category, Punctuation puntuation) {
		super(name, year, category, puntuation);
	}

	/* 
	 * default constructor
	 */
	public Film() {

	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	/*
	 * to string method
	 */
	@Override
	public String toString() {
		return "Title: " + getName() + " Year: " + getYear()
				+ " Category: " + getCategory() + " Puntuation: " + getPuntuation()+" Duration: " + duration;
	}

}
