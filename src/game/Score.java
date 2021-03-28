package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

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
	
	public void drawScore(Graphics g) {
		g.setColor(new Color(55, 55, 55));
		//g.setFont(new Font("TimesRoman", Font.PLAIN, Map.TILE_SIZE/2));
		g.drawString(Integer.toString(score), Map.TILE_SIZE * 13 + 3, 25);
	}
}
