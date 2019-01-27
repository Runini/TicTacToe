import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Board {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	Scanner read = new Scanner(System.in);
	Random roll = new Random();
	int field;
	int round = 1;
	String winner = "";
	boolean gameover = false;
	boolean youPlayer2 = false;
	boolean fieldAvailable = true;
	String player1 = "";
	String player2 = "";
	String[][] map = new String [3][3];
	
	public void setPlayerFigure() {
		do {
			System.out.println("You choose: X or O");
			player1 = read.nextLine();
		}while(!player1.equals("X") && (!player1.equals("O"))); //choose X or O to skip loop
		System.out.println("You choosed: "+player1);
		if (player1.equals("X"))
			player2 = "O";
		else if (player1.equals("O"))
			player2 = "X";
	}
	
	public void drawFigure() throws InterruptedException, IOException { // draw X or O 
		youPlayer2 = false;
		if(player1.equals("X"))
			setX();
		if(player1.equals("O"))
			setO();
	}
	
	public void botDrawFigure() throws InterruptedException, IOException {// bot draw X or O
		youPlayer2 = true;
		if(player2.equals("X"))
			setX();
		if(player2.equals("O"))
			setO();
		round++;
	}
	
	public void createBoard() {  //create map
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map.length;j++) {
				map[i][j] = " ";
			}
		}
		printBoard();
		System.out.println();
	}
	
	public void printBoard() { //print map
		System.out.print("\t");
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map.length;j++) {
				if ((i == 1 && j == 0) || (i == 2 & j == 0) ) {
					System.out.println();
					System.out.print("\t");
				}
				System.out.print("["+map[i][j]+"]");			
			}	
		}
		System.out.println();
	}
	
	public void winningConditions() { // to win
		//first upright X and O
		if ((map[0][0].equals("X")) && (map[1][0].equals("X")) && (map[2][0].equals("X")) 
		 || (map[0][1].equals("X")) && (map[1][1].equals("X")) && (map[2][1].equals("X"))
		 || (map[0][2].equals("X")) && (map[1][2].equals("X")) && (map[2][2].equals("X"))){
			
			if (player1.equals("X")) {
				winner = "player1";
				gameover = true;
			}else if (player2.equals("X")) {
				winner = "player2";
				gameover = true;
			}
		}else if ((  map[0][0].equals("O")) && (map[1][0].equals("O")) && (map[2][0].equals("O")) 
				 || (map[0][1].equals("O")) && (map[1][1].equals("O")) && (map[2][1].equals("O"))
				 || (map[0][2].equals("O")) && (map[1][2].equals("O")) && (map[2][2].equals("O"))) {
			
			if (player1.equals("O")) {
				winner = "player1";
				gameover = true;
			}else if (player2.equals("O")) {
				winner = "player2";
				gameover = true;
			}
		}
		//second horizontally X and O
		if ((map[0][0].equals("X")) && (map[0][1].equals("X")) && (map[0][2].equals("X")) 
		 || (map[1][0].equals("X")) && (map[1][1].equals("X")) && (map[1][2].equals("X"))
		 || (map[2][0].equals("X")) && (map[2][1].equals("X")) && (map[2][2].equals("X"))){
			
					if (player1.equals("X")) {
						winner = "player1";
						gameover = true;
					}else if (player2.equals("X")) {
						winner = "player2";
						gameover = true;
					}
		}else if ((  map[0][0].equals("O")) && (map[0][1].equals("O")) && (map[0][2].equals("O")) 
				 || (map[1][0].equals("O")) && (map[1][1].equals("O")) && (map[1][2].equals("O"))
				 || (map[2][0].equals("O")) && (map[2][1].equals("O")) && (map[2][2].equals("O"))) {
			
					if (player1.equals("O")) {
						winner = "player1";
						gameover = true;
					}else if (player2.equals("O")) {
						winner = "player2";
						gameover = true;
					}
				}
		//diagonally
		if ((map[0][0].equals("X")) && (map[1][1].equals("X")) && (map[2][2].equals("X")) 
		 || (map[0][2].equals("X")) && (map[1][1].equals("X")) && (map[2][0].equals("X"))) {
			
			if (player1.equals("X")) {
				winner = "player1";
				gameover = true;
			}else if (player2.equals("X")) {
				winner = "player2";
				gameover = true;
			}
		}else if ((map[0][0].equals("O")) && (map[1][1].equals("O")) && (map[2][2].equals("O")) 
			  || (map[0][2].equals("O")) && (map[1][1].equals("O")) && (map[2][0].equals("O"))) {
			
			if (player1.equals("O")) {
				winner = "player1";
				gameover = true;
			}else if (player2.equals("O")) {
				winner = "player2";
				gameover = true;
		}
		
		}
	}
	
	public void lookDraw () { //look to draw
		int busyFields = 0;
		
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map.length;j++) {
				if (map[i][j].equals("X") || map[i][j].equals("O")) {
					busyFields++;
				}
				else {}
			}
		}
		if (winner.equals("") && busyFields == 9) {
			System.out.println("Draw!");
			gameover = true;
		}else {}
	}
	
	
	public void lookWin() { //look to win
		if (winner.equals("player1") || (winner.equals("player2")) )
			gameover = true;
	}
	
	public void printScore() { //print winner
		System.out.println("Winner is: "+winner);
	}
	
	public void printRound() { //actually round
		System.out.println("\t\t\tRound "+round+":");
	}

	
	public void setX() throws InterruptedException, IOException { //set X with check field collision
		
		do {
			do { // field map 1 - 9
				
				if (youPlayer2) { // bot player random field draw
					int randomFigure = roll.nextInt(8);
					randomFigure++;
					field = randomFigure;
					//System.out.println("Bot choose: "+field);
					break;
				}else
					System.out.println("Where do you want to put X ?");
				field = read.nextInt();
				if (field <= 0 || field >= 10)
					System.out.println("Try again:");
			}while(field < 0 || field > 10);
		
		switch(field) { // add X to tab
		case 1:
		{
			if (map[0][0].equals(" ")) {
				map[0][0] = "X";
				fieldAvailable = false;
				break;
			}else if (!map[0][0].equals(" ")) {
				if (youPlayer2) {
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
			if (map[0][1].equals(" ")) {
				map[0][1] = "X";
				fieldAvailable = false;
				break;
			}else if (!map[0][1].equals(" ")) {
				if (youPlayer2) {
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
			if (map[0][2].equals(" ")) {
				map[0][2] = "X";
				fieldAvailable = false;
				break;
			}else if (!map[0][2].equals(" ")) {
				if (youPlayer2) {
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
			if (map[1][0].equals(" ")) {
				map[1][0] = "X";
				fieldAvailable = false;
				break;
			}else if (!map[1][0].equals(" ")) {
				if (youPlayer2) {
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
			if (map[1][1].equals(" ")) {
				map[1][1] = "X";
				fieldAvailable = false;
				break;
			}else if (!map[1][1].equals(" ")) {
				if (youPlayer2) {
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
			if (map[1][2].equals(" ")) {
				map[1][2] = "X";
				fieldAvailable = false;
				break;
			}else if (!map[1][2].equals(" ")) {
				if (youPlayer2) {
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
			if (map[2][0].equals(" ")) {
				map[2][0] = "X";
				fieldAvailable = false;
				break;
			}else if (!map[2][0].equals(" ")) {
				if (youPlayer2) {
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
			if (map[2][1].equals(" ")) {
				map[2][1] = "X";
				fieldAvailable = false;
				break;
			}else if (!map[2][1].equals(" ")) {
				if (youPlayer2) {
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
			if (map[2][2].equals(" ")) {
				map[2][2] = "X";
				fieldAvailable = false;
				break;
			}else if (!map[2][2].equals(" ")) {
				if (youPlayer2) {
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
		}while(fieldAvailable == true);
		
	}
	public void setO() throws InterruptedException, IOException { //set X with check field collision
		do {
			do { // field map 1 - 9
				
				if (youPlayer2) { //bot player random field draw
					int randomFigure = roll.nextInt(8);
					randomFigure++;
					field = randomFigure;
					//System.out.println("Bot choose: "+field);
					break;
				}else
					System.out.println("Where do you want to put O ?"); //skip print bot
				field = read.nextInt();
				if (field <= 0 || field >= 10)
					System.out.println("Try again:");
			}while(field <= 0 || field >= 10);
				
		switch(field) { // add O to tab
		case 1:
		{
			if (map[0][0].equals(" ")) {
				map[0][0] = "O";
				fieldAvailable = false;
				break;
			}else if (!map[0][0].equals(" ")) {
				if (youPlayer2) { //all cases - stop spam bot 
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
			if (map[0][1].equals(" ")) {
				map[0][1] = "O";
				fieldAvailable = false;
				break;
			}else if (!map[0][1].equals(" ")) {
				if (youPlayer2) {
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
			if (map[0][2].equals(" ")) {
				map[0][2] = "O";
				fieldAvailable = false;
				break;
			}else if (!map[0][2].equals(" ")) {
				if (youPlayer2) {
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
			if (map[1][0].equals(" ")) {
				map[1][0] = "O";
				fieldAvailable = false;
				break;
				}else if (map[1][0].equals(" ")) {
					if (youPlayer2) {
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
			if (map[1][1].equals(" ")) {
				map[1][1] = "O";
				fieldAvailable = false;
				break;
			}else if (!map[1][1].equals(" ")) {
				if (youPlayer2) {
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
			if (map[1][2].equals(" ")) {
				map[1][2] = "O";
				fieldAvailable = false;
				break;
			}else if (!map[1][2].equals(" ")) {
				if (youPlayer2) {
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
			if (map[2][0].equals(" ")) {
				map[2][0] = "O";
				fieldAvailable = false;
				break;
			}else if (!map[2][0].equals(" ")) {
				if (youPlayer2) {
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
			if (map[2][1].equals(" ")) {
				map[2][1] = "O";
				fieldAvailable = false;
				break;
			}else if (!map[2][1].equals(" ")) {
				if (youPlayer2) {
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
			if (map[2][2].equals(" ")) {
				map[2][2] = "O";
				fieldAvailable = false;
				break;
			}else if (!map[2][2].equals(" ")) {
				if (youPlayer2) {
					fieldAvailable = true;
					break;
				}else {
				System.out.println("The field is busy");
				clrscr();
				fieldAvailable = true;
				break ;
			}
			}
		}
		default:
			System.out.println("Field Unavailable");
			break;
		}
		}while(fieldAvailable == true);
		
	}
	
	public void clrscr() throws InterruptedException, IOException{
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

