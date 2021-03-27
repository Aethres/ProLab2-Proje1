package game;

public class Location {

	private int x;
	private int y;
	
	public Location() {
		this.x = 0;
		this.y = 0;
	}
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setLocation(Location location) {
		this.x = location.getX();
		this.y = location.getY();
	}
	
	public Location cloneLocation() {
		return new Location(x, y);
	}
	
	
}
