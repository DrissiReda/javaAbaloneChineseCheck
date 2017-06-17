package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.BoardDC;
import modele.Config;
import modele.DatabaseConnect;

public class ColorsChoice extends JPanel{

	//Choix du nombre de joueurs et lancement partie
	private PanneauDC pan;
	private BoardDC boardDC;
	
	public ColorsChoice(JFrame parent, String playerName, String game, int nbPlayers) {
		
		setLayout(null);
		setBackground(new Color(245, 245, 245));
		
		JLabel labelMenu = new JLabel("COULEURS");
		labelMenu.setForeground(Color.BLACK);
		labelMenu.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		labelMenu.setBounds(373, 42, 480, 90);
		add(labelMenu);
		
		JLabel label = new JLabel("PAR JOUEUR");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		label.setBounds(350, 104, 329, 75);
		add(label);
		
		
		JLabel labelJoueur = new JLabel("Joueur : " + playerName);
		labelJoueur.setFont(new Font("Arial", Font.PLAIN, 17));
		labelJoueur.setBounds(22, 0, 366, 59);
		add(labelJoueur);
		
		
		JButton boutonRetour = new JButton("RETOUR");
		boutonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JPanel panel = new PlayersNumberChoice(parent, playerName,game);
				panel.setVisible(true);
				panel.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel);
			}
		});
		boutonRetour.setFont(new Font("Arial", Font.BOLD, 15));
		boutonRetour.setBounds(185, 463, 150, 65);
		add(boutonRetour);
		
		JButton bouton1couleur = new JButton("1");
		bouton1couleur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				startGame(parent, nbPlayers, 1);
				
			}
		});
		bouton1couleur.setFont(new Font("Arial", Font.BOLD, 15));
		bouton1couleur.setBounds(373, 207, 235, 75);
		add(bouton1couleur);
		
		
		JButton bouton2couleurs = new JButton("2");
		bouton2couleurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				startGame(parent, nbPlayers, 2);
				
			}
		});
		bouton2couleurs.setFont(new Font("Arial", Font.BOLD, 15));
		bouton2couleurs.setBounds(373, 308, 235, 75);
		add(bouton2couleurs);
		
		
		JButton bouton3couleurs = new JButton("3");
		bouton3couleurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				startGame(parent, nbPlayers, 3);

			}
		});
		bouton3couleurs.setFont(new Font("Arial", Font.BOLD, 15));
		bouton3couleurs.setBounds(373, 409, 235, 75);
		
		if(nbPlayers == 2)
			add(bouton3couleurs);

		JLabel label2 = new JLabel("");
		label2.setIcon(new ImageIcon("Images\\Fond2.png"));
		label2.setBounds(0, 0, 1000, 600);
		add(label2);
	}
	
	
	public void startGame(JFrame parent, int nbPlayers, int nbColors){
		try {
			DatabaseConnect.saveGame("Dames chinoises", nbPlayers, 9, 13);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<Config.Color> listColors = new ArrayList<Config.Color>();
		for (Config.Color color : Config.Color.values()){ 
			if(color.ordinal() != 0 && color.ordinal() != 1) // On n'ajoute pas ILLEGAL et EMPTY
				listColors.add(color);
		}

		setVisible(false);
		pan = new PanneauDC();
		pan.setVisible(true);
		parent.getContentPane().add(pan);
		System.out.println(listColors);
		boardDC = new BoardDC();
		for (int i = 0; i < nbPlayers*nbColors; i++)
			boardDC.addPlayer(listColors.get(i));
			
		boardDC.initBoard();
		pan.copyTab(boardDC);
		
		pan.affichePlateau();
		parent.addMouseListener(new MouseAdapter() {
			@Override

			// Quand on clique sur le Panel
			public void mouseClicked(MouseEvent e) {

				playDC(true, e);
				

			}
		});
	}
	
	public void playDC(boolean IA, MouseEvent e){
		pan.click(e);
	}

}
