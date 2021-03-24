package app.data;

public class Season {
	
	private String name;

	public Season(String name) {
		super();
		this.name = name;
	}

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
		return "Season [name=" + name + "]";
	}
	
	
}
