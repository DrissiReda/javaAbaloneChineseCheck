package vue;

import javax.swing.*;
import java.awt.Color;
import modele.*;
import java.awt.EventQueue;

import java.awt.Font;

import modele.BoardAbalone;
import modele.DatabaseConnect;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayersNumberChoice extends JPanel {

	//Choix du nombre de joueurs.
	
	
	public PlayersNumberChoice(JFrame parent, String playerName, String game) {
		
		setLayout(null);
		setBackground(new java.awt.Color(245, 245, 245));
		
		
		JLabel labelMenu = new JLabel("MENU");
		labelMenu.setForeground(Color.BLACK);
		labelMenu.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		labelMenu.setBounds(426, 38, 480, 90);
		add(labelMenu);
		
		JLabel label = new JLabel("***");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		label.setBounds(469, 105, 33, 34);
		add(label);
		
		
		
		
		JButton bouton1Joueur = new JButton("1 JOUEUR");
		bouton1Joueur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//D?but partie.
				
				try {
					DatabaseConnect.saveGame(game, 1, 9, 13);
				} catch (Exception e) {
					e.printStackTrace();
				}



				setVisible(false);
					Fenetre fen;
				try {
					fen= new Fenetre();

				Panneau pan = new Panneau();
				BoardAbalone board=new BoardAbalone();
				int i=0;
	    		pan.setVisible(true);
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
						fen.setMarbleLeftBlack(board.marble_count(modele.Config.Color.BLACK));
						fen.setMarbleLeftWhite(board.marble_count(Config.Color.WHITE));

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
					parent.getContentPane().add(pan);

				}

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				}
		});
		bouton1Joueur.setBackground(UIManager.getColor("Button.background"));
		bouton1Joueur.setFont(new Font("Arial", Font.BOLD, 15));
		bouton1Joueur.setBounds(290, 224, 195, 65);
		add(bouton1Joueur);
		
		
		JButton bouton2Joueurs = new JButton("2 JOUEURS");
		bouton2Joueurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(game=="Abalone")
				{
					//D?but partie.
					
					try {
						DatabaseConnect.saveGame(game, 2, 9, 13);
					} catch (Exception e) {
						e.printStackTrace();
					}
					

				}
				
				if(game=="Dames chinoises")
				{
					//Choix 1 ou 2 ou 3 couleurs.
					setVisible(false);
					JPanel colorschoice = new ColorsChoice(parent, playerName,game,2);
					colorschoice.setVisible(true);
					colorschoice.setBounds(0,0,1000,600);
					parent.getContentPane().add(colorschoice);
					
					
				}
			}
		});
		bouton2Joueurs.setBackground(UIManager.getColor("Button.background"));
		bouton2Joueurs.setFont(new Font("Arial", Font.BOLD, 15));
		bouton2Joueurs.setBounds(535, 224, 195, 65);
		add(bouton2Joueurs);
		
		
		JLabel labelJoueur = new JLabel("Joueur : " + playerName);
		labelJoueur.setFont(new Font("Arial", Font.PLAIN, 17));
		labelJoueur.setBounds(22, 0, 366, 59);
		add(labelJoueur);
		
		
		if(game=="Abalone")
		{
			JLabel labelAbalone = new JLabel("ABALONE");
			labelAbalone.setForeground(Color.BLACK);
			labelAbalone.setFont(new Font("Synchro LET", Font.PLAIN, 50));
			labelAbalone.setBounds(390, 137, 431, 59);
			add(labelAbalone);
			
		}
		
		else if(game=="Dames chinoises")
		{
			JLabel labelDamesChinoises = new JLabel("DAMES CHINOISES");
			labelDamesChinoises.setForeground(Color.BLACK);
			labelDamesChinoises.setFont(new Font("Synchro LET", Font.PLAIN, 50));
			labelDamesChinoises.setBounds(280, 137, 431, 59);
			add(labelDamesChinoises);
			
			JButton bouton3Joueurs = new JButton("3 JOUEURS");
			bouton3Joueurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//Choix 1 ou 2 couleurs.
					setVisible(false);
					JPanel colorschoice = new ColorsChoice(parent, playerName, game,3);
					colorschoice.setVisible(true);
					colorschoice.setBounds(0,0,1000,600);
					parent.getContentPane().add(colorschoice);

				}
			});
			bouton3Joueurs.setBackground(UIManager.getColor("Button.background"));
			bouton3Joueurs.setFont(new Font("Arial", Font.BOLD, 15));
			bouton3Joueurs.setBounds(290, 300, 195, 65);
			add(bouton3Joueurs);
			
			JButton bouton4Joueurs = new JButton("4 JOUEURS");
			bouton4Joueurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//D?but partie.
					
					try {
						DatabaseConnect.saveGame(game, 4, 9, 13);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
				}
			});
			bouton4Joueurs.setBackground(UIManager.getColor("Button.background"));
			bouton4Joueurs.setFont(new Font("Arial", Font.BOLD, 15));
			bouton4Joueurs.setBounds(535, 300, 195, 65);
			add(bouton4Joueurs);
			
			JButton bouton5Joueurs = new JButton("5 JOUEURS");
			bouton5Joueurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					//D?but partie.
					
					try {
						DatabaseConnect.saveGame(game, 5, 9, 13);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			});
			bouton5Joueurs.setBackground(UIManager.getColor("Button.background"));
			bouton5Joueurs.setFont(new Font("Arial", Font.BOLD, 15));
			bouton5Joueurs.setBounds(290, 376, 195, 65);
			add(bouton5Joueurs);
			
			
			JButton bouton6Joueurs = new JButton("6 JOUEURS");
			bouton6Joueurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					//D?but partie.
					
					try {
						DatabaseConnect.saveGame(game, 6, 9, 13);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			});
			bouton6Joueurs.setBackground(UIManager.getColor("Button.background"));
			bouton6Joueurs.setFont(new Font("Arial", Font.BOLD, 15));
			bouton6Joueurs.setBounds(535, 376, 195, 65);
			add(bouton6Joueurs);

		}
		
		JButton boutonRetour = new JButton("RETOUR");
		boutonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JPanel panel6 = new Menu(parent, playerName, game);
				panel6.setVisible(true);
				panel6.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel6);
			}
		});
		boutonRetour.setFont(new Font("Arial", Font.BOLD, 15));
		boutonRetour.setBounds(185, 463, 150, 65);
		add(boutonRetour);
		
		
		JLabel label2 = new JLabel("");
		label2.setIcon(new ImageIcon("Images\\Fond2.png"));
		label2.setBounds(0, 0, 1000, 600);
		add(label2);
		


	}
}
