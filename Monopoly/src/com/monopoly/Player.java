package com.monopoly;

import java.util.List;

import com.dicegame.Die;

public class Player {
	private Square square;
	private String token;
	
	public static final String[] TOKENS = {"Dog", "WheelBarrow", "Hat", "Thimble",
								"Battleship", "Race Car", "Boot", "Iron"};
	
	public Player(Square square, int tokenIndex) {
		this.square = square;
		token = TOKENS[tokenIndex];
	}

	public Square getSquare() {
		return square;
	}

	public String getToken() {
		return token;		
	}

	public void takeTurn(List<Die> dice) {
		int dieCount1 = dice.get(0).roll();
		int dieCount2 = dice.get(1).roll();
		
		int moveCount = dieCount1 + dieCount2;
		
		movePlayer(moveCount);	
	}

	private void movePlayer(int moveCount) {
		for(int i = 0; i < moveCount; i++) {
			setSquare(getSquare().getNextSquare());
		}
		
	}

	private void setSquare(Square square) {
		this.square = square;		
	}

}
