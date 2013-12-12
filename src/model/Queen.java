package model;

import java.util.ArrayList;

public class Queen extends Piece
{
	public Queen(TeamColor teamColor)
	{
		this.teamColor = teamColor;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "q" : "Q";
	}

	@Override
	public ArrayList<String> getPossibleMoves(Square currentSquare, Board board) {
		// TODO Auto-generated method stub
		possibleMoves.clear();
		Square tempSquare;
		//rook moves
		boolean pieceFound = false;
		for(int i = 1; currentSquare.convertRowIndex()+i <= board.getBoardLength()-1 && !pieceFound; i++)
		{	
			tempSquare = board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex());
			pieceFound = this.addPossibleMoves(tempSquare, board);
			
			/*
			tempSquare = board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex());
			if(tempSquare.getPiece() == null)
			{
				possibleMoves.add(tempSquare.getSquareID());		
			}
			else
			{
				if(this.teamColor != tempSquare.getPiece().getTeamColor())
				{
					possibleMoves.add(tempSquare.getSquareID());	
				}
				pieceFound = true;
			}*/
		}
		
		pieceFound = false;
		for(int i = 1; currentSquare.convertColumnIndex()+i <= board.getBoardLength()-1 && !pieceFound; i++)
		{
			//straight down	
			tempSquare = board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+i);
			if(tempSquare.getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+i).getSquareID());	
		
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+i).getPiece().getTeamColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+i).getSquareID());	
				}
				pieceFound = true;
			}
		}
		
		pieceFound = false;
		for(int i = 1; currentSquare.convertColumnIndex()-i >= 0 && !pieceFound; i++)
		{
			//straight down	
			if(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-i).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-i).getSquareID());	
		
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-i).getPiece().getTeamColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-i).getSquareID());	
				}
				pieceFound = true;
			}
		}
		
		pieceFound = false;
		for(int i = 1; currentSquare.convertRowIndex()-i >= 0 && !pieceFound; i++)
		{
			//straight down	
			if(board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()).getSquareID());	
		
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()).getPiece().getTeamColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()).getSquareID());	
				}
				pieceFound = true;
			}
		}
		//bishop moves
		
		pieceFound = false;
		
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
