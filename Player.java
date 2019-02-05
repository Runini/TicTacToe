import java.util.Scanner;

public class Player implements Players {

	public static String winner = "";
	public static String player1 = "";
	public static String player2 = "";
	public static boolean youPlayer2 = false;
	Scanner read = new Scanner(System.in);
	
	@Override
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
	
	@Override
	public void printScore() { //print winner
		System.out.println("Winner is: "+winner);
	}
}
