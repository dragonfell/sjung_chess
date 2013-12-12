package model;

import java.util.ArrayList;

public class Bishop extends Piece
{
	public Bishop(TeamColor teamColor)
	{
		this.teamColor = teamColor;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "b" : "B";
	}

	@Override
	public ArrayList<String> getPossibleMoves(Square currentSquare, Board board) 
	{
		possibleMoves.clear();
		boolean pieceFound = false;
		
		for(int i = 1; currentSquare.convertRowIndex()+i <= board.getBoardLength()-1 && currentSquare.convertColumnIndex()+i <= board.getBoardLength()-1 && !pieceFound; i++)
		{
			//straight down	
			if(board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()+i).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()+i).getSquareID());	
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()+i).getPiece().getTeamColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()+i).getSquareID());	
				}
				pieceFound = true;
			}
		}
		
		pieceFound = false;
		for(int i = 1; currentSquare.convertRowIndex()-i >= 0 && currentSquare.convertColumnIndex()+i <= board.getBoardLength()-1 && !pieceFound; i++)
		{
			//straight down	
			if(board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()+i).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()+i).getSquareID());	
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()+i).getPiece().getTeamColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()+i).getSquareID());	
				}
				pieceFound = true;
			}
		}
		
		pieceFound = false;
		for(int i = 1; currentSquare.convertRowIndex()-i >= 0 && currentSquare.convertColumnIndex()-i >= 0 && !pieceFound; i++)
		{
			//straight down	
			if(board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()-i).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()-i).getSquareID());	
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()-i).getPiece().getTeamColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()-i).getSquareID());	
				}
				pieceFound = true;
			}
		}
		
		pieceFound = false;
		for(int i = 1; currentSquare.convertRowIndex()+i <= board.getBoardLength()-1 && currentSquare.convertColumnIndex()-i >= 0 && !pieceFound; i++)
		{
			//straight down	
			if(board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()-i).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()-i).getSquareID());	
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()-i).getPiece().getTeamColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()-i).getSquareID());	
				}
				pieceFound = true;
			}
		}
		return this.possibleMoves;
	}
	
}
