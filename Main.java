import java.io.IOException;

public class Main {
	
	public static void main(String[]args) throws InterruptedException, IOException {
		Board game = new Board();
		
		System.out.println("Welcome in Tic Tac Toe game!");
		game.clrscr();
		game.createBoard();  // 1raz
		game.setPlayerFigure(); // 1raz
		
		while (game.gameover == false) {
		// we have turn 
		game.printRound();
		game.drawFigure();
		game.printBoard();
		Thread.sleep(1500);
		game.winningConditions();
		game.lookWin();
		game.lookDraw();
		if (game.gameover == true)
			break;
		System.out.println();
		// bot turn
		game.botDrawFigure();
		game.printBoard();
		Thread.sleep(1500);
		game.winningConditions();
		game.lookWin();
		game.lookDraw();
		if (game.gameover == true)
			break;
		
		}
		
		game.printScore();
		System.out.println("End game");
	}
}
