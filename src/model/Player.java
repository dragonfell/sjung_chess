package model;

import model.Piece.TeamColor;

public class Player 
{
	//"Team" is made up of that player's pieces
	private Team team = new Team();
	private String name = null;
	private TeamColor teamColor = null;
	
	public Player()
	{
		
	}
	
	public Player(String playerName, TeamColor color) {
		this.name = playerName;
		this.teamColor = color;
	}

	public void movePiece(String initialSquare, Square endSquare)
	{
		//can check if the piece on initialSquare is part of Player's team
	}

}
