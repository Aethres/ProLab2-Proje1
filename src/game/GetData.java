package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class GetData {
	
	
	
	private int map[][];
	private String enemies[];
	private BufferedImage enemy1, enemy2, player1, player2, goal;
	
	
	public GetData() {
		loadText();
		loadImages();
		
		
	}
	
	public void loadImages() {
		String filePath = new File("").getAbsolutePath();
        try 
        {
            enemy1 = ImageIO.read(new File(filePath + "\\Resources\\enemy1.png"));
            enemy2 = ImageIO.read(new File(filePath + "\\Resources\\enemy2.png"));
            player1 = ImageIO.read(new File(filePath + "\\Resources\\player1.png"));
            player2 = ImageIO.read(new File(filePath + "\\Resources\\player2.png"));
            goal = ImageIO.read(new File(filePath + "\\Resources\\goal.png"));
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

	public BufferedImage getEnemy1() {
		return enemy1;
	}

	public BufferedImage getEnemy2() {
		return enemy2;
	}

	public BufferedImage getPlayer1() {
		return player1;
	}

	public BufferedImage getPlayer2() {
		return player2;
	}

	public BufferedImage getGoal() {
		return goal;
	}
	
	
}
