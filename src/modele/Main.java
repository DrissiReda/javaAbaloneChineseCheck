package modele;

import java.*;
import java.util.concurrent.TimeUnit;

import modele.Config.*;
import vue.*;

public class Main {

	public static void main(String[] args) {

		BoardAbalone board = new BoardAbalone();
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
		System.out.println(board.AvailableMoves(Color.BLACK));
		System.out.println(board.AvailableMoves(Color.BLACK).length());
		System.out.println(board.getCase(new Coords(7,7)));
		switch(board.getCase(new Coords(7,7))){
			case EMPTY : System.out.print("0");
			default : System.out.println("1");
		}


		Fenetre fen = new Fenetre(); // adri





		int i=200;
		Color player=Color.BLACK;
		while(i-->0) {

			//delay adri
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


			AlphaBeta a = new AlphaBeta(board);
			//System.out.println(a.MoveOrdering(board.AvailableMoves(player)));
			String move=a.alphaBeta(3, 3, Integer.MIN_VALUE, Integer.MAX_VALUE, "",
					player, player);
			System.out.println(move+" "+player);
			board.executeMove(board.stringToMove(move.substring(0,board.moveSize)),player);
			board.displayBoard();

			fen.setMarbleLeftBlack(board.marble_count(Color.BLACK)); // adri
			fen.setMarbleLeftWhite(board.marble_count(Color.WHITE)); // adri
			fen.copyTab(board); // adri

			player=board.switchPlayer(player);

			fen.setPlayer(player); // adri

			if(board.marble_count(player)<=8 || board.marble_count(board.switchPlayer(player))<=8)
			{
				System.out.println("============Victory at "+i+" =============");
				break;
			}
		}

	}
}