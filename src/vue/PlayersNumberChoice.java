package vue;

import modele.BoardAbalone;
import modele.Config;
import modele.DatabaseConnect;
import modele.IA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PlayersNumberChoice extends JPanel {

	private BoardAbalone boardAB;
	private Panneau pan;


	public PlayersNumberChoice(JFrame parent, String playerName, String game) {

		setLayout(null);
		setBackground(new Color(245, 245, 245));

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
				// Lancement Abalone
				
				/*
				try {
					DatabaseConnect.saveGame(game, 1, 9, 13);
				} catch (Exception e) {
					e.printStackTrace();
				}
				*/
				
				setVisible(false);
				pan = new Panneau();
				pan.setVisible(true);
				parent.getContentPane().add(pan);
				pan.setName(playerName);
				pan.setIA(true);

				boardAB = new BoardAbalone();
				
				parent.addMouseListener(new MouseAdapter() {
					@Override

					// Quand on clique sur le Panel
					public void mouseClicked(MouseEvent e) {

						try {
							playAbalone(true, e);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
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
					//D�but partie.

					/*
					try {
						DatabaseConnect.saveGame(game, 2, 9, 13);
					} catch (Exception e) {
						e.printStackTrace();
					}
					*/
					
					setVisible(false);
					pan = new Panneau();
					pan.setVisible(true);
					parent.getContentPane().add(pan);
					pan.setName(playerName);
					pan.setIA(false);
					
					boardAB = new BoardAbalone();

					parent.addMouseListener(new MouseAdapter() {
						@Override

						// Quand on clique sur le Panel
						public void mouseClicked(MouseEvent e) {

							try {
								playAbalone(false, e);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}
					});


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

					//Début partie.

					/*
					try {
						DatabaseConnect.saveGame(game, 4, 9, 13);
					} catch (Exception e) {
						e.printStackTrace();
					}
					*/

				}
			});
			bouton4Joueurs.setBackground(UIManager.getColor("Button.background"));
			bouton4Joueurs.setFont(new Font("Arial", Font.BOLD, 15));
			bouton4Joueurs.setBounds(535, 300, 195, 65);
			add(bouton4Joueurs);

			JButton bouton5Joueurs = new JButton("5 JOUEURS");
			bouton5Joueurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					//D�but partie.

					/*
					try {
						DatabaseConnect.saveGame(game, 5, 9, 13);
					} catch (Exception e) {
						e.printStackTrace();
					}
					*/

				}
			});
			bouton5Joueurs.setBackground(UIManager.getColor("Button.background"));
			bouton5Joueurs.setFont(new Font("Arial", Font.BOLD, 15));
			bouton5Joueurs.setBounds(290, 376, 195, 65);
			add(bouton5Joueurs);


			JButton bouton6Joueurs = new JButton("6 JOUEURS");
			bouton6Joueurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					//D�but partie.

					/*
					try {
						DatabaseConnect.saveGame(game, 6, 9, 13);
					} catch (Exception e) {
						e.printStackTrace();
					}
					*/

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
	
	public void playAbalone(boolean IA, MouseEvent e) throws FileNotFoundException, IOException{
		boardAB.setIA(IA);
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