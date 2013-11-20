import java.util.HashMap;


public class Board 
{
	private final int BOARD_LENGTH = 8;
	private Square[][] board = new Square[BOARD_LENGTH][BOARD_LENGTH];
	private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
	
	public Board()
	{	
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int u = 0; u < BOARD_LENGTH; u++)
			{
				board[i][u] = new Square();
			}
		}
		
		
	}
	
	public void displayBoard()
	{
		
		//for each square in board, display the displaysymbol
		int u = BOARD_LENGTH;
		System.out.println("  A  B  C  D  E  F  G  H");
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			System.out.print(u--);
			for(Square s : board[i])
			{
				System.out.print(s.getDisplaySymbol());
			}
			System.out.println("");
		}
	}
	
	//convert A1 into [0,0]
		//A2 = [0,1]
		
	public Square returnSquare(String squareID)
	{
		int letter = squareID.charAt(0) - 'A';
		int num = '8'-squareID.charAt(1);
		return board[num][letter];
		
	}
	
	
	

}
