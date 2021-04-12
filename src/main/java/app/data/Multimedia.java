package app.data;

import app.enums.Category;
import app.enums.Punctuation;
/*
 * class from which most of the other classes
 *  will extend this class we have it to reuse each
 */
public abstract class Multimedia {

	private String name;
	private String year;
	private Category category;
	private Punctuation puntuation;
	
	/*
	 * Builder with all parameters
	 */
	public Multimedia(String name, String year, Category category, Punctuation puntuation) {
		super();
		this.name = name;
		this.year = year;
		this.category = category;
		this.puntuation = puntuation;
	}

	/* 
	 * default constructor
	 */
	public Multimedia() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Punctuation getPuntuation() {
		return puntuation;
	}

	public void setPuntuation(Punctuation puntuation) {
		this.puntuation = puntuation;
	}

	/*
	 * Method to string
	 */
	@Override
	public String toString() {
		return "Multimedia [name=" + name + ", year=" + year + ", category=" + category + ", puntuation=" + puntuation
				+ "]";
	}
	
	
	
}
