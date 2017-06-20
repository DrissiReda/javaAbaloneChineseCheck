package controleur;

import modele.BoardAbalone;
import modele.DatabaseConnect;
import vue.Game;

import javax.swing.*;
import java.awt.*;

//import vue.Fenetre;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		DatabaseConnect db = new DatabaseConnect();
		db.getConnection();
		
            BoardAbalone board = new BoardAbalone();
            EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
						Game game = new Game();
					} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
	}
}