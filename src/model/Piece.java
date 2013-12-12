package model;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Piece 
{
	protected String displaySymbol;
	protected TeamColor teamColor;
	protected ArrayList<String> possibleMoves= new ArrayList<String>();
	protected int twoSquares = 2;
	protected int oneSquare = 1;
	protected int squaresMoved = 0;
	//protected HashMap<String, Square> possibleMoves = new HashMap<String, Square>();

	public String getDisplaySymbol()
	{
		return displaySymbol;
		
	}
	
	public enum TeamColor
	{
		WHITE,
		BLACK
	}
	
	public abstract ArrayList<String> getPossibleMoves(Square currentSquare, Board board);
	
	public boolean isValidMove(String secondSquareID)
	{
		boolean isValidMove = false;
		if(possibleMoves.contains(secondSquareID))
			isValidMove = true;
		return isValidMove;
		
	}
	
	public TeamColor getTeamColor()
	{
		return this.teamColor;
	}
	
	public void incrementSquaresMoved()
	{
		this.squaresMoved += 1;
	}
	
	public boolean addPossibleMoves(Square destinationSquare, Board board)
	{
		boolean pieceFound = false;
		if(destinationSquare.getPiece() == null)
		{
			possibleMoves.add(destinationSquare.getSquareID());
		}
		else if(this.teamColor != destinationSquare.getPiece().getTeamColor())
		{
			possibleMoves.add(destinationSquare.getSquareID());
			pieceFound = true;
		}
		return pieceFound;
		
		
		
	}

}
