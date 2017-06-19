package controleur;

import modele.BoardDC;
import modele.Config.Direction;
import modele.Coords;
import vue.PanneauDC;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlerDC {
	JFrame parent;
	BoardDC boardDC;
	PanneauDC pan;
	
	public ControlerDC(JFrame parent, String playerName, int nbPlayers, int nbColors, boolean IA) {
		this.parent = parent;
		pan = new PanneauDC();
		pan.setVisible(true);
		parent.getContentPane().add(pan);
		
		boardDC = new BoardDC();
		boardDC.setPseudo(playerName);
		
		boardDC.setCurrentPlayer(playerName); // changez cette valeur pour changer le joueur qui joue
        boardDC.initPlayers(nbColors, nbPlayers);
        boardDC.initBoard();
		boardDC.affichePlateau();
		pan.copyTab(boardDC);

		pan.affichePlateau();
		pan.displayPlayers(nbPlayers, boardDC.getPseudos(), boardDC.getColors());
		parent.addMouseListener(new MouseAdapter() {
			@Override

			// Quand on clique sur le Panel
			public void mouseClicked(MouseEvent e) {
                int switcher;
                //playDC returns true if a movement have been executed
                switcher = playDC(true, false, e);
                if (switcher == 2) {
                    //manages dynamic jump
                    while (true) {
                        if (playDC(true, true, e) != 2)
                            break;
                    }
                    boardDC.setJumping(false);

                }
                if (switcher != 0)
                    boardDC.switchPlayer();

            }
		});
		//clickFunction();
	}
	
	public void clickFunction(){ // add boolean IA
		
	}

    public int playDC(boolean IA, boolean flag, MouseEvent e) {
        pan.click(e);
        int ret = 0;
        if(pan.moveOk()){
			
			Coords marble = pan.getMarble();
			Coords target = pan.getTarget();
			Direction dir = pan.getDirection();

			Coords[] tabPieces={new Coords(22,22),new Coords(22,22),new Coords(88,88)};
			tabPieces[0] = marble;
			tabPieces[1] = target;
			tabPieces[2].x = 10+dir.ordinal();
			/*
			 * if(executeMove()== true ) #initiate jump sequence#{
 			 * 	int flag=1;
 			 * 	while(flag==1){
 			 *
 			 * 		if(generateDir().size()==0)
 			 * 			break;
 			 *	 	if(executeMove==false) # move was a simple, illegal, revert
			 * 			undo()
 			 */

			ret=boardDC.executeMove(tabPieces, boardDC.getCase(marble));
            if (flag && ret != 2)
                boardDC.undo(tabPieces,boardDC.getCase(marble));
			if(flag && boardDC.generateDir(tabPieces).size()==0)
                return 0;
            /*if(boardDC.executeMove(tabPieces,boardDC.getCase(marble))==false)
				boardDC.undo(tabPieces,boardDC.getCase(marble));*/
			pan.copyTab(boardDC);
			pan.reset();
			pan.refreshBoard();
		}
		return ret;
	}

}
