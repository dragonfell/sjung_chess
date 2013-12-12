package model;

import java.util.ArrayList;
import java.util.HashMap;

public class King extends Piece
{
	public King(TeamColor teamColor)
	{
		this.teamColor = teamColor;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "k" : "K";
	}
	
	public ArrayList<String> getPossibleMoves(Square currentSquare, Board board)
	{
		possibleMoves.clear();
		
		if(currentSquare.convertRowIndex()+1 <= board.getBoardLength()-1)
		{
			if(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()).getSquareID());
			}
			else if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()).getPiece().getTeamColor())
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()).getSquareID());
			}
			
			if(currentSquare.convertColumnIndex() + 1 <= board.getBoardLength()-1)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+1).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+1).getSquareID());
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+1).getPiece().getTeamColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+1).getSquareID());
					}
				}
			}
			if(currentSquare.convertColumnIndex() - 1 >= 0)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-1).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-1).getSquareID());
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-1).getPiece().getTeamColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-1).getSquareID());
					}
				}
			}
		}
		
		if(currentSquare.convertRowIndex()-1 >= 0)
		{
			if(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()).getSquareID());
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()).getPiece().getTeamColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()).getSquareID());
				}
			}
			
			if(currentSquare.convertColumnIndex()+1 <= board.getBoardLength()-1)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+1).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+1).getSquareID());
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+1).getPiece().getTeamColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+1).getSquareID());
					}
				}
			}
		}
		
		
		if(currentSquare.convertColumnIndex() + 1 <= board.getBoardLength()-1)
		{
			if(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+1).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+1).getSquareID());
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+1).getPiece().getTeamColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+1).getSquareID());
				}
			}
			
		}
		
		if(currentSquare.convertColumnIndex() - 1 >= 0)
		{
			if(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-1).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-1).getSquareID());
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-1).getPiece().getTeamColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-1).getSquareID());
				}
			}
			
			if(currentSquare.convertRowIndex() -1 >= 0)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-1).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-1).getSquareID());
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-1).getPiece().getTeamColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-1).getSquareID());
					}
				}
			}
				
		}
		
		return this.possibleMoves;
	}
	
	public ArrayList<String> getPossibleMoves()
	{
		return possibleMoves;
	}

}
