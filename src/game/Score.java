package game;

public class Score {

	private int score;
	
	public Score() {
		score = 0;
	}
	
	public Score(int score) {
		this.score = score;
	}
	
	public void addScore(int amount) {
		this.score += amount;
	}
	
	public void subtractScore(int amount) {
		this.score -= amount;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void drawScore() {
		
		System.out.println(score);
	}
}
