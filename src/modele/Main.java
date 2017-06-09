package modele;
import java.*;
import modele.Config.Direction;

public class Main {

	public static void main(String[] args) {

		Board board = new Board();
		board.displayBoard();
		board.printTabPieces();

		Coords piece = new Coords(1,5);
		Coords piece2 = new Coords(2,8);
		Coords piece3 = new Coords(2,6);
		System.out.println("position : ");
		//board.printPosition(piece);		

		if(board.selectPiece(piece))
			System.out.println("Pion selectionne");
		else
			System.out.println("Impossible de selectionner le pion");
		
		board.selectPiece(piece2);
		board.selectPiece(piece3);

		board.printTabPieces();
	}
}