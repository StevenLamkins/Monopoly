package com.monopoly.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import com.monopoly.FakeSquareDao;
import com.monopoly.Square;

public class whenConnectingToSquareDAO {

	@Test
	public void shouldSelectSquareByPosition() {
		//RealSquareDao dao = new RealSquareDao();
		FakeSquareDao dao = new FakeSquareDao();
		Square square = dao.getSquareByPosition(39);
		assertEquals("Lot Square 39", square.getName());		
	}

}
