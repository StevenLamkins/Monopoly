package com.monopoly;

import com.dicegame.Die;

public class LoadedDie extends Die{
	int loadedValue;
	
	public LoadedDie(int value) {
		super(6);
		loadedValue = value;
	}
	

	@Override
	public int roll() {

		return loadedValue;	
	}

}
