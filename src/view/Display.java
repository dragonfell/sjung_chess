package view;

import model.Board;
import model.Square;

public class Display 
{
	public static void display(Board board)
	{
		//for each square in board, display the displaysymbol
			int u = board.getBoardLength();
			System.out.println("  A  B  C  D  E  F  G  H");
			for(int i = 0; i < board.getBoardLength(); i++)
			{
				System.out.print(u--);
				for(Square s : board.returnBoardRow(i))
				{
					System.out.print(s.getDisplaySymbol());
				}
				System.out.println("");
			}
	}

}
