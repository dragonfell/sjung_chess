package model;

public class testing 
{
	public static void main(String[] args)
	{
		Board board = new Board();
		String s = board.returnSquare("A1").getSquareID();
		board.returnSquare("A1").setDisplaySymbol("m");
		board.returnSquare("A2").setDisplaySymbol("n");
		board.returnSquare("B2").setDisplaySymbol("a");
		board.display();
		System.out.println(s);
		
		
	}

}
