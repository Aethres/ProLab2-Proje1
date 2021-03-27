package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

public class GetData {
	
	
	
	private int map[][];
	private String enemies[], enemy1, enemy2;
	private String enemy1Location, enemy2Location;
	private BufferedImage enemy1Image, enemy2Image, player1, player2, goal, mushroomImage, goldImage;
	
	
	public GetData() {
		loadText();
		loadImages();
		
		
		Pattern pattern = Pattern.compile("(?<=Karakter\\:)(.*?)(?=\\,)");
		Matcher matcher = pattern.matcher(enemies[0]);
		while (matcher.find()) {
			enemy1 = matcher.group(1);
			System.out.println("Found value: " + enemy1 );
		}
		matcher = pattern.matcher(enemies[1]);
		while (matcher.find()) {
			enemy2 = matcher.group(1);
			System.out.println("Found value: " + enemy2 );
		}
		pattern = Pattern.compile("(?<=Kapi\\:)(.{1})");
		matcher = pattern.matcher(enemies[0]);
		while (matcher.find()) {
			enemy1Location = matcher.group(1);
			System.out.println("Found value: " + enemy1Location );
		}
		matcher = pattern.matcher(enemies[1]);
		while (matcher.find()) {
			enemy2Location = matcher.group(1);
			System.out.println("Found value: " + enemy2Location );
		}
		
	}
	
	public void loadImages() {
		String filePath = new File("").getAbsolutePath();
        try 
        {
            enemy1Image = ImageIO.read(new File(filePath + "\\Resources\\enemy1.png"));
            enemy2Image = ImageIO.read(new File(filePath + "\\Resources\\enemy2.png"));
            player1 = ImageIO.read(new File(filePath + "\\Resources\\player1.png"));
            player2 = ImageIO.read(new File(filePath + "\\Resources\\player2.png"));
            goal = ImageIO.read(new File(filePath + "\\Resources\\goal.png"));
            goldImage = ImageIO.read(new File(filePath + "\\Resources\\gold.png"));
            mushroomImage = ImageIO.read(new File(filePath + "\\Resources\\mushroom.png"));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        
		
	}
	
	public void loadText() {
		map = new int[11][13];
		enemies = new String[2];
		
		String filePath = new File("").getAbsolutePath();
        File file = new File(filePath + "\\Resources\\harita.txt");
        
        
        try(Scanner scanner = new Scanner(file)){
        	enemies[0] = scanner.nextLine();
        	enemies[1] = scanner.nextLine();
        	
        	for (int i = 0; i < map.length && scanner.hasNextLine(); i++) {
        		String[] str = scanner.nextLine().split("\t");
    			for (int j = 0; j < map[0].length; j++) {
    				map[i][j] = Integer.parseInt(str[j]);
    			}
    		}
        	
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int[][] getMap() {
		return map;
	}
	
	public String[] getEnemies() {
		return enemies;
	}

	public BufferedImage getEnemy1Image() {
		return enemy1Image;
	}

	public BufferedImage getEnemy2Image() {
		return enemy2Image;
	}

	public BufferedImage getPlayer1() {
		return player1;
	}

	public BufferedImage getPlayer2() {
		return player2;
	}

	public String getEnemy1Location() {
		return enemy1Location;
	}

	public void setEnemy1Location(String enemy1Location) {
		this.enemy1Location = enemy1Location;
	}

	public String getEnemy2Location() {
		return enemy2Location;
	}

	public void setEnemy2Location(String enemy2Location) {
		this.enemy2Location = enemy2Location;
	}

	public BufferedImage getGoal() {
		return goal;
	}

	public String getEnemy1() {
		return enemy1;
	}

	public void setEnemy1(String enemy1) {
		this.enemy1 = enemy1;
	}

	public String getEnemy2() {
		return enemy2;
	}

	public void setEnemy2(String enemy2) {
		this.enemy2 = enemy2;
	}

	public BufferedImage getMushroomImage() {
		return mushroomImage;
	}

	public void setMushroomImage(BufferedImage mushroomImage) {
		this.mushroomImage = mushroomImage;
	}

	public BufferedImage getGoldImage() {
		return goldImage;
	}

	public void setGoldImage(BufferedImage goldImage) {
		this.goldImage = goldImage;
	}
	
	
}
