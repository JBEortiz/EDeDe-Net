package app.data;

public class Song {

	private String name;
	private String autor;
	private String duration;

	public Song(String name, String autor, String duration) {
		super();
		this.name = name;
		this.autor = autor;
		this.duration = duration;
	}

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
		return "Song [name=" + name + ", autor=" + autor + ", duration=" + duration + "]";
	}

}
