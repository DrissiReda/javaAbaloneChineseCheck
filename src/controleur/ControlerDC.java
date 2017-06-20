package controleur;

import modele.BoardDC;
import modele.Config;
import modele.Config.Direction;
import modele.Coords;
import modele.IA;
import vue.PanneauDC;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlerDC {
	JFrame parent;
	BoardDC boardDC;
	PanneauDC pan;
    boolean moveOk = false;

    public ControlerDC(JFrame parent, String playerName, int nbPlayers, int nbColors, boolean AI) {
		this.parent = parent;
		pan = new PanneauDC();
		pan.setAI(AI);
		pan.setVisible(true);
		parent.getContentPane().add(pan);
		
		boardDC = new BoardDC();
		boardDC.setPseudo(playerName);
		boardDC.setCurrentPlayer(playerName);
        boardDC.initPlayers(nbColors, nbPlayers);
        boardDC.initBoard();
        for (int i = 0; i < boardDC.getColors().size(); i++)
            System.out.println("I AAM" + boardDC.getColors().get(i) + " " + boardDC.getPseudos().get(i));
        boardDC.affichePlateau();
		pan.copyTab(boardDC);

		pan.affichePlateau();
		pan.displayPlayers(nbPlayers, boardDC.getPseudos(), boardDC.getColors());
        if (AI) {
            //executeIA();
        }
        parent.addMouseListener(new MouseAdapter() {
			@Override

			// Quand on clique sur le Panel
			public void mouseClicked(MouseEvent e) {
                //playDC returns true if a movement have been executed
				int switcher = playDC(false, false, e);
				if (switcher == 2) {
                    //manages dynamic jump
                    while (true) {
						if (playDC(false, true, e) != 2) {
							System.out.println("BREAAK");
							break;
						}
					}
                    boardDC.setJumping(false);

                }
                if (switcher != 0) {
                    boardDC.switchPlayer();
                    if (AI) ;
                    //executeIA();
                }
            }
		});
		//clickFunction();
        //clickFunction(IA);
    }

	public void clickFunction(boolean IA) { // add boolean IA
        parent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (IA)
                    if (moveOk) {
                        executeIA();
                    } else {
                        playDC(IA, false, e);
                    }
                else {
                    playDC(IA, false, e);
                }
            }
        });
    }

    public void executeIA() {
        moveOk = false;
        modele.IA computeur = new IA(boardDC);
		//pan.refreshBoard();
		int d = pan.getDifficulty();
        d = 4;
        String move;
        System.out.println("CURR" + boardDC.getCurrentplayer());
        if (d < 4)
            move = computeur.alphaBeta(d, d, Integer.MIN_VALUE, Integer.MAX_VALUE, "", Config.Color.GREEN, Config.Color.GREEN, Integer.MAX_VALUE);
        else if (d <= 9)
            move = computeur.alphaBeta(4, 4, Integer.MIN_VALUE, Integer.MAX_VALUE, "", Config.Color.GREEN, Config.Color.GREEN, Integer.MAX_VALUE);

		else
            move = computeur.alphaBeta(5, 5, Integer.MIN_VALUE, Integer.MAX_VALUE, "", Config.Color.GREEN, Config.Color.GREEN, Integer.MAX_VALUE);
        System.out.println("OUR MOVE" + move);
        boardDC.executeMove(boardDC.stringToMove(move.substring(0, 12)), Config.Color.GREEN);

		//MISE A JOUR DES INDICATEURS DE BOULES RESTANTES

		boardDC.switchPlayer();
		pan.copyTab(boardDC);
		pan.reset();
		pan.refreshBoard();
	}

    public int playDC(boolean IA, boolean flag, MouseEvent e) {
        pan.click(e);
        int ret = 0;
        if(pan.moveOk()){
            moveOk = true;
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
            /*if(ret==2)
				ret=playDC(IA,true,e);*/
            if (flag && ret != 2)
                boardDC.undo(tabPieces,boardDC.getCase(marble));
            if (flag && boardDC.generateDir(marble).size() == 0) {

                return 0;
            }
            /*if(boardDC.executeMove(tabPieces,boardDC.getCase(marble))==false)
				boardDC.undo(tabPieces,boardDC.getCase(marble));*/
			pan.copyTab(boardDC);
			pan.reset();
			pan.refreshBoard();
		}
		return ret;
	}

}
