package model;

import java.util.ArrayList;

public class Knight extends Piece
{
	public Knight(TeamColor teamColor)
	{
		this.teamColor = teamColor;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "n" : "N";
	}

	@Override
	public ArrayList<String> getPossibleMoves(Square currentSquare, Board board) 
	{
		possibleMoves.clear();

		
		if(currentSquare.convertRowIndex()+twoSquares <= board.getBoardLength()-oneSquare)
		{
			if(currentSquare.convertColumnIndex()+twoSquares <= board.getBoardLength()-oneSquare)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()+twoSquares, currentSquare.convertColumnIndex()+oneSquare).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+twoSquares, currentSquare.convertColumnIndex()+oneSquare).getSquareID());
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+twoSquares, currentSquare.convertColumnIndex()+oneSquare).getPiece().getTeamColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+twoSquares, currentSquare.convertColumnIndex()+oneSquare).getSquareID());
					}
				}
			}
			if(currentSquare.convertColumnIndex()-oneSquare > 0)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()+twoSquares, currentSquare.convertColumnIndex()-oneSquare).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+twoSquares, currentSquare.convertColumnIndex()-oneSquare).getSquareID());
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+twoSquares, currentSquare.convertColumnIndex()-oneSquare).getPiece().getTeamColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+twoSquares, currentSquare.convertColumnIndex()-oneSquare).getSquareID());
					}
				}
				
			}
		}
		
		if(currentSquare.convertRowIndex()+oneSquare <= board.getBoardLength()-oneSquare)
		{
			if(currentSquare.convertColumnIndex()-twoSquares > 0)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()+oneSquare, currentSquare.convertColumnIndex()-twoSquares).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+oneSquare, currentSquare.convertColumnIndex()-twoSquares).getSquareID());
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+oneSquare, currentSquare.convertColumnIndex()-twoSquares).getPiece().getTeamColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+oneSquare, currentSquare.convertColumnIndex()-twoSquares).getSquareID());
					}
				}
			}
			if(currentSquare.convertColumnIndex()+twoSquares <= board.getBoardLength()-oneSquare)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()+oneSquare, currentSquare.convertColumnIndex()+twoSquares).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+oneSquare, currentSquare.convertColumnIndex()+twoSquares).getSquareID());
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+oneSquare, currentSquare.convertColumnIndex()+twoSquares).getPiece().getTeamColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+oneSquare, currentSquare.convertColumnIndex()+twoSquares).getSquareID());
					}
				}
				
			}
		}
		
		if(currentSquare.convertRowIndex()-twoSquares > 0)
		{
			if(currentSquare.convertColumnIndex()+oneSquare <= board.getBoardLength()-oneSquare)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()-twoSquares, currentSquare.convertColumnIndex()+oneSquare).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-twoSquares, currentSquare.convertColumnIndex()+oneSquare).getSquareID());
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-twoSquares, currentSquare.convertColumnIndex()+oneSquare).getPiece().getTeamColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-twoSquares, currentSquare.convertColumnIndex()+oneSquare).getSquareID());
					}
				}
				
			}
			if(currentSquare.convertColumnIndex()-oneSquare > 0)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()-twoSquares, currentSquare.convertColumnIndex()-oneSquare).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-twoSquares, currentSquare.convertColumnIndex()-oneSquare).getSquareID());
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-twoSquares, currentSquare.convertColumnIndex()-oneSquare).getPiece().getTeamColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-twoSquares, currentSquare.convertColumnIndex()-oneSquare).getSquareID());
					}
				}
			}
		}
		
		if(currentSquare.convertRowIndex()-oneSquare > 0)
		{
			if(currentSquare.convertColumnIndex()+twoSquares <= board.getBoardLength()-oneSquare)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()-oneSquare, currentSquare.convertColumnIndex()+twoSquares).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-oneSquare, currentSquare.convertColumnIndex()+twoSquares).getSquareID());
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-oneSquare, currentSquare.convertColumnIndex()+twoSquares).getPiece().getTeamColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-oneSquare, currentSquare.convertColumnIndex()+twoSquares).getSquareID());
					}
				}

			}
			if(currentSquare.convertColumnIndex()-twoSquares > 0)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()-oneSquare, currentSquare.convertColumnIndex()-twoSquares).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-oneSquare, currentSquare.convertColumnIndex()-twoSquares).getSquareID());
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-oneSquare, currentSquare.convertColumnIndex()-twoSquares).getPiece().getTeamColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-oneSquare, currentSquare.convertColumnIndex()-twoSquares).getSquareID());
					}
				}

			}
		}

		return this.possibleMoves;
	
	}
}
