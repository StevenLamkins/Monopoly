package com.monopoly;

public class LuxeryTaxSquare extends Square {

	public LuxeryTaxSquare(String name) {
		super(name);

	}

	@Override
	public void landOn(Player player) {
		player.incrementAccount(-75);

	}

	@Override
	public void passOver(Player player) {
		// TODO Auto-generated method stub
		
	}

}
