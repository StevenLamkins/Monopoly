package com.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.dicegame.Die;

public class MonopolyGame {

	public static final int MAX_NUM_PLAYERS = 8;
	public static final int MIN_NUM_PLAYERS = 2;
	private Board board;
	private List<Player> playerList;
	private List<Die> dice;

	public MonopolyGame() {
		
		//this(new FakeSquareDao());
		
		dice = new ArrayList<Die>();
		dice.add(new Die());
		dice.add(new Die());
		board = new Board();
		playerList = new ArrayList<Player>();
	}

	public void start() {
		if (getNumberPlayers() > MAX_NUM_PLAYERS) {
			throw new IllegalArgumentException("Too Many Players");
		} else if (getNumberPlayers() < MIN_NUM_PLAYERS) {
			throw new IllegalArgumentException("Too Few Players");
		}
	}

	public List<Square> getSquares() {
		return board.getSquares();
	}

	public int getNumberPlayers() {
		return playerList.size();
	}

	public List<PlayerInfo> getPlayers() {
		return new ArrayList<PlayerInfo>(playerList);
		//return playerList;
	}

	public void addPlayer(Token token) {

		List<Token> tokens = new ArrayList<Token>();
		for (PlayerInfo player : playerList) {
			tokens.add(player.getToken());
		}
		if (tokens.contains(token))
		{
			throw new IllegalArgumentException("This Token Already Inuse");
		}
		playerList.add(new Player(board.getStartSquare(), token));


	}

	public void playRound() {
		for (Player player : playerList) {
			player.takeTurn(dice);
		}
	}
}
