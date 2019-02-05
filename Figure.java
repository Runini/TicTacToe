import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Figure {
	
	static Random roll = new Random();
	static Scanner read = new Scanner(System.in);
	
	public static boolean fieldAvailable = true;
	public static int field;  // to case, 1-9 number
	public static String XO;  //figure X or O
	
	public void drawFigure(String player) throws InterruptedException, IOException { // draw X or O 
		
		
		if (player.equals("player1")) 
		{
			Player.youPlayer2 = false;
			if(Player.player1.equals("X"))
					setXO("X"); //print X to parameter XO
			if(Player.player1.equals("O"))
					setXO("O"); // -||- O
		}
		else if (player.equals("player2"))
		{
			Player.youPlayer2 = true;
			if(Player.player2.equals("X"))
					setXO("X");
			if(Player.player2.equals("O"))
					setXO("O");
			Board.round++;
		}
	}
	
	public static void setXO(String XO) throws InterruptedException, IOException { //set X/O with check field collision
		
			Figure.XO = XO;
		do {
			do { // field map 1 - 9
				
				if (Player.youPlayer2) { // bot player random field draw
					//int randomFigure = roll.nextInt(8);
					//randomFigure++;
					//field = randomFigure;
					//System.out.println("Bot choose: "+field);
					BotTactic.botThinking();
					break;
				}else
					System.out.println("Where do you want to put "+XO+" ?");
				field = read.nextInt();
				if (field <= 0 || field >= 10)
					System.out.println("Try again:");
			}while(field < 0 || field > 10);
		if (Player.youPlayer2 && BotTactic.randoms == false)
			break;
		else if ((Player.youPlayer2 && BotTactic.randoms == true) || Player.youPlayer2 == false) {
		switch(field) { // add X or O to tab
		case 1:
		{
			if (Board.map[0][0].equals(" ")) {
				Board.map[0][0] = XO;
				fieldAvailable = false;
				break;
			}else if (!Board.map[0][0].equals(" ")) {
				if (Player.youPlayer2) {
					fieldAvailable = true;
					break;
				}else {
				System.out.println("The field is busy");
				clrscr();
				fieldAvailable = true;
				break;
				}
			}
			
		}
		case 2:
		{
			if (Board.map[0][1].equals(" ")) {
				Board.map[0][1] = XO;
				fieldAvailable = false;
				break;
			}else if (!Board.map[0][1].equals(" ")) {
				if (Player.youPlayer2) {
					fieldAvailable = true;
					break;
				}else {
				System.out.println("The field is busy");
				clrscr();
				fieldAvailable = true;
				break;
			}
			}
		}
		case 3:
		{
			if (Board.map[0][2].equals(" ")) {
				Board.map[0][2] = XO;
				fieldAvailable = false;
				break;
			}else if (!Board.map[0][2].equals(" ")) {
				if (Player.youPlayer2) {
					fieldAvailable = true;
					break;
				}else {
				System.out.println("The field is busy");
				clrscr();
				fieldAvailable = true;
				break;
			}
			}
		}
		case 4:
		{
			if (Board.map[1][0].equals(" ")) {
				Board.map[1][0] = XO;
				fieldAvailable = false;
				break;
			}else if (!Board.map[1][0].equals(" ")) {
				if (Player.youPlayer2) {
					fieldAvailable = true;
					break;
				}else {
				System.out.println("The field is busy");
				clrscr();
				fieldAvailable = true;
				break;
			}
			}
		}
		case 5:
		{
			if (Board.map[1][1].equals(" ")) {
				Board.map[1][1] = XO;
				fieldAvailable = false;
				break;
			}else if (!Board.map[1][1].equals(" ")) {
				if (Player.youPlayer2) {
					fieldAvailable = true;
					break;
				}else {
				System.out.println("The field is busy");
				clrscr();
				fieldAvailable = true;
				break;
			}
			}
		}
		case 6:
		{
			if (Board.map[1][2].equals(" ")) {
				Board.map[1][2] = XO;
				fieldAvailable = false;
				break;
			}else if (!Board.map[1][2].equals(" ")) {
				if (Player.youPlayer2) {
					fieldAvailable = true;
					break;
				}else {
				System.out.println("The field is busy");
				clrscr();
				fieldAvailable = true;
				break;
			}
			}
		}
		case 7:
		{
			if (Board.map[2][0].equals(" ")) {
				Board.map[2][0] = XO;
				fieldAvailable = false;
				break;
			}else if (!Board.map[2][0].equals(" ")) {
				if (Player.youPlayer2) {
					fieldAvailable = true;
					break;
				}else {
				System.out.println("The field is busy");
				clrscr();
				fieldAvailable = true;
				break;
			}
			}
		}
		case 8:
		{
			if (Board.map[2][1].equals(" ")) {
				Board.map[2][1] = XO;
				fieldAvailable = false;
				break;
			}else if (!Board.map[2][1].equals(" ")) {
				if (Player.youPlayer2) {
					fieldAvailable = true;
					break;
				}else {
				System.out.println("The field is busy");
				clrscr();
				fieldAvailable = true;
				break;
			}
			}
		}
		case 9:
		{
			if (Board.map[2][2].equals(" ")) {
				Board.map[2][2] = XO;
				fieldAvailable = false;
				break;
			}else if (!Board.map[2][2].equals(" ")) {
				if (Player.youPlayer2) {
					fieldAvailable = true;
					break;
				}else {
				System.out.println("The field is busy");
				clrscr();
				fieldAvailable = true;
				break;
			}
			}
		}
		default:
			System.out.println("Field Unavailable");
			}
		}
		BotTactic.randoms = false;
		}while(fieldAvailable == true);
		
	}

	public static void clrscr() throws InterruptedException, IOException{
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows")) {
	        	Thread.sleep(300);
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}
}
