package app.data;

import app.enums.Category;
import app.enums.Punctuation;

/*
 * The seasons class will be the smallest
 * class where we will only
 * have the name of the season
 */
public class Season {
	
	private String name;

	/*
	 * Builder with all parameters
	 */
	public Season( String name) {
		super();
		this.name = name;
	}

	/* 
	 * default constructor
	 */
	public Season() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "( " + name + ")";
	}


	
	
	
	
}
