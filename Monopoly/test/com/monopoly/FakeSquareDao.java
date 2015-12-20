package com.monopoly;


public class FakeSquareDao implements SquareDao{

	public Square getSquareByPosition(int position) {
		return buildSquare(position);
	}
	
	private Square buildSquare(int squarePosition) {
		Square square = null;
		switch (squarePosition) {
		case 0:
			square = new GoSquare("Go");
			break;
		case 1: case 3:	case 6: case 8: case 9: case 11: case 13: case 14:
		case 16: case 18: case 19: case 21: case 23: case 24: case 26: case 27:
		case 29: case 31: case 32: case 34: case 37: case 39:
			square = new LotSquare("Lot Square " + squarePosition, squarePosition,  (squarePosition+1)*10, Group.Cyan);
			break;
		case 4:
			square = new IncomeTax("Square " + squarePosition);
			break;
		case 5: case 15: case 25: case 359:
			square = new RailRoadSquare("RailRoad Square " + squarePosition, 25,  200, Group.Railroad);
			break;
		case 28: case 12:
			square = new UtilitySquare("Utility Square " + squarePosition, squarePosition, (squarePosition+1)*10, Group.Utility);
			break;
		case 38:
			square = new LuxeryTaxSquare("Luxury Tax " + (squarePosition));
			break;				

		default:
			square = new BlankSquare("Square " + squarePosition);
			break;
		}
		return square;
	}

}
