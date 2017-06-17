package controleur;

import java.awt.EventQueue;

import javax.swing.UnsupportedLookAndFeelException;

import modele.BoardAbalone;
import modele.Config.Color;
import modele.DatabaseConnect;
import modele.Tile;
import vue.Fenetre;
import vue.Panneau;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		DatabaseConnect db = new DatabaseConnect();
		db.getConnection();
		
            BoardAbalone board = new BoardAbalone();
            EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					Fenetre fen = new Fenetre();
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
            int i=100;


				//AlphaBeta a = new AlphaBeta(board);

				//String move=a.alphaBeta(3, 3, Integer.MIN_VALUE, Integer.MAX_VALUE, "",player, player);
				////System.out.println(move+" "+player);
				//board.executeMove(board.stringToMove(move.substring(0,board.moveSize)),player);

/*
            while(i-->0) {
                //CHOIX DES BOULES ET DE LA DIRECTION
                while (fen.getConfirmDirection() == 0) {
                	fen.refreshBoard();
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
            }*/
            
	}
}