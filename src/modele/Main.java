package modele;
import java.*;
import modele.Config.*;

public class Main {

	public static void main(String[] args) {

		BoardAbalone board = new BoardAbalone();
		BoardDC board_dc = new BoardDC();

		/*board.displayBoard();
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

		board.printTabPieces();*/
		
		/*
		System.out.println(board.AvailableMoves(Color.BLACK));
		System.out.println(board.AvailableMoves(Color.BLACK).length());
		int i=200;
		Color player=Color.BLACK;
		while(i-->0) {
			AlphaBeta a = new AlphaBeta(board);
			//System.out.println(a.MoveOrdering(board.AvailableMoves(player)));
			String move=a.alphaBeta(4, 4, Integer.MIN_VALUE, Integer.MAX_VALUE, "",
					player, player);
			System.out.println(move+" "+player);
			board.executeMove(board.stringToMove(move.substring(0,16)),player);
			board.displayBoard();
			player=board.switchPlayer(player);
			if(a.marble_count(player)<=8 || a.marble_count(board.switchPlayer(player))<=8)
			{
				System.out.println("============Victory at "+i+" =============");
				break;
			}
		}*/
		board_dc.initBoard();
		board_dc.affichePlateau();
		Coords m1 = new Coords(14, 10);
		if(board_dc.selectMarble(m1))
			System.out.println("ok");
		board_dc.printTabPieces();
		
		if(board_dc.move(Direction.UPLEFT)){
			System.out.println("mouvement ok");
		}
			
		board_dc.affichePlateau();
	}
}