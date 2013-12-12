package model;

import java.util.ArrayList;

public class Pawn extends Piece
{
	
	public Pawn(TeamColor teamColor)
	{
		this.teamColor = teamColor;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE)? "p" : "P"; 
	}

	@Override
	public ArrayList<String> getPossibleMoves(Square currentSquare, Board board) {
		// TODO Auto-generated method stub
		
		possibleMoves.clear();
		
		int oneSquare = 0;
		switch(this.teamColor)
		{
		case WHITE:
			oneSquare = -1;
			break;
		case BLACK:
			oneSquare = 1;
			break;
		}
		
		if(currentSquare.convertRowIndex() + oneSquare <= board.getBoardLength()-1 && currentSquare.convertRowIndex() + oneSquare > 0)
		{
			Square tempSquare = board.returnSquareAt(currentSquare.convertRowIndex() + oneSquare, currentSquare.convertColumnIndex());
			if(tempSquare.getPiece() == null)
			{
				possibleMoves.add(tempSquare.getSquareID());
			}
		}
		
		if(currentSquare.convertRowIndex() + (oneSquare*2) <= board.getBoardLength()-1 && currentSquare.convertRowIndex() + (oneSquare*2) > 0)
		{
			Square tempSquare2 = board.returnSquareAt(currentSquare.convertRowIndex() + (oneSquare*2), currentSquare.convertColumnIndex());
			if(this.squaresMoved == 0)
			{
				possibleMoves.add(tempSquare2.getSquareID());
				
			}
		}
		
		
		
		//System.out.println(board.returnSquareAt(currentSquare.convertRowIndex() + oneSquare, currentSquare.convertColumnIndex()).getSquareID());
		//possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex() + oneSquare, currentSquare.convertColumnIndex()).getSquareID());
		
		
		return possibleMoves;
	}

}
