package game;

public abstract class Character {

	int id;
	String name, characterType;
	Location location;
	
	public Character() {
		// TODO Auto-generated constructor stub
	}

	public Character(int id, String name, String characterType, Location location) {
		this.id = id;
		this.name = name;
		this.characterType = characterType;
		this.location = location;
	}
	
	
	
}
