package controleur;

import modele.BoardAbalone;
import modele.Config;
import modele.IA;
import vue.PanneauAbalone;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.BoardAbalone;
import modele.Config;
import modele.IA;
import vue.PanneauAbalone;

public class ControlerAbalone{
	JFrame parent;
	BoardAbalone boardAB;
	PanneauAbalone pan;
	boolean moveOk = false;

    public ControlerAbalone(JFrame parent, String playerName, boolean AI, String mode) {
        this.parent = parent;
		pan = new PanneauAbalone();
        pan.setName(playerName);

       	pan.setAI(AI);
		pan.setVisible(true);
		pan.buttonAI.setEnabled(false);
		parent.getContentPane().add(pan);
		if(mode == "standard")
			boardAB = new BoardAbalone();
		else{
			boardAB = new BoardAbalone(mode);
			System.out.println(mode);
		}
		
		pan.copyTab(boardAB);
			

        pan.setFrame(parent);
        parent.getContentPane().add(pan);

        pan.buttonAI.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	executeAI();
	        	pan.buttonAI.setEnabled(false);
	        }
	    });
		clickFunction(AI);
	}
	
	public void clickFunction(boolean IA){
		parent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
                    playAbalone(e);
                } catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	
	public void playAbalone(MouseEvent e) throws IOException{
		pan.click(e);
		// Quand on clique sur un bouton de mouvement
		if(pan.getConfirmDirection() != 0){
			moveOk = true;
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
            int i;
            if (boardAB.winner() != null) {
                if (boardAB.winner() == Config.Color.WHITE)
                	pan.endGame(true);
                else
                	pan.endGame(false);
            }


			//CHANGEMENT DE JOUEUR
			boardAB.switchPlayer();				

			//REINITIALISATION DU PLATEAU (VUE)
			pan.copyTab(boardAB);
			pan.reInit();

			//AFFICHAGE DU PLATEAU
			pan.refreshBoard();
			pan.buttonAI.setEnabled(true);
		}
	}


	public void executeAI(){
		moveOk = false;
		IA computeur = new IA(boardAB);
		//pan.refreshBoard();
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
		
		//MISE A JOUR DES INDICATEURS DE BOULES RESTANTES
		pan.setMarbleLeftBlack(boardAB.marble_count(Config.Color.BLACK));
		pan.setMarbleLeftWhite(boardAB.marble_count(Config.Color.WHITE));

		boardAB.switchPlayer();
		pan.copyTab(boardAB);
		pan.reInit();
		pan.refreshBoard();
	}	
}
