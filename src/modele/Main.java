package modele;

import modele.Config.Color;
import vue.Fenetre;

public class Main {

	public static void main(String[] args) {

/*
		BoardAbalone board = new BoardAbalone();
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
		System.out.println(board.AvailableMoves(Color.BLACK).length());
		System.out.println(board.getCase(new Coords(7,7)));
		switch(board.getCase(new Coords(7,7))){
			case EMPTY : System.out.print("0");
			default : System.out.println("1");
		}
		*/

            BoardAbalone board = new BoardAbalone();
            Fenetre fen = new Fenetre(); // adri
            int i=100;





				//AlphaBeta a = new AlphaBeta(board);

				//String move=a.alphaBeta(3, 3, Integer.MIN_VALUE, Integer.MAX_VALUE, "",player, player);
				////System.out.println(move+" "+player);
				//board.executeMove(board.stringToMove(move.substring(0,board.moveSize)),player);


            while(i-->0) {
                //CHOIX DES BOULES ET DE LA DIRECTION
                while (fen.getConfirmDirection() == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (fen.getConfirmDirection() != 0) {
                    //copie de TabPieces (Vue) dans Tab Pieces (Modele)
                    board.setTabPieces(fen.getTabPieces());
                    System.out.println("TABpieces modele non converti");
                    board.printTabPieces();

                    //conversion de TabPiece (modele) avec GenerateMove
                    board.setTabPieces(board.generateMove(board.tabPieces, board.getPlayer()));

                    //execute le mouvement
                    board.executeMove(board.tabPieces, board.getPlayer());
                    board.displayBoard();

                    //MISE A JOUR DES INDICATEURS DE BOULES RESTANTES
                    fen.setMarbleLeftBlack(board.marble_count(Color.BLACK));
                    fen.setMarbleLeftWhite(board.marble_count(Color.WHITE));

                    //CHANGEMENT DE JOUEUR
                    board.switchPlayer();

                    //REINITIALISATION DU PLATEAU (VUE)
                    fen.copyTab(board);
                    fen.reInit();

                    //AFFICHAGE DU PLATEAU
                    fen.refreshBoard();


                    if (board.marble_count(board.getPlayer()) <= 8 || board.marble_count(board.switchPlayer(board.getPlayer())) <= 8) {
                        System.out.println("============Victory at " + i + " =============");
                        //break;
                    }
                }
            }

	
	}


}