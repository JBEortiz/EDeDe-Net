package app.data;

public class Season {
	
	private Integer id;
	private String name;
	private static int finalId;

	
	public Season( String name) {
		super();
		this.name = name;
	}

	public Season() {
		super();
		this.id=++finalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Season [id=" + id + ", name=" + name + "]";
	}


	
	
	
	
}
