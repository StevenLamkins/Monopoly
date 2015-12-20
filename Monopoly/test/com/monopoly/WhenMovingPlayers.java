package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dicegame.Die;

public class WhenMovingPlayers {

	@Test
	public void playersShouldLeaveGoSquare() {
		MonopolyGame game = new MonopolyGame();

		
		for (Token token : Token.values()) {
			game.addPlayer(token);
		}
		
		List<PlayerInfo> players = game.getPlayers();
		game.playRound();
		
		for (PlayerInfo player : players) {
			assertFalse(player.getSquare().getName().equals("Go"));
		} 
	}
	
	@Test
	public void playerShouldMoveCorrectAmountOfSquares() {
		Board board = new Board();
		Player player = new Player(board.getStartSquare(), Token.BattleShip);
		List<Die> dice = new ArrayList<Die>();
		int dieValue1 = 3;
		int dieValue2 = 4;
		dice.add(new LoadedDie(dieValue1));
		dice.add(new LoadedDie(dieValue2));

		player.takeTurn(dice);
		
		Square expectedSquare = board.getSquares().get(7);
		assertEquals(player.getSquare(), expectedSquare);
	

	}
	
	@Test
	public void playerShouldCircleTheBoard() {
		Board board = new Board();
		
		List<Square> squares = board.getSquares();
		Player player = new Player(squares.get(38), Token.BattleShip);

		List<Die> dice = new ArrayList<Die>();
		int dieValue1 = 3;
		int dieValue2 = 4;
		dice.add(new LoadedDie(dieValue1));
		dice.add(new LoadedDie(dieValue2));

		player.takeTurn(dice);
	
		
		assertEquals(player.getSquare().getName(), "RailRoad Square 5");		

	}

}
