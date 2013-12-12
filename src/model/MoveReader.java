package model;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

import model.Piece.TeamColor;



public class MoveReader 
{
	static FileReader input = null;
	private final static String PLACEMENT_STRING = "(?<piece>[KQBRNPkqbrnp])(?<color>[DLdl])(?<column>[A-Ha-h])(?<row>[1-8])";
	private final static String MOVEMENT_STRING = "(?<column1>[A-Ha-h])(?<row1>[1-8])[ ](?<column2>[A-Ha-h])(?<row2>[1-8])";
	private final static String CAPTURE_STRING = "(?<column1>[A-Ha-h])(?<row1>[1-8])[ ](?<column2>[A-Ha-h])(?<row2>[1-8])[*]";
	private final static String CASTLE_STRING = "(?<p1column1>[A-Ha-h])(?<p1row1>[1-8])[ ](?<p1column2>[A-Ha-h])(?<p1row2>[1-8])[ ](?<p2column1>[A-Ha-h])(?<p2row1>[1-8])[ ](?<p2column2>[A-Ha-h])(?<p2row2>[1-8])";
	
	private static StringPattern placementPattern = new StringPattern(PLACEMENT_STRING, CommandType.PLACEMENT);
	private static StringPattern movementPattern = new StringPattern(MOVEMENT_STRING, CommandType.MOVEMENT);
	private static StringPattern capturePattern = new StringPattern(CAPTURE_STRING, CommandType.CAPTURE);
	private static StringPattern castlePattern = new StringPattern(CASTLE_STRING, CommandType.CASTLING);
	
	static CommandType[] commandTypes = {CommandType.PLACEMENT, CommandType.MOVEMENT, CommandType.CAPTURE, CommandType.CASTLING,
		CommandType.INVALID};
	
	static StringPattern[] stringPatterns = {placementPattern, movementPattern, capturePattern, castlePattern};
	
	private static CommandType returnCommandType(String commandString)
	{
		CommandType type = CommandType.INVALID;
		for(int i = 0; i < stringPatterns.length && type == CommandType.INVALID; i++)
		{
			if(Pattern.matches(stringPatterns[i].getString(), commandString))
			{
				type = stringPatterns[i].getCommandType();
			}
		}
		return type;
	}
	
	public static boolean isValidMove(String commandString, Board board, TeamColor currentPlayerColor)
	{
		boolean isValidMove = true;
		//
		//System.out.println(commandString);
		Matcher m = movementPattern.getMatcher(commandString);
		m.find();
		Square tempSquare = board.returnSquare(m.group("column1") + m.group("row1"));
		Square secondSquare = board.returnSquare(m.group("column2") + m.group("row2"));
		Piece tempPiece = tempSquare.getPiece();
		if(tempPiece != null)
		{
			
			boolean isCurrentColor = tempPiece.getTeamColor() == currentPlayerColor ? true : false;
			isValidMove = tempPiece.getPossibleMoves(tempSquare,board).contains(secondSquare.getSquareID()) && isCurrentColor ? true : false;
			String error = isCurrentColor ? "" : "Not " + currentPlayerColor + "'s turn";
			
			System.out.println(error);
			
			/*
			if(tempPiece.getTeamColor() != currentPlayerColor)
			{
				System.out.println("Not your turn!");
				isValidMove = false;
			}
			else
			{	
				isValidMove = tempPiece.getPossibleMoves(tempSquare,board).contains(secondSquare.getSquareID()) ? true : false;
			}*/
		}
		else
		{
			//no piece
			System.out.println("No piece to move");
			isValidMove = false;
			
		}
		return isValidMove;
	}
	
	public static void interpretCommand(String commandString, Board board)
	{
		Matcher m = null;
		for(StringPattern sp : stringPatterns)
		{
			if(sp.getCommandType() == returnCommandType(commandString))
			{
				m = sp.getMatcher(commandString);
				m.find();
			}
		}
		
		switch(returnCommandType(commandString))
		{
		case PLACEMENT:
			Piece p = PlaceReader.returnPiece(m.group("piece"), m.group("color"));
			board.returnSquare(m.group("column") + m.group("row")).setPiece(p);
			//executePlacement(commandString, board, m);
			break;
		case MOVEMENT:
			Square tempSquare = board.returnSquare(m.group("column1") + m.group("row1"));
			if(tempSquare.getPiece() != null)
			{
				//tempSquare.getPiece().setPossibleMoves(tempSquare, board);
				if(tempSquare.getPiece().getPossibleMoves(tempSquare, board).contains(board.returnSquare(m.group("column2") + m.group("row2")).getSquareID()))
				{
					tempSquare.getPiece().incrementSquaresMoved();
					//if it's in the list of possibl moves
					Piece tempPiece = tempSquare.getPiece();
					board.returnSquare(m.group("column1") + m.group("row1")).clearPiece();
					board.returnSquare(m.group("column2") + m.group("row2")).setPiece(tempPiece);
					
					System.out.println("Moved " + tempPiece.getDisplaySymbol() + " from " + 
							board.returnSquare(m.group("column1") + m.group("row1")).getSquareID() + " to " +
							board.returnSquare(m.group("column2") + m.group("row2")).getSquareID() + ".");
					
				}
				//else
					//System.out.println(commandString + " is not a valid move.");
			}
			else
				System.out.println("No piece to move!");
			/*
			if(!board.returnSquare(m.group("column1") + m.group("row1")).isEmpty())
			{
				symbol1 = board.returnSquare(m.group("column1") + m.group("row1")).takeSymbol().trim();
				board.returnSquare(m.group("column2") + m.group("row2")).setDisplaySymbol(symbol1);
			}
			else
				System.out.println("nothing to move");*/
			break;
			/*
		case CASTLING:
			symbol1 = board.returnSquare(m.group("p1column1") + m.group("p1row1")).takeSymbol().trim();
			board.returnSquare(m.group("p1column2") + m.group("p1row2")).setDisplaySymbol(symbol1);
			symbol2 = board.returnSquare(m.group("p2column1") + m.group("p2row1")).takeSymbol().trim();
			board.returnSquare(m.group("p2column2") + m.group("p2row2")).setDisplaySymbol(symbol2);
		
			break;*/
		case INVALID:
			break;
		}
	}
	
	public static void executePlacement(String placeCommandString, Board board, Matcher m)
	{
		Piece p = PlaceReader.returnPiece(m.group("piece"), m.group("color"));
		board.returnSquare(m.group("column") + m.group("row")).setPiece(p);
	}
	
	public enum ChessPiece
	{
		KING,
		QUEEN,
		BISHOP,
		KNIGHT,
		ROOK,
		PAWN
	}
	
	private static String returnPieceName(char pieceSymbol, char colorSymbol)
	{
		String colorName = "Blank";
		String pieceName = "Piece";

		switch(pieceSymbol)
		{
		case 'K':
			pieceName = "King";
			break;
		case 'Q':
			pieceName = "Queen";
			break;
		case 'B':
			pieceName = "Bishop";
			break;
		case 'N':
			pieceName = "Knight";
			break;
		case 'R':
			pieceName = "Rook";
			break;
		case 'P':
			pieceName = "Pawn";
			break;
		}
		switch(colorSymbol)
		{
		case 'L':
			colorName = "white";
			break;
		case 'D':
			colorName = "black";
			break;
		}
		
		return colorName + " " + pieceName;
	}
	
	
	
	
	

}
