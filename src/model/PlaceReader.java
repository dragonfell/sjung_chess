package model;

import model.Piece.TeamColor;

public class PlaceReader 
{
	public static Piece returnPiece(String pieceString, String colorString)
	{
		TeamColor color = (colorString.equals("L")) ? TeamColor.WHITE : TeamColor.BLACK;
		
		Piece newPiece = null;
		switch(pieceString)
		{
			case "K":
				newPiece = new King(color);
				break;
			case "Q":
				newPiece = new Queen(color);
				break;
			case "B":
				newPiece = new Bishop(color);
				break;
			case "N":
				newPiece = new Knight(color);
				break;
			case "P":
				newPiece = new Pawn(color);
				break;
			case "R":
				newPiece = new Rook(color);
				break;
		}
		return newPiece;
		
	}

}
