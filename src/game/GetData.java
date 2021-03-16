package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetData {
	
	
	
	private int map[][];
	private String enemies[];
	
	
	public GetData() {
		
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
}
