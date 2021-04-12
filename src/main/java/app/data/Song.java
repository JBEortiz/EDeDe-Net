package app.data;
/*
 * The sound class, 
 * although it is related to Series and movies,
 * does not have the same format 
 * therefore it will not extend multimedia
 */
public class Song {

	private String name;
	private String autor;
	private String duration;

	/*
	 * Builder with all parameters
	 */
	public Song(String name, String autor, String duration) {
		super();
		this.name = name;
		this.autor = autor;
		this.duration = duration;
	}

	/* 
	 * default constructor
	 */
	public Song() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Song: " + name + " Autor: " + autor + " Duration: " + duration ;
	}

}
