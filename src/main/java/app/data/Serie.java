package app.data;

import java.util.List;

import app.enums.Category;
import app.enums.Punctuation;
/*
 * the series class will have
 * the relationship with seasons
 * since each series is composed
 * of a set of seasons
 */
public class Serie extends Multimedia{
	/*
	 * list of seasons that each series has
	 */
	private List<Season> Seasons;
	
	/*
	 * Builder with all parameters
	 */
	public Serie(String name, String year, Category category, Punctuation puntuation, List<Season> seasons) {
		super(name, year, category, puntuation);
		Seasons = seasons;
	}

	/*
	 * builder only with 
	 * the attributes of the erence
	 */
	public Serie(String name, String year, Category category, Punctuation puntuation) {
		super(name, year, category, puntuation);
	}
	
	/* 
	 * default constructor
	 */
	public Serie() {
		
	}
	public List<Season> getSeasons() {
		return Seasons;
	}

	public void setSeasons(List<Season> seasons) {
		Seasons = seasons;
	}
	
	/*
	 * to string method
	 */
	@Override
	public String toString() {
		return "Name: " + getName() + " Year: " + getYear()
				+ " C: " + getCategory() + " P: " + getPuntuation()+"\n --- "+ Seasons+ "---";
	}
	

}
