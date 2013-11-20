import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;


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
	
	static Board board = new Board();
	
	public static void main(String[] args)
	{
		convertFileToList(args[0]);
		board.displayBoard();
	}
	
	public static void convertFileToList(String fileName)
	{
		File file = new File(fileName);
		
		try {
			input = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader buffer = new BufferedReader(input);
		
		String temp;
		try {
			while((temp = buffer.readLine()) != null)
			{
				interpretCommand(temp.toUpperCase());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static CommandType returnCommandType(String commandString)
	{
		CommandType type = null;
		for(StringPattern sp : stringPatterns)
		{
			if(Pattern.matches(sp.getString(), commandString))
			{
				return sp.getCommandType();
			}
			else
				type = CommandType.INVALID;
		}
		return type;
	}
	
	private static void interpretCommand(String commandString)
	{
		Matcher m = null;
		String symbol1 = null;
		String symbol2 = null;
		
		boolean isInterpreted = false;
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
			String pieceSymbol = (m.group("color").equals("D")) ? m.group("piece").toUpperCase() : m.group("piece").toLowerCase();
			board.returnSquare(m.group("column") + m.group("row")).setDisplaySymbol(pieceSymbol);
			break;
		case MOVEMENT:
			if(!board.returnSquare(m.group("column1") + m.group("row1")).isEmpty())
			{
				symbol1 = board.returnSquare(m.group("column1") + m.group("row1")).takeSymbol().trim();
				board.returnSquare(m.group("column2") + m.group("row2")).setDisplaySymbol(symbol1);
			}
			else
				System.out.println("nothing to move");
			break;
		case CAPTURE:
			if(!board.returnSquare(m.group("column2") + m.group("row2")).isEmpty())
			{
				symbol1 = board.returnSquare(m.group("column1") + m.group("row1")).takeSymbol().trim();
				board.returnSquare(m.group("column2") + m.group("row2")).setDisplaySymbol(symbol1);
			}
			else
				System.out.println("nothing to move");
			
			break;
		case CASTLING:
			symbol1 = board.returnSquare(m.group("p1column1") + m.group("p1row1")).takeSymbol().trim();
			board.returnSquare(m.group("p1column2") + m.group("p1row2")).setDisplaySymbol(symbol1);
			symbol2 = board.returnSquare(m.group("p2column1") + m.group("p2row1")).takeSymbol().trim();
			board.returnSquare(m.group("p2column2") + m.group("p2row2")).setDisplaySymbol(symbol2);
		
			break;
		case INVALID:
			break;
		}
		//return c;
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
