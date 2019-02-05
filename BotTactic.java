import java.util.Random;

public class BotTactic {
	
	/*
	 * In first round or in round which there are no 2 symbols around, bot roll random digit
	 * In 2 and more rounds, bot check combinations(horizontal,vertical and diagonal) so that player1 doesn't win
	 */
	static boolean randoms = false;
	public static void botThinking() {
		if (Player.player2.equals("X")) {
			
		
			if (Board.round == 1) {
				randoms = true;
				Random roll = new Random();
				int randomFigure = roll.nextInt(8);
				randomFigure++;
				Figure.field = randomFigure;
			}
				
			// horizontal tactics 
			//first 
			if(Board.map[0][0].equals("O") && Board.map[0][1].equals("O") && Board.map[0][2].equals(" "))
			{
				Board.map[0][2] = Figure.XO;
			}
			else if(Board.map[0][0].equals("O") && Board.map[0][2].equals("O") && Board.map[0][1].equals(" "))
			{
				Board.map[0][1] = Figure.XO;
			}
			else if(Board.map[0][1].equals("O") && Board.map[0][2].equals("O") && Board.map[0][0].equals(" "))
			{
				Board.map[0][0] = Figure.XO;
			}
			
			//second
			else if(Board.map[1][0].equals("O") && Board.map[1][1].equals("O") && Board.map[1][2].equals(" "))
			{
				Board.map[1][2] = Figure.XO;
			}
			else if(Board.map[1][0].equals("O") && Board.map[1][2].equals("O") && Board.map[1][1].equals(" "))
			{
				Board.map[1][1] = Figure.XO;
			}
			else if(Board.map[1][1].equals("O") && Board.map[1][2].equals("O") && Board.map[1][0].equals(" "))
			{
				Board.map[1][0] = Figure.XO;
			}
			
			//three
			else if(Board.map[2][0].equals("O") && Board.map[2][1].equals("O") && Board.map[2][2].equals(" "))
			{
				Board.map[2][2] = Figure.XO;
			}
			else if(Board.map[2][0].equals("O") && Board.map[2][2].equals("O") && Board.map[2][1].equals(" "))
			{
				Board.map[2][1] = Figure.XO;
			}
			else if(Board.map[2][1].equals("O") && Board.map[2][2].equals("O") && Board.map[2][0].equals(" "))
			{
				Board.map[2][0] = Figure.XO;
			}
			
			//vertical tactics
			//first 
			else if(Board.map[0][0].equals("O") && Board.map[1][0].equals("O") && Board.map[2][0].equals(" "))
			{
				Board.map[2][0] = Figure.XO;
			}
			else if(Board.map[0][0].equals("O") && Board.map[2][0].equals("O") && Board.map[1][0].equals(" "))
			{
				Board.map[1][0] = Figure.XO;
			}
			else if(Board.map[2][0].equals("O") && Board.map[1][0].equals("O") && Board.map[0][0].equals(" "))
			{
				Board.map[0][0] = Figure.XO;
			}
			
			//second
			else if(Board.map[0][1].equals("O") && Board.map[1][1].equals("O") && Board.map[2][1].equals(" "))
			{
				Board.map[2][1] = Figure.XO;
			}
			else if(Board.map[0][1].equals("O") && Board.map[2][1].equals("O") && Board.map[1][1].equals(" "))
			{
				Board.map[1][1] = Figure.XO;
			}
			else if(Board.map[1][1].equals("O") && Board.map[2][1].equals("O") && Board.map[0][1].equals(" "))
			{
				Board.map[0][1] = Figure.XO;
			}
			
			//three
			else if(Board.map[0][2].equals("O") && Board.map[1][2].equals("O") && Board.map[2][2].equals(" "))
			{
				Board.map[2][2] = Figure.XO;
			}
			else if(Board.map[0][2].equals("O") && Board.map[2][2].equals("O") && Board.map[1][2].equals(" "))
			{
				Board.map[1][2] = Figure.XO;
			}
			else if(Board.map[1][2].equals("O") && Board.map[2][2].equals("O") && Board.map[0][2].equals(" "))
			{
				Board.map[0][2] = Figure.XO;
			}
			
			//diagonal
			//first
			else if(Board.map[0][0].equals("O") && Board.map[1][1].equals("O") && Board.map[2][2].equals(" "))
			{
				Board.map[2][2] = Figure.XO;
			}
			else if(Board.map[0][0].equals("O") && Board.map[2][2].equals("O") && Board.map[1][1].equals(" "))
			{
				Board.map[1][1] = Figure.XO;
			}
			else if(Board.map[2][2].equals("O") && Board.map[1][1].equals("O") && Board.map[0][0].equals(" "))
			{
				Board.map[0][0] = Figure.XO;
			}
			
			//second
			else if(Board.map[0][2].equals("O") && Board.map[1][1].equals("O") && Board.map[2][0].equals(" "))
			{
				Board.map[2][0] = Figure.XO;
			}
			else if(Board.map[0][2].equals("O") && Board.map[2][0].equals("O") && Board.map[1][1].equals(" "))
			{
				Board.map[2][0] = Figure.XO;
			}
			else if(Board.map[2][0].equals("O") && Board.map[1][1].equals("O") && Board.map[0][2].equals(" "))
			{
				Board.map[0][2] = Figure.XO;
			}
		}
		else if (Player.player2.equals("O")) {
			
			if (Board.round == 1) {
				randoms = true;
				Random roll = new Random();
				int randomFigure = roll.nextInt(8);
				randomFigure++;
				Figure.field = randomFigure;
			}
			// horizontal tactics 
						//first 
						if(Board.map[0][0].equals("X") && Board.map[0][1].equals("X") && Board.map[0][2].equals(" "))
						{
							Board.map[0][2] = Figure.XO;
						}
						else if(Board.map[0][0].equals("X") && Board.map[0][2].equals("X") && Board.map[0][1].equals(" "))
						{
							Board.map[0][1] = Figure.XO;
						}
						else if(Board.map[0][1].equals("X") && Board.map[0][2].equals("X") && Board.map[0][0].equals(" "))
						{
							Board.map[0][0] = Figure.XO;
						}
						
						//second
						else if(Board.map[1][0].equals("X") && Board.map[1][1].equals("X") && Board.map[1][2].equals(" "))
						{
							Board.map[1][2] = Figure.XO;
						}
						else if(Board.map[1][0].equals("X") && Board.map[1][2].equals("X") && Board.map[1][1].equals(" "))
						{
							Board.map[1][1] = Figure.XO;
						}
						else if(Board.map[1][1].equals("X") && Board.map[1][2].equals("X") && Board.map[1][0].equals(" "))
						{
							Board.map[1][0] = Figure.XO;
						}
						
						//three
						else if(Board.map[2][0].equals("X") && Board.map[2][1].equals("X") && Board.map[2][2].equals(" "))
						{
							Board.map[2][2] = Figure.XO;
						}
						else if(Board.map[2][0].equals("X") && Board.map[2][2].equals("X") && Board.map[2][1].equals(" "))
						{
							Board.map[2][1] = Figure.XO;
						}
						else if(Board.map[2][1].equals("X") && Board.map[2][2].equals("X") && Board.map[2][0].equals(" "))
						{
							Board.map[2][0] = Figure.XO;
						}
						
						//vertical tactics
						//first 
						else if(Board.map[0][0].equals("X") && Board.map[1][0].equals("X") && Board.map[2][0].equals(" "))
						{
							Board.map[2][0] = Figure.XO;
						}
						else if(Board.map[0][0].equals("X") && Board.map[2][0].equals("X") && Board.map[1][0].equals(" "))
						{
							Board.map[1][0] = Figure.XO;
						}
						else if(Board.map[2][0].equals("X") && Board.map[1][0].equals("X") && Board.map[0][0].equals(" "))
						{
							Board.map[0][0] = Figure.XO;
						}
						
						//second
						else if(Board.map[0][1].equals("X") && Board.map[1][1].equals("X") && Board.map[2][1].equals(" "))
						{
							Board.map[2][1] = Figure.XO;
						}
						else if(Board.map[0][1].equals("X") && Board.map[2][1].equals("X") && Board.map[1][1].equals(" "))
						{
							Board.map[1][1] = Figure.XO;
						}
						else if(Board.map[1][1].equals("X") && Board.map[2][1].equals("X") && Board.map[0][1].equals(" "))
						{
							Board.map[0][1] = Figure.XO;
						}
						
						//three
						else if(Board.map[0][2].equals("X") && Board.map[1][2].equals("X") && Board.map[2][2].equals(" "))
						{
							Board.map[2][2] = Figure.XO;
						}
						else if(Board.map[0][2].equals("X") && Board.map[2][2].equals("X") && Board.map[1][2].equals(" "))
						{
							Board.map[1][2] = Figure.XO;
						}
						else if(Board.map[1][2].equals("X") && Board.map[2][2].equals("X") && Board.map[0][2].equals(" "))
						{
							Board.map[0][2] = Figure.XO;
						}
						
						//diagonal
						//first
						else if(Board.map[0][0].equals("X") && Board.map[1][1].equals("X") && Board.map[2][2].equals(" "))
						{
							Board.map[2][2] = Figure.XO;
						}
						else if(Board.map[0][0].equals("X") && Board.map[2][2].equals("X") && Board.map[1][1].equals(" "))
						{
							Board.map[1][1] = Figure.XO;
						}
						else if(Board.map[2][2].equals("X") && Board.map[1][1].equals("X") && Board.map[0][0].equals(" "))
						{
							Board.map[0][0] = Figure.XO;
						}
						
						//second
						else if(Board.map[0][2].equals("X") && Board.map[1][1].equals("X") && Board.map[2][0].equals(" "))
						{
							Board.map[2][0] = Figure.XO;
						}
						else if(Board.map[0][2].equals("X") && Board.map[2][0].equals("X") && Board.map[1][1].equals(" "))
						{
							Board.map[2][0] = Figure.XO;
						}
						else if(Board.map[2][0].equals("X") && Board.map[1][1].equals("X") && Board.map[0][2].equals(" "))
						{
							Board.map[0][2] = Figure.XO;
						}
		}
		else {
			randoms = true;
			Random roll = new Random();
			int randomFigure = roll.nextInt(8);
			randomFigure++;
			Figure.field = randomFigure;
			/*if (Board.map[0][0].equals(" ")) {
				Board.map[0][0] = Figure.XO;
				Figure.fieldAvailable = false;
				break;
			}else if (!Board.map[0][0].equals(" ")) {
				if (Player.youPlayer2) {
					Figure.fieldAvailable = true;
					break;
				}else {
				System.out.println("The field is busy");
				Figure.clrscr();
				Figure.fieldAvailable = true;
				break;
				}*/
		}
		
	}
}
