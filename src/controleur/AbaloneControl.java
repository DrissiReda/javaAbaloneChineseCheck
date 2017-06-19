package controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;

import modele.BoardAbalone;
import modele.Config;
import modele.IA;
import vue.Panneau;

public class AbaloneControl{
	JFrame parent;
	BoardAbalone boardAB;
	Panneau pan;
	
	public AbaloneControl(JFrame parent, boolean IA) {
		this.parent = parent;
		pan = new Panneau();
		pan.setVisible(true);
		parent.getContentPane().add(pan);
		boardAB = new BoardAbalone();
		
		clickFunction(IA);
	}
	
	public void clickFunction(boolean IA){
		parent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					playAbalone(IA, e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	public void playAbalone(boolean IA, MouseEvent e) throws IOException{
		pan.click(e);
		// Quand on clique sur un bouton de mouvement
		if(pan.getConfirmDirection() != 0){

			boardAB.setTabPieces(pan.getTabPieces());

			//conversion de TabPiece (modele) avec GenerateMove
			if(boardAB.generateMove(boardAB.tabPieces,boardAB.getPlayer())!=null)
				boardAB.setTabPieces(boardAB.generateMove(boardAB.tabPieces, boardAB.getPlayer()));

			//execute le mouvement
			boardAB.executeMove(boardAB.tabPieces, boardAB.getPlayer());
			boardAB.displayBoard();

			//MISE A JOUR DES INDICATEURS DE BOULES RESTANTES
			pan.setMarbleLeftBlack(boardAB.marble_count(Config.Color.BLACK));
			pan.setMarbleLeftWhite(boardAB.marble_count(Config.Color.WHITE));

			//CHANGEMENT DE JOUEUR
			boardAB.switchPlayer();				

			//REINITIALISATION DU PLATEAU (VUE)
			pan.copyTab(boardAB);
			pan.reInit();

			//AFFICHAGE DU PLATEAU
			pan.refreshBoard();

			if(IA){
				executeAI();
			}
		}
	}

	public void executeAI(){
		IA computeur = new IA(boardAB);
		pan.refreshBoard();
		int d=pan.getDifficulty();
		String move;
		if(d<4)
			move = computeur.alphaBeta(d, d, Integer.MIN_VALUE, Integer.MAX_VALUE, "", boardAB.player, boardAB.player,Integer.MAX_VALUE);
		else
			if(d<=9)
				move = computeur.alphaBeta(4, 4, Integer.MIN_VALUE, Integer.MAX_VALUE, "", boardAB.player, boardAB.player,d+10);

			else
				move = computeur.alphaBeta(5, 5, Integer.MIN_VALUE, Integer.MAX_VALUE, "", boardAB.player, boardAB.player,17);
		boardAB.executeMove(boardAB.stringToMove(move.substring(0,boardAB.getMoveSize())),boardAB.player);

		boardAB.switchPlayer();
		pan.copyTab(boardAB);
		pan.reInit();
		pan.refreshBoard();
	}	
}
