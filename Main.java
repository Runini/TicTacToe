import java.io.IOException;

public class Main {
	
	public static void main(String[]args) throws InterruptedException, IOException {
		Board game = new Board();
		Player player = new Player();
		Figure figure = new Figure();
		Rules rules = new Rules();
		
		System.out.println("Welcome in Tic Tac Toe game!");
		Figure.clrscr();
		game.createBoard(3,3);  // one time create
		player.setPlayerFigure(); // one time choose
		
		while (Board.gameover == false) {
		// we have turn 
		game.printRound();
		figure.drawFigure("player1");
		game.printBoard();
		Thread.sleep(1500);
		rules.winningConditions();
		rules.lookWin();
		rules.lookDraw();
		if (Board.gameover == true)
			break;
		System.out.println();
		// bot turn
		figure.drawFigure("player2");
		game.printBoard();
		Thread.sleep(1500);
		rules.winningConditions();
		rules.lookWin();
		rules.lookDraw();
		if (Board.gameover == true)
			break;
		}
		
		player.printScore();
		System.out.println("End game");
	}
}
