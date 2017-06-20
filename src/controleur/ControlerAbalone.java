package controleur;

import modele.BoardAbalone;
import modele.Config;
import modele.IA;
import vue.Endgame;
import vue.PanneauAbalone;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ControlerAbalone{
	JFrame parent;
	BoardAbalone boardAB;
	PanneauAbalone pan;
	boolean moveOk = false;

    public ControlerAbalone(JFrame parent, String playerName, boolean IA) {
        this.parent = parent;
		pan = new PanneauAbalone();
        pan.setName(playerName);

		pan.setVisible(true);
        pan.setFrame(parent);
        parent.getContentPane().add(pan);
		boardAB = new BoardAbalone();
		clickFunction(IA);
	}
	
	public void clickFunction(boolean IA){
		parent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
                    if (IA)
                        if (moveOk) {
                            executeAI();
                        } else {
                            playAbalone(e);
                        }
                    else {
                        playAbalone(e);
                    }
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
            if (boardAB.winner() == null)
                EndWhite();

			//CHANGEMENT DE JOUEUR
			boardAB.switchPlayer();				

			//REINITIALISATION DU PLATEAU (VUE)
			pan.copyTab(boardAB);
			pan.reInit();

			//AFFICHAGE DU PLATEAU
			pan.refreshBoard();
		}
	}

    public void EndWhite() {
        System.out.println("WINNING");
        //Endgame end=new Endgame(boardAB.marble_count(Config.Color.WHITE),boardAB.marble_count(Config.Color.BLACK),true,boardAB.getName());
        Endgame end = new Endgame();
        end.affiche(boardAB.marble_count(Config.Color.WHITE), boardAB.marble_count(Config.Color.BLACK), true, boardAB.getName());
        end.setVisible(true);
        end.setBounds(0, 0, 1000, 600);
        parent.getContentPane().add(end);
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
