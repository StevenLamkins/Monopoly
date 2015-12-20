package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Square> squares;
	SquareDao dao;

	public Board() {
		dao = new FakeSquareDao();
		buildSquares();
		linkSquares();
	}
	
	public Board(SquareDao dao) {
		this.dao = dao;
		buildSquares();
		linkSquares();
	}

	private void linkSquares() {
		int lastElement = squares.size() -1;
		squares.get(lastElement).setNextSquare(squares.get(0));
		
		for (int i = 0; i < lastElement; i++) {
			squares.get(i).setNextSquare(squares.get(i+1));
		}
	}
 
	private void buildSquares() {
		
		squares = new ArrayList<Square>();

		for (int position = 0; position < 40; position++) {			
			Square square = dao.getSquareByPosition(position);
			if(square != null){
				squares.add(square);
			}
		}		
	}

	public List<Square> getSquares() {
		return this.squares;
	}

	public Square getStartSquare() {		
		return squares.get(0);
	}

}
