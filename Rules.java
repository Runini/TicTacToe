
public class Rules {

	public void winningConditions() { // to win
		//first upright X and O
		if ((Board.map[0][0].equals("X")) && (Board.map[1][0].equals("X")) && (Board.map[2][0].equals("X")) 
		 || (Board.map[0][1].equals("X")) && (Board.map[1][1].equals("X")) && (Board.map[2][1].equals("X"))
		 || (Board.map[0][2].equals("X")) && (Board.map[1][2].equals("X")) && (Board.map[2][2].equals("X"))){
			
			if (Player.player1.equals("X")) {
				Player.winner = "player1";
				Board.gameover = true;
			}else if (Player.player2.equals("X")) {
				Player.winner = "player2";
				Board.gameover = true;
			}
		}else if ((  Board.map[0][0].equals("O")) && (Board.map[1][0].equals("O")) && (Board.map[2][0].equals("O")) 
				 || (Board.map[0][1].equals("O")) && (Board.map[1][1].equals("O")) && (Board.map[2][1].equals("O"))
				 || (Board.map[0][2].equals("O")) && (Board.map[1][2].equals("O")) && (Board.map[2][2].equals("O"))) {
			
			if (Player.player1.equals("O")) {
				Player.winner = "player1";
				Board.gameover = true;
			}else if (Player.player2.equals("O")) {
				Player.winner = "player2";
				Board.gameover = true;
			}
		}
		//second horizontally X and O
		if ((Board.map[0][0].equals("X")) && (Board.map[0][1].equals("X")) && (Board.map[0][2].equals("X")) 
		 || (Board.map[1][0].equals("X")) && (Board.map[1][1].equals("X")) && (Board.map[1][2].equals("X"))
		 || (Board.map[2][0].equals("X")) && (Board.map[2][1].equals("X")) && (Board.map[2][2].equals("X"))){
			
					if (Player.player1.equals("X")) {
						Player.winner = "player1";
						Board.gameover = true;
					}else if (Player.player2.equals("X")) {
						Player.winner = "player2";
						Board.gameover = true;
					}
		}else if ((  Board.map[0][0].equals("O")) && (Board.map[0][1].equals("O")) && (Board.map[0][2].equals("O")) 
				 || (Board.map[1][0].equals("O")) && (Board.map[1][1].equals("O")) && (Board.map[1][2].equals("O"))
				 || (Board.map[2][0].equals("O")) && (Board.map[2][1].equals("O")) && (Board.map[2][2].equals("O"))) {
			
					if (Player.player1.equals("O")) {
						Player.winner = "player1";
						Board.gameover = true;
					}else if (Player.player2.equals("O")) {
						Player.winner = "player2";
						Board.gameover = true;
					}
				}
		//diagonally
		if ((Board.map[0][0].equals("X")) && (Board.map[1][1].equals("X")) && (Board.map[2][2].equals("X")) 
		 || (Board.map[0][2].equals("X")) && (Board.map[1][1].equals("X")) && (Board.map[2][0].equals("X"))) {
			
			if (Player.player1.equals("X")) {
				Player.winner = "player1";
				Board.gameover = true;
			}else if (Player.player2.equals("X")) {
				Player.winner = "player2";
				Board.gameover = true;
			}
		}else if ((Board.map[0][0].equals("O")) && (Board.map[1][1].equals("O")) && (Board.map[2][2].equals("O")) 
			  || (Board.map[0][2].equals("O")) && (Board.map[1][1].equals("O")) && (Board.map[2][0].equals("O"))) {
			
			if (Player.player1.equals("O")) {
				Player.winner = "player1";
				Board.gameover = true;
			}else if (Player.player2.equals("O")) {
				Player.winner = "player2";
				Board.gameover = true;
		}
		
		}

	}
	
	public void lookDraw () { //look to draw
		int busyFields = 0;
		
		for (int i=0;i<Board.map.length;i++) {
			for (int j=0;j<Board.map.length;j++) {
				if (Board.map[i][j].equals("X") || Board.map[i][j].equals("O")) {
					busyFields++;
				}
				else {}
			}
		}
		if (Player.winner.equals("") && busyFields == 9) {
			System.out.println("Draw!");
			Board.gameover = true;
		}else {}
	}


	public void lookWin() { //look to win
		if (Player.winner.equals("player1") || (Player.winner.equals("player2")) )
			Board.gameover = true;
	}
	
	
	//public void rules() {
	//}
}