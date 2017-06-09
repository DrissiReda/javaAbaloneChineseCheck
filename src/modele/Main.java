package modele;
import java.*;

import modele.Config.Color;
import modele.Config.Direction;

public class Main {

	public static void main(String[] args) {

		Board board = new Board();
		board.displayBoard();
		board.printTabPieces();

		Coords piece = new Coords(3,7);
		Coords piece2 = new Coords(3,9);
		Coords piece3 = new Coords(8,8);
		System.out.println("position : ");
		//board.printPosition(piece);		

		if(board.selectPiece(piece2))
			System.out.println("Pion sélectionné");
		else
			System.out.println("Impossible de sélectionner le pion");
		
		board.selectPiece(piece3);
		board.selectPiece(piece);

		board.printTabPieces();		
		
	}
}
