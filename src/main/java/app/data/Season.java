package app.data;

public class Season {
	
	private int number;
	private String name;

	
	public Season(int number, String name) {
		super();
		this.number = number;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Season [number=" + number + ", name=" + name + "]";
	}

	
	
	
}
