package modele;
import java.*;
import modele.Config.*;

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
		System.out.println(board.AvailableMoves(Color.BLACK));
		//AlphaBeta a=new AlphaBeta(board);
		//System.out.println(a.alphaBeta(2,2,Integer.MIN_VALUE,Integer.MAX_VALUE,"",
		//		Color.WHITE,Color.WHITE));
	}
}
