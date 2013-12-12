package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import view.Display;

import model.Piece.TeamColor;

public class Game 
{
	private FileReader input;
	private File moveFile;
	private File setupFile;
	private BufferedReader setupbuffer;
	private BufferedReader movebuffer;
	private Board board;
	private TeamColor currentTurnColor;
	public Game()
	{
		board = new Board();
		
		//Player player1 = new Player("Player 1", TeamColor.WHITE);
		//Player player2 = new Player("Player 2", TeamColor.BLACK);
		
	}
	
	public void startGame()
	{
		
		setupBoard();
		Display.display(board);
		
		moveFile = new File("testing.txt");
		try {
			input = new FileReader(moveFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		movebuffer = new BufferedReader(input);
		
		//For the sake of convention: The white player moves first
		currentTurnColor = TeamColor.WHITE;
		System.out.println("It is now " + currentTurnColor + "'s turn.");
		String temp;
		try{
			while((temp = movebuffer.readLine()) != null)
			{
				System.out.println("Command: " + temp);
				if(MoveReader.isValidMove(temp.toUpperCase(), board, currentTurnColor))
				{
					MoveReader.interpretCommand(temp.toUpperCase(), board);
					switchPlayerTurn();
					
					
				}
				else
				{
					System.out.println("Not a valid move!");
				}
				System.out.println("It is now " + currentTurnColor + "'s turn.");
				Display.display(board);	
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		//MoveReader.convertFileToList("testing.txt");
	}
	
	public void switchPlayerTurn()
	{
		//switches the color of current turn
		currentTurnColor = (currentTurnColor == TeamColor.WHITE)? TeamColor.BLACK : TeamColor.WHITE;
	}
	
	public void setupBoard()
	{
		setupFile("setup.txt");
		String temp;
		try{
			while((temp = setupbuffer.readLine()) != null)
			{				
				MoveReader.interpretCommand(temp.toUpperCase(), board);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void setupFile(String fileName)
	{
		setupFile = new File(fileName);
		try {
			input = new FileReader(setupFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setupbuffer = new BufferedReader(input);
	}

}
