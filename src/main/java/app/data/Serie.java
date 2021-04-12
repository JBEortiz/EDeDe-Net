package app.data;

import java.util.List;

import app.enums.Category;
import app.enums.Punctuation;

public class Serie extends Multimedia{
	
	private List<Season> Seasons;

	public Serie(String name, String year, Category category, Punctuation puntuation, List<Season> seasons) {
		super(name, year, category, puntuation);
		Seasons = seasons;
	}

	public Serie(String name, String year, Category category, Punctuation puntuation) {
		super(name, year, category, puntuation);
	}

	public Serie() {
		
	}
	public List<Season> getSeasons() {
		return Seasons;
	}

	public void setSeasons(List<Season> seasons) {
		Seasons = seasons;
	}

	@Override
	public String toString() {
		return "Name: " + getName() + " Year: " + getYear()
				+ " C: " + getCategory() + " P: " + getPuntuation()+"\n --- "+ Seasons+ "---";
	}
	

}
