package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;

import modele.DatabaseConnect;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VariantChoice extends JPanel {

	//Choix de la variante.
	
	
	public VariantChoice(JFrame parent, String playerName, String game, int number_players, int couleur) {
		
		setLayout(null);
		setBackground(new Color(245, 245, 245));
		
		
		JLabel labelJoueur = new JLabel("Joueur : " + playerName);
		labelJoueur.setFont(new Font("Arial", Font.PLAIN, 17));
		labelJoueur.setBounds(22, 0, 366, 59);
		add(labelJoueur);
		
		JButton boutonMdp = new JButton("CHANGER MOT DE PASSE");
		boutonMdp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				JPanel panel9 = new PasswordChange(parent, playerName);
				panel9.setVisible(true);
				panel9.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel9);
				
			}
		});
		boutonMdp.setFont(new Font("Arial", Font.BOLD, 15));
		boutonMdp.setBounds(22, 42, 245, 27);
		add(boutonMdp);
		
		
		
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
		}
		
		
		
		JButton boutonAvecVariante = new JButton("AVEC VARIANTE");
		boutonAvecVariante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//Création tuple Partie -> idPartie, Joueur connecté, jeu, type, scores enregistrés à la fin.
				try {
					DatabaseConnect.saveGame(game, 0, 123,123);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
			}
		});
		boutonAvecVariante.setBackground(UIManager.getColor("Button.background"));
		boutonAvecVariante.setFont(new Font("Arial", Font.BOLD, 15));
		boutonAvecVariante.setBounds(290, 224, 195, 65);
		add(boutonAvecVariante);
		
		
		JButton boutonSansVariante = new JButton("SANS VARIANTE");
		boutonSansVariante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Création tuple Partie -> idPartie, idJoueur, jeu, nombrejoueurs, type, scores enregistrés à la fin.
				try {
					DatabaseConnect.saveGame(game, 0, 123,123);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
		boutonSansVariante.setBackground(UIManager.getColor("Button.background"));
		boutonSansVariante.setFont(new Font("Arial", Font.BOLD, 15));
		boutonSansVariante.setBounds(535, 224, 195, 65);
		add(boutonSansVariante);
		
		
		JButton boutonRetour = new JButton("RETOUR");
		boutonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JPanel panel7 = new PlayersNumberChoice(parent, playerName, game);
				panel7.setVisible(true);
				panel7.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel7);
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