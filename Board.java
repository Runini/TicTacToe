
import java.util.Scanner;

public class Board implements BoardGenerator {
	
	
	
	static Scanner read = new Scanner(System.in);
	static int round = 1; //actually round
	
	public static boolean gameover = false;
	static int height;  
	static int width; 
	
	static String[][] map;
	@Override
	public void createBoard(int height, int width) {  //create map
			
		map = new String [height][width];
		this.height = height;
		this.width = width;
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map.length;j++) {
				map[i][j] = " ";
			}
		}
		printBoard();
		System.out.println();
	}
	
	@Override
	public void printBoard() { //print map	
		System.out.print("\t ");
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map.length;j++) {
				if (i <= height && j == 0) {
					System.out.println();
					System.out.print("\t");
				}
				System.out.print("["+map[i][j]+"]");			
			}	
		}
		System.out.println();
	}
	
	@Override
	public void printRound() { //actually round
		System.out.println("\t\t\tRound "+round+":");
	}
}

